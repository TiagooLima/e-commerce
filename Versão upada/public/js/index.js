//Botoes
let botaoTrocarParaLogin = document.querySelector('#trocarParaLogin')
let botaoTrocarParaSignin = document.querySelector('#trocarParaSignin')
let botaoCadastrar =document.querySelector('#botaoCadastrar')
//Telas - login e signin
let telaLogin = document.querySelector('#card_login')
let telaCadastro = document.querySelector('#card_signin')

//Quando clica no botao - Vai para a tela de Log-in
botaoTrocarParaLogin.addEventListener('click', function(){
    telaCadastro.classList.add("escondido")
    telaLogin.classList.remove("escondido")
})
//Quando clica no botao - Vai para a tela de Sign-in
botaoTrocarParaSignin.addEventListener('click', function(){
    telaLogin.classList.add("escondido")
    telaCadastro.classList.remove("escondido")
})
