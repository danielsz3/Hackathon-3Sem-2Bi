<?php
if ($_POST) {

    $verificarCNS = $_POST["verificarCNS"] ?? NULL;

    //123224262151212 CNS CERTO

    // Se não for vazio e tem 15 caracteres
    if (strlen($verificarCNS) == 15) {

        // A rota da API precisa consumir no GET o CNS digitado
        $json_file = file_get_contents('http://localhost:8081/paciente/' . $verificarCNS);
        $resultadoConsulta = json_decode($json_file, true);



        if ($resultadoConsulta['paciente']['cns'] == null) { // Se a consulta da API retornar NULL, redireciona para o cadastro
            $_GLOBALS['cns'] = $verificarCNS;
            echo '<script>window.location.href="cadastroidoso"</script>';
        } else {
            $_SESSION['paciente'] = [ //variavel global
                'id' => $resultadoConsulta['paciente']['id'],
                'nome' => $resultadoConsulta['paciente']['nome']
            ];
            echo "<script>location.href='veragendamento'</script>";
        }
    } else {
        echo "<script>window.alert('O CNS precisa ter 15 caracteres')</script>";
    }
}
?>

<title>Vacina Brasil - Verificar Agendamento</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Verificar Agendamentos</h1>
    </div>

    <!-- Formulario CNS -->
    <form class="mb-4 d-flex justify-content-center" action="" method="POST">

        <input type="number" class="form-control w-50" id="cns" name="verificarCNS" placeholder="Coloque os 15 dígitos do seu Cartão Nacional de Saúde" aria-label="Cartão Nacional de Saúde"><br>
        <div id="cnsFeedback" class="invalid-feedback"></div>
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