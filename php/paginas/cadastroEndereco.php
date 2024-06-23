<?php
include 'dados.php';
?>

<title>Vacina Brasil - Cadastro de Endereço</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Endereço</h1>
    </div>
    <form id="myForm" action="" method="POST">
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
            <button type="button" class="btn btn-secondary mr-2" onclick="cancelarCadastro()">Cancelar</button>
            <button type="button" class="btn btn-primary" onclick="cadastrarEndereco()">Cadastrar</button>
        </div><br>

    </form>
</main>


<script>
    document.getElementById('button-addon2').addEventListener('click', function() {
        var cep = document.getElementById('cep').value;
        if (cep) {
            fetch('https://viacep.com.br/ws/' + cep + '/json')
                .then(response => response.json())
                .then(data => {
                    if (!data.erro) {
                        document.getElementById('logradouro').value = data.logradouro;
                        document.getElementById('bairro').value = data.bairro;
                        document.getElementById('cidade').value = data.localidade;
                        document.getElementById('uf').value = data.uf;
                        document.getElementById('complemento').value = data.complemento || '';
                    } else {
                        alert('CEP não encontrado.');
                    }
                })
                .catch(error => {
                    console.error('Error fetching CEP data:', error);
                    alert('Erro ao buscar o CEP.');
                });
        } else {
            alert('Por favor, insira um CEP.');
        }
    });

    function cancelarCadastro() {
        window.location.href = 'main';
    }

    function cadastrarEndereco() {
        document.getElementById('myForm').action = 'dados.php';
        document.getElementById('myForm').submit();
    }
</script>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../funcoes/validationEndereco.js"></script>