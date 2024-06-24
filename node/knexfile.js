const path = require('path')

module.exports = {
    development: {
        client: 'mysql',
        connection: {
            host: 'localhost',
            port: 3333,
            user: 'root',
            password: 'daniel',
            database: 'dbvacinacao2',
            insecureAuth: true,
        },
        migrations: {
            directory: path.resolve(
                __dirname,
                'src',
                'knex',
                'migrations'
            )
        },
        useNullAsDefault: true
    }
}
