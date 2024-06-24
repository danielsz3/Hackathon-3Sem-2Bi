<?php

$data = $_POST['dataIdoso'] ?? null;
//$data = date('Y-m-d', strtotime($data));

$nomeCompleto = $_POST['nomeCompletoIdoso'] ?? null;
//$nomeCompleto = preg_replace('/[^A-Za-z ]/', '', $nomeCompleto);

$cns = $_POST["verificarCNS"] ?? NULL;
//$cns = preg_replace('/[^0-9]/', '', $cns);

$cpf = $_POST['cpfIdoso'] ?? null;
//$cpf = preg_replace('/[^0-9]/', '', $cpf);

$telefone = $_POST['phoneIdoso'] ?? null;
//$telefone = preg_replace('/[^0-9]/', '', $telefone);

$email = $_POST['emailIdoso'] ?? null;
//$email = filter_var($email, FILTER_SANITIZE_EMAIL);

$nomeCuidador = $_POST['caregiverNameIdoso'] ?? null;
//$nomeCuidador = preg_replace('/[^A-Za-z ]/', '', $nomeCuidador);

$telefoneCuidador = $_POST['caregiverPhoneIdoso'] ?? null;
//$telefoneCuidador = preg_replace('/[^0-9]/', '', $telefoneCuidador);

$enderecoCadastrado = false;
$cep = $_POST['cep'] ?? null;
$logradouro = $_POST['logradouro'] ?? null;
$numero = $_POST['numero'] ?? null;
$complemento = $_POST['complemento'] ?? null;
$bairro = $_POST['bairro'] ?? null;
$cidade = $_POST['cidade'] ?? null;
$estado = $_POST['uf'] ?? null;



// Cadastro Endereco && Cadastro de Idoso
if (isset($_POST['cep'])) {

    $endereco = [
        'cep' => $cep,
        'logradouro' => $logradouro,
        'numero' => $numero,
        'complemento' => $complemento,
        'bairro' => $bairro,
        'cidade' => $cidade,
        'estado' => $estado
    ];

   

    $jsonEndereco = json_encode($endereco);
    $apiUrl = 'http://localhost:8888/endereco/';
    $ch = curl_init($apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonEndereco);
    $response = curl_exec($ch);
    if ($response === false) {
        $error = curl_error($ch);
        curl_close($ch);
        die('Erro na requisição: ' . $error);
    }
    curl_close($ch);


    $enderecoCadastrado = true;
    if ($enderecoCadastrado) {
        echo '<script>window.location.href="cadastroidoso"</script>';
    } else {
        echo "<script>alert('Todos os campos são obrigatórios. Preencha todos os campos antes de cadastrar.');</script>";
    }
}

if (isset($_POST['nomeCompletoIdoso'])) {
    cadastrarIdoso($nomeCompleto, $data, $cpf, $cns, $telefone, $email, $nomeCuidador, $telefoneCuidador);
}


function cadastrarIdoso($nomeCompleto, $data, $cpf, $cns, $telefone, $email, $nomeCuidador, $telefoneCuidador)
{
    // Faz a requisição GET para obter o maior ID de endereço
    $jsonFile = file_get_contents('http://localhost:8888/endereco/id/');
    $maiorIdEndereco = json_decode($jsonFile, true);
   

    // Converte a data para o formato SQL (YYYY-MM-DD)
    $dataNascimento = date('Y-m-d', strtotime($data));

    // Monta o array com os dados do paciente
    $paciente = [
        "id_endereco" => $maiorIdEndereco['id'],
        "nome" => $nomeCompleto,
        "dataNascimento" => $dataNascimento,
        "cpf" => $cpf,
        "cns" => $cns,
        "celular" => $telefone,
        "email" => $email,
        "nomeCuidador" => $nomeCuidador,
        "telefoneCuidador" => $telefoneCuidador
    ];
  
    // Converte o array em JSON para enviar na requisição
    $jsonPaciente = json_encode($paciente);

    // Faz a requisição POST para cadastrar o paciente
    $apiUrl = 'http://localhost:8888/paciente/';
    $ch = curl_init($apiUrl);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonPaciente);
    $responsePaciente = curl_exec($ch);

    // Verifica erros na requisição
    if ($responsePaciente === false) {
        $error = curl_error($ch);
        curl_close($ch);
        die('Erro na requisição de cadastro de paciente: ' . $error);
    }

    curl_close($ch);

    // Decodifica a resposta JSON
    $resultadoConsulta = json_decode($responsePaciente, true);

    // Verifica se o paciente foi cadastrado com sucesso
    if (isset($resultadoConsulta['mensagem']) && $resultadoConsulta['mensagem'] == "Paciente Salvar") {
        echo "<script>window.alert('Paciente cadastrado com sucesso!')</script>";
        echo "<script>location.href='veragendamento.php'</script>";
    } else {
        echo "<script>window.alert('Erro ao cadastrar paciente')</script>";
    }
}
