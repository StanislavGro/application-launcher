import {instanse} from "../config/app.config";


class AuthService {

    refreshToken() {
        return instanse.get("/api/refresh");
    }
}