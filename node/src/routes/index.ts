import { Router } from "express"

import paciente from './paciente'
import agenteSaude from './agenteSaude'
import agendamentovisita from './agendamentovisita'

const routes = Router()

routes.use('/paciente', paciente)
routes.use('/agenteSaude', agenteSaude)
routes.use('/agendamentovisita', agendamentovisita)

export default routes
