<?php
include "header.php";
?>
<title>Vacina Brasil - Agendamento de Visita</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <h1>Agendamento de Visita</h1>
    </div>
    <form>
        <div class="mb-3">
            <label for="dataVisita" class="form-label">Data da Visita</label>
            <div class="input-group">
                <input type="date" class="form-control" id="dataVisita" name="dataVisita" placeholder="Selecione a data" required>
            </div>
        </div>
        <div class="mb-3">
            <label for="horaVisita" class="form-label">Hora da Visita</label>
            <div class="input-group">
                <input type="time" class="form-control" id="horaVisita" name="horaVisita" placeholder="Selecione a hora" required>
            </div>
        </div>
        <div class="text-center">
            <button type="button" class="btn btn-secondary mr-2">Voltar</button>
            <button type="submit" class="btn btn-primary">Agendar</button>
        </div>
    </form>
</main>
<?php
include "footer.php";
?>
