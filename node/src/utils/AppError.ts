class AppError extends Error {
    public readonly message: string
    public readonly statusCode: number
    public readonly campo?: string

    constructor(message: string, statusCode = 400, campo?: string) {
        super(message)
        this.message = message
        this.statusCode = statusCode
        this.campo = campo
    }

    static notFound(message: string) {
        return new AppError(message, 404)
    }
}

export default AppError
