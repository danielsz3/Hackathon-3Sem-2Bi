<title>Vacina Brasil - Ver Agendamentos</title>
<main class="container my-4">
    <div class="text-center mb-4">
        <img src="../../img/topo.png" alt="Imagem no topo" class="img-fluid mb-4">
        <h1>Ver Agendamentos</h1>
    </div>
    <div class="card mb-3">
        <div class="row no-gutters">
            <div class="col-md-4">
                <img src="../../img/agendamento.png" class="card-img" alt="Imagem da consulta">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">Consulta 1</h5>
                    <p class="card-text">Visita</p>
                    <div class="d-flex justify-content-end">
                        <button type="button" class="btn btn-link p-0 mx-2" data-toggle="modal" data-target="#infoModal">
                            <i class="bi bi-info-circle"></i>
                        </button>
                        <button type="button" class="btn btn-link p-0 mx-2" data-toggle="modal" data-target="#configModal">
                            <i class="bi bi-trash"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="card mb-3">
        <div class="row no-gutters">
            <div class="col-md-4">
                <img src="../../img/agendamento.png" class="card-img" alt="Imagem da consulta">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">Consulta 1</h5>
                    <p class="card-text">Visita</p>
                    <div class="d-flex justify-content-end">

                        <button type="button" class="btn btn-link p-0 mx-2" data-toggle="modal" data-target="#infoModal">
                            <i class="bi bi-info-circle"></i>
                        </button>
                  
                        <button type="button" class="btn btn-link p-0 mx-2" data-toggle="modal" data-target="#configModal">
                            <i class="bi bi-trash"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>


<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="infoModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="infoModalLabel">Informações da Consulta</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Detalhes sobre a consulta...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="configModal" tabindex="-1" role="dialog" aria-labelledby="configModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="configModalLabel">Configurações da Consulta</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Opções de configuração...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
    
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9O6V5tKnd4GOpKePtIxjGkz0I7r7PXQBYTKyf" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
