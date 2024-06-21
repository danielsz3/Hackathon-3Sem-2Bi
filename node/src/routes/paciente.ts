import Router, { Request, Response } from "express"
import knex from "../database/knex"
import AppError from "../utils/AppError";
import { hash } from 'bcrypt'
import { z } from "zod"

const router = Router();


// Promise - async

router.post("/paciente", async (req: Request, res: Response) => {

    const registerBodySchema = z.object({
        nome: z.string({message:"Nome Obrigatorio"}).max(100),
        dataNascimento: z.date(),
        cpf: z.string({message:"CPF Obrigatorio"}).max(11),
        cns: z.string({message:"CNS Obrigatorio"}).max(15),
        celular: z.string({message:"Celular Obrigatorio"}).max(11),
        email:  z.string({message:"Email Obrigatorio"}).max(50),
        nomeCuidador: z.string({message:"Nome do cuidador Obrigatorio"}).max(100),
        telefoneCuidador: z.string({message:"Teleforne do Cuidador Obrigatorio"}).max(11)
    })


    const objSalvar = registerBodySchema.parse(req.body)

    if(!objSalvar?.nome){
        throw new AppError("Nome Obrigatório")
    }
    if(!objSalvar?.dataNascimento){
        throw new AppError("Data de Nascimento Obrigatório")
    }
    if(!objSalvar?.cpf){
        throw new AppError("CPF Obrigatório")
    }
    if(!objSalvar?.cns){
        throw new AppError("CNS Obrigatório")
    }
    if(!objSalvar?.celular){
        throw new AppError("Celular Obrigatório")
    }
    if(!objSalvar?.email){
        throw new AppError("Email Obrigatório")
    }
    if(!objSalvar?.nomeCuidador){
        throw new AppError("Nome Cuidador Obrigatório")
    }
    if(!objSalvar?.telefoneCuidador){
        throw new AppError("Telefone Cuidador Obrigatório")
    }


    const id_paciente = await knex('paciente').insert(objSalvar)
    const paciente = await knex('paciente').where({ id: id_paciente[0] })   
    res.json({ message: "Paciente Salvar"})

})


router.get('/', (req, res) => {
    
    
})


router.put('/:id', async (req, res) => {


})


router.delete('/:id', async (req, res) => {


})


export default router
