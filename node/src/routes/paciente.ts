import Router, { Request, Response } from "express"
import knex from "../database/knex"
import AppError from "../utils/AppError";
import { hash } from 'bcrypt'
import { z } from "zod"

const router = Router();


// Promise - async

router.post("/paciente", async (req: Request, res: Response) => {

    const registerBodySchema = z.object({
       // id_endereco: ,
        nome: z.string({ message: "Nome Obrigatorio" }).max(100).min(8),
        dataNascimento: z.date(),
        cpf: z.string({ message: "CPF Obrigatorio" }).max(11),
        cns: z.string({ message: "CNS Obrigatorio" }).max(15),
        celular: z.string({ message: "Celular Obrigatorio" }).max(11),
        email: z.string({ message: "Email Obrigatorio" }).max(50),
        nomeCuidador: z.string({ message: "Nome do cuidador Obrigatorio" }).max(100).min(6),
        telefoneCuidador: z.string({ message: "Teleforne do Cuidador Obrigatorio" }).max(11)
    })


    const objSalvar = registerBodySchema.parse(req.body)

    if (!objSalvar?.nome) {
        throw new AppError("Nome Obrigatório")
    }
    if (!objSalvar?.dataNascimento) {
        throw new AppError("Data de Nascimento Obrigatório")
    }
    if (!objSalvar?.cpf) {
        throw new AppError("CPF Obrigatório")
    }
    if (!objSalvar?.cns) {
        throw new AppError("CNS Obrigatório")
    }
    if (!objSalvar?.celular) {
        throw new AppError("Celular Obrigatório")
    }
    if (!objSalvar?.email) {
        throw new AppError("Email Obrigatório")
    }
    if (!objSalvar?.nomeCuidador) {
        throw new AppError("Nome Cuidador Obrigatório")
    }
    if (!objSalvar?.telefoneCuidador) {
        throw new AppError("Telefone Cuidador Obrigatório")
    }


    const id_paciente = await knex('paciente').insert(objSalvar)
    const paciente = await knex('paciente').where({ id: id_paciente[0] })
    res.json({ message: "Paciente Salvar" })

})


router.get('/', (req, res) => {
    knex('paciente').then((resposta) => {
        res.json({ endereco: resposta })
    })

})


router.put('/:id', async (req, res) => {

    const registerBodySchema = z.object({
        nome: z.string({ message: "Nome Obrigatorio" }).max(100).min(8),
        dataNascimento: z.date(),
        cpf: z.string({ message: "CPF Obrigatorio" }).max(11),
        cns: z.string({ message: "CNS Obrigatorio" }).max(15),
        celular: z.string({ message: "Celular Obrigatorio" }).max(11),
        email: z.string({ message: "Email Obrigatorio" }).max(50),
        nomeCuidador: z.string({ message: "Nome do cuidador Obrigatorio" }).max(100).min(6),
        telefoneCuidador: z.string({ message: "Teleforne do Cuidador Obrigatorio" }).max(11)
    })


    const objSalvar = registerBodySchema.parse(req.body)

    const { id } = req.params

    let paciente = await knex('paciente').where({ id }).first()

    if (!paciente?.id) {
        throw new AppError('Paciente nâo encontrado!')
    }

    let newPaciente = {
        ...paciente,
        ...objSalvar
    }

    await knex('paciente').update(newPaciente).where({ id: paciente.id })

    return res.json({
        message: 'Paciente alterado com sucesso'
    })

})


router.delete('/:id', async (req, res) => {
    const { id } = req.params

    const paciente = await knex('paciente').where({ id }).first()

    if (!paciente) {
        throw new AppError('Paciente não encontrado', 404)
    }

    await knex('paciente').where({ id }).delete()

    res.json({ message: 'Paciente deletado com sucesso'})

})


export default router
