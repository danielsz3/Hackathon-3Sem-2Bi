class AppError {
    message
    statusCode

    constructor(message: string, statusCode = 400) {
        this.message = message
        this.statusCode = statusCode
    }

    static notFound(message: string) {
        return new AppError(message, 404)
    }
}

export default AppError
