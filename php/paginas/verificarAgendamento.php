<?php
if ($_POST) {

    $verificarCNS = $_POST["verificarCNS"] ?? NULL;


    // Se não for vazio e tem 15 caracteres
    if (!empty($verificarCNS) && strlen($verificarCNS) == 15) {
        

        
        
    }else{
        echo "<script>window.alert('O CNS precisa ter 15 caracteres')</script>";
    }
    echo $verificarCNS;
}
?>




































<title>Vacina Brasil - Verificar Agendamento</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Verificar Agendamentos</h1>
    </div>

    <!-- Formulario CNS -->
    <form class="mb-4 d-flex justify-content-center" action="" method="POST">

        <input type="number" class="form-control w-50" name="verificarCNS" placeholder="Coloque os 15 dígitos do seu Cartão Nacional de Saúde" aria-label="Cartão Nacional de Saúde">

        <button class="btn btn-success">Verificar</button>

    </form>



    <div class="text-center mb-4">
        <h3>Onde encontrar?</h3>
        <hr>
    </div>



    <div class="container text-center">
        <div class="row align-items-center">
            <div class="col-auto">
                <img src="../../img/sus.png" alt="SUS logo" width="30px">
            </div>
            <div class="col">
                <a href="https://meususdigital.saude.gov.br/login" target="_blank">Meu SUS Digital</a>
            </div>
        </div>
    </div>
</main>