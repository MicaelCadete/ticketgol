<!DOCTYPE html>
<html lang="PT-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page contentType="text/html; charset=UTF-8" %>

    <head>
      <!-- Metadados e configurações iniciais -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />

      <!-- Título da página e ícone -->
      <title>TicketGol</title>
      <link rel="icon" type="image/x-icon" href="Jogos/img/img-icone2.png" />

      <!-- Configurações de visualização e estilos -->
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" type="text/css" media="screen" href="Jogos/css/JogosADM.css" />

      <!-- Fontes e ícones -->
      <link rel="preconnect" href="https://fonts.googleapis.com" />
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
      <link
        href="https://fonts.googleapis.com/css2?family=Outfit:wght@300&family=Roboto+Mono:ital,wght@0,100..700;1,100..700&display=swap"
        rel="stylesheet" />
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
      <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    </head>

    <body>
      <!-- Cabeçalho da página -->
      <header>
        <!-- Logo e links de navegação -->
        <a href="Home.html">
          <img src="Jogos/img/img-logo3.png" class="logo">
        </a>
        <ul>
          <!-- Links de navegação -->
          <li><a href="/lista-eventos2">Jogos</a></li>
          <li><a href="JogosCadastro.html">Cadastrar Jogo</a></li>
        </ul>
        <!-- Botão de login -->
        <button class="btn">
          <a href="Login.html" class="btn">
            <img src="Home/img/img-iconeUser.png" alt="Entrar">Login
          </a>
        </button>
      </header>

      <!-- Seção de jogos -->

      <section id="jogos">
        <div class="container">
          <!-- Cards de jogos -->
          <div class="row">
            <div class="card-pt1">
              <!-- Variável para controlar a contagem de cartões -->
              <c:set var="count" value="0" />
              <c:forEach var="evento" items="${dados}" varStatus="loop">
                <!-- Verificar se o índice é divisível por 4 para começar uma nova linha -->
                <c:if test="${loop.index % 4 == 0}">
                </c:if>
                <div class="card">
                  <div class="image-box">
                    <img src="Jogos/img/img-fundoBrasileirao.jpg" alt="">
                  </div>
                  <!-- Conteúdo do card -->
                  <div class="content">
                    <h1>Brasileirão</h1>
                    <h2>${evento.nomeEvento}</h2>
                    <p>${evento.data}</p>
                    <p>${evento.horario}</p>
                    <p>Estádio: ${evento.local}</p>
                    <p>Ingressos Disponíveis: ${evento.qtdDisponivel}</p>
                    <!-- Botão de comprar -->
                    <button class="btn-deletar">
                      <a href="/deletar?id=${evento.id}" class="btn-deletar">Deletar</a>
                    </button>
                  </div>
                </div>
                <!-- Incrementar a contagem de cartões -->
                <c:set var="count" value="${count + 1}" />
                <!-- Fechar a linha após quatro cartões -->
                <c:if test="${count % 4 == 0 or loop.last}">
                </c:if>
              </c:forEach>
            </div>
          </div>
      </section>
    </body>
</html>