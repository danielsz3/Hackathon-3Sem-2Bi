<?php

include 'dados.php'; // Inclua o arquivo de conexão ao banco de dados

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $cpf = $_POST['cpf'] ?? '';
    $cns = $_POST['cns'] ?? '';
    $phone = $_POST['phone'] ?? '';
    $email = $_POST['email'] ?? '';

    $errors = [];

    // Verificar CPF
    $stmt = $conn->prepare("SELECT COUNT(*) FROM usuarios WHERE cpf = ?");
    $stmt->bind_param('s', $cpf);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count > 0) {
        $errors['cpf'] = 'CPF já cadastrado';
    }
    $stmt->close();

    // Verificar CNS
    $stmt = $conn->prepare("SELECT COUNT(*) FROM usuarios WHERE cns = ?");
    $stmt->bind_param('s', $cns);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count > 0) {
        $errors['cns'] = 'CNS já cadastrado';
    }
    $stmt->close();

    // Verificar telefone
    $stmt = $conn->prepare("SELECT COUNT(*) FROM usuarios WHERE telefone = ?");
    $stmt->bind_param('s', $phone);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count > 0) {
        $errors['phone'] = 'Telefone já cadastrado';
    }
    $stmt->close();

    // Verificar email
    $stmt = $conn->prepare("SELECT COUNT(*) FROM usuarios WHERE email = ?");
    $stmt->bind_param('s', $email);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count > 0) {
        $errors['email'] = 'Email já cadastrado';
    }
    $stmt->close();

    // Retornar os erros como JSON
    header('Content-Type: application/json');
    echo json_encode($errors);
}
?>
