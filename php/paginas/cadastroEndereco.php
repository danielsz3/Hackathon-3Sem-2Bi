<?php

if (isset($_POST['cep'])) {

    //Cadastro do usuário
    $nomeCompleto = $_POST['fullName'] ?? null;
    $cpf = $_POST['cpf'] ?? null;
    $cns = $_POST['cns'] ?? null;
    $telefone = $_POST['phone'] ?? null;
    $email = $_POST['email'] ?? null;
    $nomeCuidador = $_POST['caregiverName'] ?? null;
    $telefoneCuidador = $_POST['caregiverPhone'] ?? null;

    $nomeCompleto = preg_replace('/[^A-Za-z ]/', '', $nomeCompleto);
    $cpf = preg_replace('/[^0-9]/', '', $cpf);
    $cns = preg_replace('/[^0-9]/', '', $cns);
    $telefone = preg_replace('/[^0-9]/', '', $telefone);
    $email = filter_var($email, FILTER_SANITIZE_EMAIL);
    $nomeCuidador = preg_replace('/[^A-Za-z ]/', '', $nomeCuidador);
    $telefoneCuidador = preg_replace('/[^0-9]/', '', $telefoneCuidador);

    if (strlen($cns) == 15) {
        $json_file = file_get_contents('http://localhost:8888/paciente/' . $cns);
        $resultadoConsulta = json_decode($cpf, true);

        if ($resultadoConsulta['paciente']['cns'] == null) { // Se a consulta da API retornar NULL

            //Cadastrar
        } else {
            $_SESSION['paciente'] = [ //variavel global
                'id' => $resultadoConsulta['paciente']['id'],
                'nome' => $resultadoConsulta['paciente']['nome']
            ];
            echo "<script>location.href='veragendamento'</script>";
        }
    }

    //Cadastro do Endereço
    // Pegar dados do Endereco
    // Tratar os dados e validar
    // cadastrar no banco o endereco {Rota de cadastro para endereco}
    // consultar o MaxId de endereco para atribuir no campo de chave estrangeira 

    $cep = $_POST['cep'] ?? null;
    $logradouro = $_POST['logradouro'] ?? null;
    $numero = $_POST['numero'] ?? null;
    $bairro = $_POST['bairro'] ?? null;
    $complemento = $_POST['complemento'] ?? null;
    $cidade = $_POST['cidade'] ?? null;
    $estado = $_POST['uf'] ?? null;


    if (!empty($cep)) {
        $cep = preg_replace('/[^0-9]/', '', $cep);

        $endereco = [
            "cep" => $cep,
            "logradouro" => $logradouro,
            "numero" => $numero,
            "complemento" => $complemento,
            "bairro" => $bairro,
            "cidade" => $cidade,
            "estado" => $estado
        ];
        var_dump($endereco);
        
        // Converter os dados para JSON
        $jsonData = json_encode($endereco, true);

        // Inicializar o cURL
        $ch = curl_init('http://localhost:8888/endereco/' . $jsonData);

        // Configurar o cURL
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
        curl_setopt($ch, CURLOPT_POST, true);

        // Executar a requisição e obter a resposta
        $response = curl_exec($ch);

        // Verificar se houve erro na execução
        if ($response === false) {
            $error = curl_error($ch);
            curl_close($ch);
            die('Erro na requisição: ' . $error);
        }

        // Fechar o cURL
        curl_close($ch);

        // Decodificar a resposta JSON
        $resultadoConsulta = json_decode($response, true);

        // Exibir a resposta
        var_dump($resultadoConsulta);

        
    }






    /*
    if (empty($dados)) {
        $json_file = file_get_contents('http://viacep.com.br/ws/' . $cep . '/json');
        $dados = json_decode($json_file, true);

        if (!isset($dados['erro'])) {
            $dados['cep'] = preg_replace('/-/', '', $dados['cep']);
        } else {
        }
    }
*/
}


?>

<title>Vacina Brasil - Cadastro de Endereço</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Endereço</h1>
    </div>
    <form action="">
        <!-- CEP -->
        <div class="mb-3">
            <label for="cep" class="form-label">CEP</label>
            <div class="input-group">
                <input type="text" class="form-control" id="cep" name="cep" placeholder="Digite o CEP" required>
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">
                    <i class="bi bi-search"></i>
                </button>
                <div id="cepFeedback" class="invalid-feedback"></div>

            </div>
        </div>
        <!-- Logradouro -->
        <div class="mb-3">
            <label for="logradouro" class="form-label">Logradouro</label>
            <input type="text" class="form-control" id="logradouro" name="logradouro" placeholder="Digite o logradouro" required>
            <div id="logradouroFeedback" class="invalid-feedback"></div>

        </div>
        <!-- Numero -->
        <div class="mb-3">
            <label for="numero" class="form-label">Número</label>
            <input type="text" class="form-control" id="numero" name="numero" placeholder="Digite o número" required>
            <div id="numeroFeedback" class="invalid-feedback"></div>
        </div>
        <!-- Bairro -->
        <div class="mb-3">
            <label for="bairro" class="form-label">Bairro</label>
            <input type="text" class="form-control" id="bairro" name="bairro" placeholder="Digite o bairro" required>
            <div id="bairroFeedback" class="invalid-feedback"></div>

        </div>
        <!-- Complemento -->
        <div class="mb-3">
            <label for="complemento" class="form-label">Complemento</label>
            <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Digite o complemento">
        </div>
        <!-- Cidade -->
        <div class="mb-3">
            <label for="cidade" class="form-label">Cidade</label>
            <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Digite a cidade" required>
            <div id="cidadeFeedback" class="invalid-feedback"></div>

        </div>
        <!-- UF -->
        <div class="mb-3">
            <label for="uf" class="form-label">UF</label>
            <input type="text" class="form-control" id="uf" name="uf" placeholder="Digite a UF" required>
            <div id="ufFeedback" class="invalid-feedback"></div>

        </div>
        <!-- Botao -->
        <div class="text-center">
            <button type="button" class="btn btn-secondary mr-2">Voltar</button>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </div>

    </form>
</main>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../funcoes/validationEndereco.js"></script>