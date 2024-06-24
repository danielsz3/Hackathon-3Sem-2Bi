<?php
include 'dados.php';
?>
<title>Vacina Brasil - Cadastro</title>

<div class="container mt-5">
    <h1>Cadastro</h1>
    <form action="" method="POST" id="myForm">
        <div class="form-group mb-3">
            <label for="fullName">Nome Completo:</label>
            <input type="text" class="form-control" id="fullName" name="nomeCompletoIdoso">
            <div id="fullNameFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" placeholder="xxx.xxx.xxx-xx" id="cpf" name="cpfIdoso">
            <div id="cpfFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="dataNascimento">Data de Nascimento</label>
            <input type="date" class="form-control" id="data" name="dataIdoso">
        </div>

        <div class="form-group mb-3">
            <label for="phone">Telefone:</label>
            <input type="text" class="form-control" placeholder="(xx)xxxxx-xxxx" id="phone" name="phoneIdoso">
            <div id="phoneFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="email">E-mail:</label>
            <input type="text" class="form-control" id="email" placeholder="exemplo@exemplo.com" name="emailIdoso">
            <div id="emailFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="caregiverName">Nome do Cuidador:</label>
            <input type="text" class="form-control" id="caregiverName" name="caregiverNameIdoso">
            <div id="caregiverNameFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="caregiverPhone">Telefone do Cuidador:</label>
            <input type="text" class="form-control" placeholder="(xx)xxxxx-xxxx" id="caregiverPhone" name="caregiverPhoneIdoso">
            <div id="caregiverPhoneFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="caregiverPhone">CNS:</label>
            <input type="number" class="form-control" id="cns" name="verificarCNS" placeholder="Coloque os 15 dígitos do seu Cartão Nacional de Saúde" aria-label="Cartão Nacional de Saúde">
        </div>

        <div class="text-center">
            <button type="button" class="btn btn-secondary mr-2" onclick="cancelarCadastro()">Cancelar</button>
            <button type="button" class="btn btn-primary" onclick="cadastrarUsuario()">Cadastrar</button>
        </div>
    </form>
</div>

<script>
    function cancelarCadastro() {
        window.location.href = 'main';
    }

    function cadastrarUsuario() {
        document.getElementById('myForm').action = 'dados';
        document.getElementById('myForm').submit();
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../funcoes/validation.js"></script>
<script src="../funcoes/validationCNS.js"></script>