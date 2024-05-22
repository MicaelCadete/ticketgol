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
          <li><a href="Home.html">Início</a></li>
          <li><a data-scroll="jogos" href="#jogos">Jogos</a></li>
          <li><a data-scroll="informacoes" href="#informacoes">Informações</a></li>
        </ul>
        <!-- Botão de login -->
        <button class="btn" href="Login.html" class="btn">
          <a href="Login.html">
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
                    <img src="Jogos/img/img-logoBrasileirao.png" alt="">
                  </div>
                  <!-- Conteúdo do card -->
                  <div class="content">
                    <h1>Brasileirão</h1>
                    <h2>${evento.nomeEvento}</h2>
                    <p>Horário: ${evento.horario}</p>
                    <p>Data: ${evento.data}</p>
                    <p>Estádio: ${evento.local}</p>
                    <p>Valor: ${evento.valor}</p>
                    <p>Ingressos Disponíveis: ${evento.qtdDisponivel}</p>
                    <!-- Botão de comprar -->
                   <button class="btn-comprar">
                           <a href="Compra.html?id=${evento.id}" class="btn-comprar">
                               <img src="Jogos/img/img-iconeCarrinho.png" alt="Entrar">Comprar
                           </a>
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

      <!-- Seção de informações -->
      <section id="informacoes">
        <footer class="footer-distributed">
          <!-- Informações da empresa -->
          <div class="footer-left">
            <h3>Ticket<span>Gol</span></h3>
            <p class="footer-links">
              <a href="Home.html">Início</a>
              |
              <a href="/lista-eventos">Jogos</a>
              |
              <a href="">Informações</a>
            </p>
            <p class="footer-company-name">Copyright © 2021 <strong>TicketGol</strong> All rights reserved</p>
          </div>
          <!-- Informações de contato -->
          <div class="footer-center">
            <!-- Informações de contato -->
            <div>
              <i class="fa fa-map-marker"></i>
              <p><span><b>São Paulo, SP</b></span></p>
            </div>
            <div>
              <i class="fa fa-phone"></i>
              <p>+55 (11) 93354-8219</p>
            </div>
            <div>
              <i class="fa fa-envelope"></i>
              <p><a href="mailto:sagar00001.co@gmail.com">contato.ticketgol@gmail.com</a></p>
            </div>
          </div>
          <!-- Sobre a empresa e redes sociais -->
          <div class="footer-right">
            <p class="footer-company-about">
              <span>Sobre Nós</span>
              <strong>TicketGol - </strong>Somos a sua porta de entrada para a emoção e a paixão dos grandes jogos. Na
              nossa
              plataforma, você encontrará uma ampla seleção de ingressos para os jogos mais emocionantes do momento.
            </p>
            <!-- Botões das redes sociais -->
            <div class="btns-midias-sociais">
              <button class="btn-midia-social">
                <img src="Home/img/img-iconeFace.png" class="img-icones">
              </button>
              <button class="btn-midia-social">
                <img src="Home/img/img-iconeInsta.png" class="img-icones">
              </button>
              <button class="btn-midia-social">
                <img src="Home/img/img-iconeX.png" class="img-icones">
              </button>
            </div>
          </div>
        </footer>
      </section>
    </body>

</html>


</html>