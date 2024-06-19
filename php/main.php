<?php
include "header.php"
?>

<section>
  <div id="carouselExampleCaptions" class="carousel slide carrosel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>

    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="../img/imagem1.jpg" class="d-block w-100 imagem-carrosel" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="info-carrosel">Vacina da gripe</h5>
          <p>Some representative placeholder content for the first slide.</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="../img/imagem2.jpg" class="d-block w-100 imagem-carrosel" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="info-carrosel">A importancia de tomar vacina</h5>
          <p>Some representative placeholder content for the second slide.</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="../img/imagem3.jpg" class="d-block w-100 imagem-carrosel" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="info-carrosel">Vacina de Tetano</h5>
          <p>Some representative placeholder content for the third slide.</p>
        </div>
      </div>
    </div>

    <!-- Botáo anterior -->
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>

    <!-- Botáo proximo -->
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>

</section>

<section>
  <div class="container conteudo">
    <div>
      <h2 id="informativo-titulo-h2">Cartão Nacional de Saúde</h2>
    </div>

    <div>
      <h3>Sobre o programa</h3>
      <p>O Cartão Nacional de Saúde (CNS) é o documento de identificação do usuário do SUS. Este registro contém as informações dos indivíduos, como: dados pessoais (nome, nome da mãe, data de nascimento, etc), contatos (telefones, endereço, e-mails) e documentos (CPF, RG, Certidões, etc). Atualmente, o número do CNS é utilizado nos sistemas informatizados de saúde que demandam identificação dos indivíduos, sejam usuários, operadores ou profissionais de saúde. Dessa forma, o CNS possibilita a criação do histórico de atendimento de cada cidadão no Sistema Único de Saúde (SUS), por meio do acesso às Bases de Dados dos sistema de atenção básica, sistema hospitalar, sistema de dispensação de medicamentos, etc.

        Com os CNS, o usuário do SUS pode conferir as informações de suas internações hospitalares, com dados sobre atendimento ambulatorial de média e alta complexidade e aquisição de medicamentos no programa Farmácia Popular. O sistema do Cartão identifica o indivíduo para garantir a cidadania, coordena informações para humanizar o atendimento e padroniza os procedimentos para democratizar o uso do recurso público.</p>
    </div>

    <div class="grid-cartao-sus">
      <div class="coluna-cartao-sus">
        <h4>Quais são os benefícios de ter o CNS:</h4>
        <ul>
          <li>
            Rapidez na identificação do usuário;
          </li>
          <li>
            Localização do prontuário pelo número do cartão;
          </li>
          <li>
            Vinculação de: profissional, usuário, estabelecimento de saúde e atendimento;
          </li>
          <li>
            Registro dos atendimentos realizados;
          </li>
          <li>
            Registro do agendamento e execução de consultas e exames;
          </li>
          <li>
            Dispensação de medicamentos;
          </li>
          <li>
            Atualização de dados cadastrais.
          </li>
        </ul>
      </div>

      <div class="coluna-cartao-sus">
        <img src="../img/cartao-sus.jfif" alt="">
      </div>

    </div>

    <div>

      <p>
        O CNS faz parte da política do e-Saúde, que utiliza essas bases de dados de pessoas, estabelecimentos, procedimentos, como forma de propor ações estratégicas para a formulação de políticas de saúde de forma integrada. Com isso, é possível organizar a rede de atenção à saúde e a gestão do SUS, facilitar o atendimento ao cidadão e qualificar o trabalho dos gestores e profissionais da área da Saúde. Diante disso, percebe-se o impacto e a amplitude do uso das tecnologias de informação e de telecomunicação na gestão da saúde pública. O acesso a essas informações dá ao cidadão a possibilidade de participar da fiscalização e do aprimoramento do SUS.

        O cidadão poderá saber os nomes dos profissionais de saúde que o atenderam, o período, o nome da unidade de saúde e os procedimentos clínicos e cirúrgicos realizados. Isso traz transparência e possibilita ao cidadão participar da fiscalização e do aprimoramento do SUS.
      </p>
    </div>

    <h2 class="conteudo">Informações sobre as vacinas</h2>

    <br>

    <div class="grid-cards-vacinas">

      <div class="card card-vacina" style="width: 25rem;">
        <img src="../img/card-gripe.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Vacina da Gripe</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>

      <div class="card card-vacina" style="width: 25rem;">
        <img src="../img/card-gripe.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Vacina da Gripe</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>

    </div>

    <br>

    <div class="grid-cards-vacinas">

      <div class="card card-vacina" style="width: 25rem;">
        <img src="../img/card-gripe.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Vacina da Gripe</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>

      <div class="card card-vacina" style="width: 25rem;">
        <img src="../img/card-gripe.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">Vacina da Gripe</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>

    </div>



    <h2 class="conteudo">Grupos prioritários</h2>
    <br>

    <div>
      <ul>
        <li>
          <p> Crianças de 6 meses até menores de 6 anos</p>
        </li>
        <li>
          <p>Quilombolas</p>
        </li>
        <li>
          <p>Idosos 60 anos ou mais</p>
        </li>
        <li>
          <p>População em situação de rua</p>
        </li>
        <li>
          <p>Trabalhadores de transporte coletivo rodoviário</p>
        </li>
        <li>
          <p>Pessoas com doenças crônicas não transmissiveis e outras condições clinicas especiais</p>
        </li>
      </ul>
    </div>



    <div class="btn-agendar">
      <a href="#" class="btn">Agendar vacinação</a>
    </div>

  </div>
</section>