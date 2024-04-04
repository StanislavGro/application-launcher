import axios from "axios";
import {authService} from "../core/service/AuthService";

export const instance = axios.create({
    // Cookie
    withCredentials: true,
    baseURL: "http://localhost:8080/",
})

/**
 * Request interceptor
 * Set all request accessToken from localStorage
 */
instance.interceptors.request.use(
    (config) => {
        config.headers.Authorization = `Bearer ${localStorage.getItem("token")}`
        return config
    }
)

/**
 * Response interceptor
 */
instance.interceptors.response.use(
    (config) => {
        return config
    },
    async (error) => {
        const originalRequest = {...error.config};
        originalRequest._isRetry = true;
        if (
            error.response.status === 401 &&
            error.config &&
            !error.config._isRetry
        ) {
            try {
                const response = await authService.refreshToken()
                localStorage.setItem("token", response.data.accessToken);

                return instance.request(originalRequest)
            } catch (error) {
                console.log("Authorization error..")
            }
        }

        throw error
    }
)