<?php
session_start();

// Inclui o arquivo de configuração para obter a conexão
include 'config.php';

// Verifica se o método da requisição é POST e se o botão de cancelar foi acionado
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['cancelar'])) {
    // Verifica se o ID do agendamento foi enviado
    if (isset($_SESSION['agendamento']['id'])) {
        $id_agendamento = $_SESSION['agendamento']['id'];

        // Prepara a declaração SQL para deletar o agendamento
        $sql = "DELETE FROM agendamentovisita WHERE id = ?";

        // Prepara e executa a declaração usando prepared statements
        if ($stmt = $conn->prepare($sql)) {
            $stmt->bind_param("i", $id_agendamento);

            // Executa o comando
            if ($stmt->execute()) {
                // Deletou com sucesso, limpa a variável de sessão
                unset($_SESSION['agendamento']);
                echo "<script>alert('Agendamento cancelado com sucesso');</script>";
                echo "<script>window.location.href='veragendamento.php';</script>";
            } else {
                echo "Erro ao deletar agendamento: " . $conn->error;
            }

            // Fecha a declaração
            $stmt->close();
        } else {
            echo "Erro na preparação da declaração SQL: " . $conn->error;
        }
    } else {
        echo "ID do agendamento não encontrado na sessão.";
    }
} else {
    echo "Requisição inválida para cancelar agendamento.";
}

// Fecha a conexão com o banco de dados
$conn->close();
?>
