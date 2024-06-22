const path = require('path')

module.exports = {
    development: {
        client: 'mysql',
        connection: {
            host: 'localhost',
            port: 3306,
            user: 'root',
            password: '',
            database: 'dbVacinacao',
        },
        migrations: {
            directory: path.resolve(
                __dirname,
                'src',
                'database',
                'knex',
                'migrations'
            )
        },
        useNullAsDefault: true
    }
}
