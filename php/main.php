<?php
include "header.php"
?>

<title>Vacina Brasil - Principal</title>
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