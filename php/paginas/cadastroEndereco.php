<?php
include "header.php";
$cep = $_POST['cep'] ?? NULL;
?>

<title>Vacina Brasil - Cadastro de Endereço</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Endereço</h1>
    </div>
    <form id="enderecoForm" action="../../php/paginas/cadastroEndereco" method="POST">
        <div class="mb-3">
            <label for="cep" class="form-label">CEP</label>
            <div class="input-group">
                <input type="text" class="form-control" id="cep" name="cep" placeholder="Digite o CEP" required>
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">
                    <i class="bi bi-search"></i>
                </button>
            </div>
        </div>
        <div class="mb-3">
            <label for="logradouro" class="form-label">Logradouro</label>
            <input type="text" class="form-control" id="logradouro" name="logradouro" placeholder="Digite o logradouro" required>
        </div>
        <div class="mb-3">
            <label for="numero" class="form-label">Número</label>
            <input type="text" class="form-control" id="numero" name="numero" placeholder="Digite o número" required>
        </div>
        <div class="mb-3">
            <label for="bairro" class="form-label">Bairro</label>
            <input type="text" class="form-control" id="bairro" name="bairro" placeholder="Digite o bairro" required>
        </div>
        <div class="mb-3">
            <label for="complemento" class="form-label">Complemento</label>
            <input type="text" class="form-control" id="complemento" name="complemento" placeholder="Digite o complemento">
        </div>
        <div class="mb-3">
            <label for="cidade" class="form-label">Cidade</label>
            <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Digite a cidade" required>
        </div>
        <div class="mb-3">
            <label for="uf" class="form-label">UF</label>
            <input type="text" class="form-control" id="uf" name="uf" placeholder="Digite a UF" required>
        </div>
        <div class="text-center">
           <a href="../../php/paginas/cadastroIdoso"><button type="button" class="btn btn-secondary mr-2">Voltar</button></a>
           <button type="submit" class="btn btn-primary">Cadastrar</button>
        </div>
    </form>
</main>
<?php
include "footer.php";
?>
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
</script>
