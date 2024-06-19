import { Router } from "express"

import categoria from './categoria'
import usuario from './usuario'
import session from './session'
import authenticacao from "../middlewares/authenticacao"

const routes = Router()

routes.use('/usuarios', usuario)
routes.use(authenticacao)
routes.use('/categorias', categoria)
routes.use('/session', session)

export default routes
