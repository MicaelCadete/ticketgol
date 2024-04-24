var formSignin = document.querySelector('#signin')
var formSignup = document.querySelector('#signup')
var btnColor = document.querySelector('.btnColor')

document.querySelector('#btnSignin')
  .addEventListener('click', () => {
    formSignin.style.left = "25px"
    formSignup.style.left = "450px"
    btnColor.style.left = "0px"
  })

document.querySelector('#btnSignup')
  .addEventListener('click', () => {
    formSignin.style.left = "-450px"
    formSignup.style.left = "25px"
    btnColor.style.left = "110px"
  })

function cadastrar() {
  var nomeCadastro = document.getElementById('nomeCliente').value;
  var emailCadastro = document.getElementById('email').value;
  var telefoneCadastro = document.getElementById('telefone').value;
  var dnCadastro = document.getElementById('dataDeNascimento').value;
  var senhaCadastro = document.getElementById('senhaCliente').value;

  var regNomeCadastro = /^([A-Za-záàâãéêíóôõúç']+)( )([\w']+)$/;
  var regexEmailCadastro = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  var regexTelefoneCadastro = /^\(\d{2}\) \d{4,5}-\d{4}$/;
  var regexDnCadastro = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/;
  var regexSenhaCadastro = /^[a-zA-Z0-9]{8,}$/;


  if (!regNomeCadastro.test(nomeCadastro)) {
    swal("Atenção", "Informe um Nome corretamente!", "warning");
    return false;
  }

  if (!regexEmailCadastro.test(emailCadastro)) {
    swal("Atenção", "Informe um Email corretamente!", "warning");
    return false;
  }

  if (!regexTelefoneCadastro.test(telefoneCadastro)) {
    swal("Atenção", "Informe um Telefone corretamente!", "warning");
    return false;
  }

  if (!regexDnCadastro.test(dnCadastro)) {
    swal("Atenção", "Informe uma Data corretamente!", "warning");
    return false;
  }

  if (!regexSenhaCadastro.test(senhaCadastro)) {
    swal("Atenção", "Informe uma Senha corretamente!", "warning");
    return false;
  }

  return true;

}

document.addEventListener("DOMContentLoaded", function (event) {
  var fmFormCadastro = document.getElementById("signup");
  fmFormCadastro.addEventListener("submit", function (e) {
    e.preventDefault();

    if (cadastroRegex()) {
      var fmNomeCadastro = document.getElementById("nomeCliente").value;
      var fmEmailCadastro = document.getElementById("email").value;
      var fmTelefoneCadastro = document.getElementById("telefone").value;
      var fmDnCadastro = document.getElementById("dataDeNascimento").value;
      var fmSenhaCadastro = document.getElementById("senhaCliente").value;

      var cadastros = [];

      if (localStorage.hasOwnProperty("cadastros")) {
        cadastros = JSON.parse(localStorage.getItem("cadastros"));
      }

      cadastros.push({

        nomeCadastro: fmNomeCadastro,
        emailCadastro: fmEmailCadastro,
        telefoneCadastro: fmTelefoneCadastro,
        dnCadastro: fmDnCadastro,
        senhaCadastro: fmSenhaCadastro,

      });

      localStorage.setItem("cadastros", JSON.stringify(cadastros));

      swal("Obrigado", "Cadastro Concluído!", "success");
      window.location.href = "Login.html";

    } else {
      swal("Atenção", "Erro no Cadastro!", "error");
    }
  });
});

document.addEventListener("DOMContentLoaded", function () {

  function logar() {

    var fmEmail = document.getElementById("emailLogin").value;
    var fmSenha = document.getElementById("senhaLogin").value;

    var cadastros = JSON.parse(localStorage.getItem("cadastros")) || [];

    var usuarioEncontrado = cadastros.find(function (usuario) {

      return usuario.email === fmEmail && usuario.senha === fmSenha;

    });

    if (usuarioEncontrado) {

      swal("Obrigado", "Login Concluído!", "success");

      localStorage.setItem("usuarioLogado", JSON.stringify(usuarioEncontrado));
      window.location.href = "Home.html";

    } else {

      swal("Atenção", "Erro no Login!", "error");

    }

  }

  var btnLogin = document.querySelector(".btn-login");

  btnLogin.addEventListener("click", function (e) {

    e.preventDefault();
    logar();

  });

  var btnCadastro = document.querySelector(".btn-cadastro");

  btnCadastro.addEventListener("click", function (e) {

    e.preventDefault();
    cadastrar();

  });
});
