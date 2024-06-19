import Router, {Request, Response} from "express"
import knex from "../database/knex"


const routes = Router()

routes.post("/", (req: Request, res: Response) => {
    const objSalvar = req.body

    knex('categorias').insert(objSalvar)
        .then(() =>{
            res.json({message: "Categoria Salvar"})
        })
})

routes.put("/", (req: Request, res: Response) => {
    const objSalvar = req.body

    knex('categorias').insert(objSalvar)
        .then(() =>{
            res.json({message: "Categoria Salvar"})
        })
})

routes.delete("/", (req: Request, res: Response) => {
    const objSalvar = req.body

    knex('categorias').insert(objSalvar)
        .then(() =>{
            res.json({message: "Categoria Salvar"})
        })
})
routes.get("/", (req, res) => {
    knex('categorias').then((resposta) =>{

        res.json({categorias: resposta})
    })
})

export default routes
