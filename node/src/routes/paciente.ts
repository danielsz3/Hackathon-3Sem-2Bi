import Router, { Request, Response } from "express"
import knex from "../knex"
import AppError from "../utils/AppError";
import { z } from "zod"


const router = Router();

const registerBodySchema = z.object({
    id_endereco: z.number(),
    nome: z.string({ message: "Nome obrigatório" }).max(100).min(8),
    dataNascimento: z.string().max(10),
    cpf: z.string({ message: "CPF obrigatório" }).max(11),
    cns: z.string({ message: "CNS obrigatório" }).max(15),
    celular: z.string({ message: "Celular obrigatório" }).max(11),
    email: z.string({ message: "Email obrigatório" }).max(50),
    nomeCuidador: z.string({ message: "Nome do cuidador obrigatório" }).max(100).min(6),
    telefoneCuidador: z.string({ message: "Telefone do cuidador obrigatório" }).max(11)
});

router.post("/", async (req: Request, res: Response) => {
    try {
        const objSalvar = registerBodySchema.parse(req.body);

        // Verificar se o ID de endereço existe na tabela `endereco`
        const enderecoExiste = await knex('endereco')
            .where('id', objSalvar.id_endereco)
            .first();

        if (!enderecoExiste) {
            throw new AppError("ID de endereço não encontrado na tabela 'endereco'", 404);
        }

        // Inserir o paciente no banco de dados
        const id_paciente = await knex('paciente').insert(objSalvar);

        // Recuperar o paciente recém-inserido para responder à requisição
        const paciente = await knex('paciente').where({ id: id_paciente[0] }).first();

        res.json({ message: "Paciente salvo com sucesso", paciente });
    } catch (error) {
        if (error instanceof AppError) {
            res.status(error.statusCode).json({ error: error.message });
        } else {
            console.error("Erro ao inserir paciente:", error);
            res.status(500).json({ error: "Erro interno do servidor" });
        }
    }
});



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

    res.json({ message: 'Paciente deletado com sucesso' })

})


export default router
