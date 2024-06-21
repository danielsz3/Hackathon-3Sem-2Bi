<?php
include "header.php";
?>
<title>Vacina Brasil - Cadastro de Endereço</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Endereço</h1>
    </div>
    <form action="../../php/paginas/agendamentoVisita">
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
           <a href="../../php/paginas/agendamentoVisita"><button type="submit" class="btn btn-primary">Cadastrar</button></a>
        </div>
    </form>
</main>
<?php
include "footer.php";
?>
