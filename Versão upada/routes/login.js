const express = require('express')
const mysql = require('mysql')
const route = express.Router()

route.use(express.urlencoded({extended: true}))
route.use(express.json())

const conexao = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'univille',
    database: 'dimatti'
})

conexao.connect((err) => {
    
    if(err){
        console.log('Deu erro na conexão')
    }

})

route.get('/', (req,res) => {
    res.render('login')
})
route.post('/', (req,res) => {
    const email = req.body.email
    const senha = req.body.senha

    const query = `SELECT * FROM login`
    conexao.query(query, (err, data) => {
        if(err){
            console.log('erro na procura do banco')
        }

        const cadastros = data
        console.log(cadastros)
        
    })
    res.render('login')
})

module.exports = route



