const path = require('path')

module.exports = {
    development: {
        client: 'mysql',
        connection: {
            host: '127.0.0.1',
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
                'database',
                'knex',
                'migrations'
            )
        },
        useNullAsDefault: true
    }
}
