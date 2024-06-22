<title>Vacina Brasil - Cadastro</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Cadastro</h1>
    </div>
    <form action="../../php/paginas/cadastroEndereco" method="POST">
        <div class="mb-3">
            <label for="nomeCompleto" class="form-label">Nome Completo</label>
            <input type="text" class="form-control" id="nomeCompleto" name="nomeCompleto" placeholder="Digite seu nome completo" required>
        </div>
        <div class="mb-3">
            <label for="telefone" class="form-label">Telefone</label>
            <input type="tel" class="form-control" id="telefone" name="telefone" placeholder="(xx) xxxxx-xxxx" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu email" required>
        </div>
        <div class="mb-3">
            <label for="nomeCuidador" class="form-label">Nome do Cuidador (Responsável)</label>
            <input type="text" class="form-control" id="nomeCuidador" name="nomeCuidador" placeholder="Digite o nome do cuidador" required>
        </div>
        <div class="mb-3">
            <label for="telefoneCuidador" class="form-label">Telefone do Cuidador (Responsável)</label>
            <input type="tel" class="form-control" id="telefoneCuidador" name="telefoneCuidador" placeholder="(xx) xxxxx-xxxx" required>
        </div>
        <div class="text-center">
            <button type="button" class="btn btn-secondary mr-2">Cancelar</button>
           <a href="../../php/paginas/agendamentoVisita"><button type="submit" class="btn btn-primary">Cadastrar</button></a> 
        </div>
    </form>
</main>

