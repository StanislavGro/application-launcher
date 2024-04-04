import axios from "axios";

export const instanse = axios.create({
    // Cookie
    withCredentials: true,
    baseURL: "http://localhost:8080/",
})

/**
 * Request interceptor
 * Set all request accessToken from localStorage
 */
instanse.interceptors.request.use(
    (config) => {
        config.headers.Authorization = `Bearer ${localStorage.getItem("token")}`
        return config
    }
)

/**
 * Response interceptor
 */
instanse.interceptors.response.use(
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
                const resp = await instanse.get("/api/refresh")
                localStorage.setItem("token", resp.data.accessToken);

                return instanse.request(originalRequest)
            } catch (error) {
                console.log("Authorization error..")
            }
        }

        throw error
    }
)