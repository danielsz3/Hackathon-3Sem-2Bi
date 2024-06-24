const path = require('path')

module.exports = {
    development: {
        client: 'mysql',
        connection: {
            host: '127.0.0.1',
            port: 8081,
            user: 'root',
            password: '',
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
