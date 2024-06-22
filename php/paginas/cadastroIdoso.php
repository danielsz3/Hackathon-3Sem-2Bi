
<title>Vacina Brasil - Cadastro</title>

<div class="container mt-5">
    <form action="./cadastroEndereco.php" id="myForm">
        <div class="form-group mb-3">
            <label for="fullName">Nome Completo:</label>
            <input type="text" class="form-control" id="fullName" name="nomeCompleto">
            <div id="fullNameFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" placeholder="xxx.xxx.xxx-xx" id="cpf" name="cpf">
            <div id="cpfFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="phone">Telefone:</label>
            <input type="text" class="form-control" placeholder="(xx)xxxxx-xxxx" id="phone" name="phone">
            <div id="phoneFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="email">E-mail:</label>
            <input type="text" class="form-control" id="email" placeholder="exemplo@exemplo.com" name="email">
            <div id="emailFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="caregiverName">Nome do Cuidador:</label>
            <input type="text" class="form-control" id="caregiverName" name="caregiverName">
            <div id="caregiverNameFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="caregiverPhone">Telefone do Cuidador:</label>
            <input type="text" class="form-control" placeholder="(xx)xxxxx-xxxx" id="caregiverPhone" name="caregiverPhone">
            <div id="caregiverPhoneFeedback" class="invalid-feedback"></div>
        </div>

        <div class="form-group mb-3">
            <label for="cns">CNS:</label>
            <input type="text" class="form-control" id="cns" value='<? $_POST['verificarCNS'] ?>' name="cns">
            <div id="cnsFeedback" class="invalid-feedback"></div>
        </div>

        <div class="text-center">
            <button type="button" class="btn btn-secondary mr-2">Cancelar</button>
            <a href="../../php/paginas/main"><button type="submit" class="btn btn-primary">Cadastrar</button></a>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../funcoes/validation.js"></script>