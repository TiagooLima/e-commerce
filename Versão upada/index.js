const express = require('express')
const mysql = require('mysql')
const exphbs = require('express-handlebars')
const hbs = exphbs.create({partialsDir: ['views/partials']})

const app = express()
app.engine('handlebars', hbs.engine)
app.set('view engine', 'handlebars')

app.use(express.static('public'))
//rota login
const rotalogin = require('./routes/login')
app.use('/login', rotalogin)

//rota principal
app.get('/', (req,res) => {
    res.render('home')
})

const port = 3000
app.listen(port, () => {
    console.log(`Servidor rodando na porta ${port}`)
})