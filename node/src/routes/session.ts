import Router from 'express'
import knex from '.././database/knex'
import AppError from '../utils/AppError'
import { compare } from 'bcryptjs'

const router = Router()

router.post('/', async (req, res) => {
    const { email, senha } = req.body

    const user = await knex('usuarios').where({
        email
    }).first()

    if (!user) {
        throw new AppError('Email ou senha incorreta')
    }

    const senhaIsIgual = await compare(senha, user.senha)

    if (!senhaIsIgual) {
        throw new AppError('Email ou senha incorreta')
    }

})

export default router
