import config from '../../../knexfile'

import knex from 'knex'

const conexao = knex(config.development)

export default conexao
