import {instance} from "../../config/app.config";


class AuthService {

    login() {
        return instance.post("/auth/login")
    }

    refreshToken() {
        return instance.get("/auth/refresh");
    }
}

export const authService = new AuthService()
