<?php
include "header.php"
?>
<title>Vacina Brasil - Principal</title>
<main>
  <div id="carouselExampleCaptions" class="carousel slide carrosel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>

    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="../../img/imagem1.jpg" class="d-block w-100 imagem-carrosel" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="info-carrosel">Vacina da gripe</h5>
          <p>Some representative placeholder content for the first slide.</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="../../img/imagem2.jpg" class="d-block w-100 imagem-carrosel" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="info-carrosel">A importancia de tomar vacina</h5>
          <p>Some representative placeholder content for the second slide.</p>
        </div>
      </div>

      <div class="carousel-item">
        <img src="../../img/imagem3.jpg" class="d-block w-100 imagem-carrosel" alt="...">
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

  <div class="texto">
    <h1>Titulo do informativo</h1>
    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
    <div class="vacinas-info">
      <h1>Titulo sobre as vacinas</h1>
    </div>

    <div class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
        <div class="col-md-4">
          <img src="..." class="img-fluid rounded-start" alt="...">
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <p>Agende uma visista de um profissional de saude</p>
  <button type="button" class="btn btn-primary">Agendar</button>

</main>
<?php
include "footer.php"
?>