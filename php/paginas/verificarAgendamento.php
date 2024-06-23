<?php

// verificarAgendamento.php == Se a requisicao nao estiver vindo vazia
$verificarCNS = $_POST["verificarCNS"] ?? NULL;
if (isset($_POST['verificarCNS'])) {

    // Se tem 15 caracteres
    if (strlen($verificarCNS) == 15) {

        // A rota da API precisa consumir no GET o CNS digitado paga buscar no banco
        $json_file = file_get_contents('http://localhost:8081/paciente/' . $verificarCNS);
        $resultadoConsultaCNS = json_decode($json_file, true);


        // Se a tabela paciente do banco retornar um cns null redireciona para o cadastro
        if ($resultadoConsultaCNS['paciente']['cns'] == null) {
            echo '<script>window.location.href="cadastroendereco"</script>';
        } else { // Se náo pode abrir uma session com os dados da tabela paciente
            session_start();
            $_SESSION['paciente'] = [
                'id' => $resultadoConsulta['paciente']['id'],
                'nome' => $resultadoConsulta['paciente']['nome']
            ];

            echo "<script>location.href='veragendamento'</script>"; // E redireciona para verAgendamento.php

        }
    } else {
        echo "<script>window.alert('O CNS precisa ter 15 caracteres')</script>";
        echo "<script>location.href='verificaragendamento'</script>";
        // Se tiver menos ou mais que 15 caracteres dispara um alert como validação
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
        <input type="number" class="form-control w-50" id="cns" name="verificarCNS" placeholder="Coloque os 15 dígitos do seu Cartão Nacional de Saúde" aria-label="Cartão Nacional de Saúde">
        <button class="btn btn-success">Verificar</button>
    </form>
    <br><div id="cnsFeedback" class="invalid-feedback"></div><br>
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../funcoes/validationCNS.js"></script>