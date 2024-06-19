import Router, { Request, Response } from "express"
import knex from "../database/knex"
import AppError from "../utils/AppError";
import { hash } from 'bcrypt'
import { z } from "zod"


//Importar o zod, comando no console é = npm i zod




const router = Router();


// Promise - async

router.post("/", async (req: Request, res: Response) => {

    const registerBodySchema = z.object({
        nome: z.string(),
        email: z.string().email(),
        senha: z.string({message:"Senha Obrigatória"}).min(6)
    })

    const objSalvar = registerBodySchema.parse(req.body)

    if (!objSalvar?.senha) {
        throw new AppError("Senha Obrigatória")
    }



    objSalvar.senha = await hash(objSalvar.senha, 8)

    const id_usuario = await knex('usuarios').insert(objSalvar)

    const usuarios = await knex('usuarios').where({ id: id_usuario[0] })

    res.json({ message: "Usuarios Salvar" })
})



router.get('/', (req, res) => {
    knex('usuarios').then((resposta) => {
        res.json({ usuario: resposta })
    })
})

router.put('/:id', async (req, res) => {
    const objSalvar = req.body

    const { id } = req.params

    if (objSalvar?.senha) {
        objSalvar.senha = await hash(objSalvar.senha, 8)
    }

    let usuario = await knex('usuarios').where({ id }).first()

    if (!usuario?.id) {
        throw new AppError('Usuário nâo encontrado!')
    }

    let newUsuario = {
        ...usuario,
        ...objSalvar
    }

    await knex('usuarios').update(newUsuario).where({ id: usuario.id })

    return res.json({
        message: `Usuario aleatorio com Sucesso`
    })

})

router.delete('/:id', async (req, res) => {
    const { id } = req.params

    const usuario = await knex('usuarios').where({ id }).first()

    if (!usuario) {
        throw new AppError('Usuario não encontrado', 404)
    }



    await knex('usuarios').where({ id }).delete()

    res.json({ message: 'Usuario deletado com sucesso' })
})

export default router
