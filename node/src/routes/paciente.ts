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

    const registerBodySchema = z.object({
        id_endereco: z.number(),
        nome: z.string({ message: "Nome Obrigatorio" }).max(100).min(8),
        dataNascimento: z.string().max(10),
        cpf: z.string({ message: "CPF Obrigatorio" }).max(11),
        cns: z.string({ message: "CNS Obrigatorio" }).max(15),
        celular: z.string({ message: "Celular Obrigatorio" }).max(11),
        email: z.string({ message: "Email Obrigatorio" }).max(50),
        nomeCuidador: z.string({ message: "Nome do cuidador Obrigatorio" }).max(100).min(6),
        telefoneCuidador: z.string({ message: "Teleforne do Cuidador Obrigatorio" }).max(11)
    })
    const objSalvar = registerBodySchema.parse(req.body)
/*
    async function obterUltimoIdEndereco(): Promise<number> {
        const id_ultimo_endereco = await knex('endereco')
            .select<number[]>('id')
            .orderBy('id', 'desc')
            .first()

        const ultimoId = Number(id_ultimo_endereco)
        const id_endereco = ultimoId.toString().replace(/[^0-9]/g, '');
        console.log('Maior ID da tabela "endereço":', ultimoId, id_ultimo_endereco)
        return parseInt(id_endereco);
    }

    (async () => {
        try {
            const ultimoId = await obterUltimoIdEndereco();
            console.log('Maior ID da tabela "endereço":', ultimoId)
            if (ultimoId !== undefined) {
                objSalvar.id_endereco = ultimoId;
                console.log("ID inserido:", ultimoId);
            } else {
                throw new AppError("Não foi possível obter o último ID de endereço.", 404);
            }
        } catch (error) {
            console.error("Erro ao obter o último ID de endereço:", AppError);
        }
    })();
*/


    if (!objSalvar?.id_endereco) {
        throw new AppError("Id endereço Obrigatório")
    }

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
    res.json({ message: "Paciente Salvar"})


})


router.get('/', (req, res) => {
    knex('paciente').then((resposta) => {
        res.json({ endereco: resposta })
    })

})

router.get('/id', async (req: Request, res: Response) => {
    try {
        const maxIdResult = await knex('paciente').max('id as maxId').first();

        if (maxIdResult && maxIdResult.maxId !== null) {
            const maxId = parseInt(maxIdResult.maxId); // Converter para número inteiro

            res.json({ id: maxId }); // Retorna apenas o campo ID
        } else {
            res.status(404).json({ error: 'Nenhum endereço paciente' });
        }
    } catch (error) {
        console.error('Erro ao buscar maior ID de paciente:', error);
        res.status(500).json({ error: 'Erro interno ao buscar maior ID de paciente' });
    }
});


router.get('/:cns', async (req, res) => {
    const cns = req.params.cns;

    try {
        const paciente = await knex('paciente').where({ cns }).first();
        if (paciente) {
            res.json({ paciente });
        } else {
            res.status(404).json({ message: 'Paciente não encontrado' });
        }
    } catch (error) {
        console.error('Erro ao consultar paciente:', error);
        res.status(500).json({ message: 'Erro interno do servidor' });
    }
});

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
