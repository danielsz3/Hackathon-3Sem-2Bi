import { Router } from "express"

import usuario from './paciente'
import agenteSaude from './agenteSaude'

const routes = Router()

routes.use('/usuarios', usuario)
routes.use('/agenteSaude', agenteSaude)

export default routes
