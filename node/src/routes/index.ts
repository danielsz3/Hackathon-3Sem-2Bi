import { Router } from "express"

import paciente from './paciente'
import agenteSaude from './agenteSaude'
import agendamentovisita from './agendamentovisita'
import endereco from './endereco'
import vacina from './vacina'
import prontuario from './prontuario'

const routes = Router()

routes.use('./paciente', paciente)
routes.use('./agenteSaude', agenteSaude)
routes.use('./agendamentovisita', agendamentovisita)
routes.use('./endereco', endereco)
routes.use('./vacina', vacina)
routes.use('./prontuario', prontuario)

export default routes
