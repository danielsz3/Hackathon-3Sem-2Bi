import { Router } from "express"

import usuario from './paciente'
import session from './session'
import agenteSaude from './agenteSaude'

const routes = Router()

routes.use('/usuarios', usuario)
routes.use('/session', session)
routes.use('/agenteSaude', agenteSaude)

export default routes
