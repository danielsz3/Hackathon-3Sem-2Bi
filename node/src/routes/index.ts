import { Router } from "express"

import usuario from './usuario'
import session from './session'

const routes = Router()

routes.use('/usuarios', usuario)
routes.use('/session', session)

export default routes
