import { Router } from "express"

import paciente from './paciente'
import agenteSaude from './agenteSaude'
import endereco from './endereco'

const routes = Router()

routes.use('/paciente', paciente)
routes.use('/agenteSaude', agenteSaude)
routes.use('/endereco', endereco)

export default routes
