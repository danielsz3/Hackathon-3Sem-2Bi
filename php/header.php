<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous" defer></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="../../css/style.css">
</head>

<body>
    <header>
        <div class="grid-header d-flex justify-content-between align-items-center p-3 bg-success">
            <div class="hamburguer">
                <button class="btn btn-hamburguer" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
                    </svg>
                </button>
                <div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">Vacina Brasil</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <nav class="navbar bg-body-tertiary">
                            <div>
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link" id="home" href="../../php/paginas/main">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="informativos" href="#informativo-titulo-h2">Informativos</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="vacinas" href="#">Vacinas</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="agendamentos" href="#">Agendamento</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="consultarAgendamentos" href="#">Consultar Agendamento</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>

            <div id="titulo" class="header-title text-center flex-grow-1">
               <a href="../../php/paginas/main" class="link-texto"><h1>Vacina Brasil</h1></a> 
            </div>

            <button class="btn btn-outline-secondary" type="button" data-bs-toggle="modal" data-bs-target="#notificationModal">
                <i class="bi bi-bell"></i>
            </button>
        </div>
    </header>

    <div class="modal fade" id="menuModal" tabindex="-1" aria-labelledby="menuModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="menuModalLabel">Menu</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <ul class="list-group">
                        <li class="list-group-item"><a href="../../php/paginas/main">Home</a></li>
                        <li class="list-group-item"><a href="#informativo-titulo-h2">Informativos</a></li>
                        <li class="list-group-item"><a href="#">Vacinas</a></li>
                        <li class="list-group-item"><a href="#">Agendamento</a></li>
                        <li class="list-group-item"><a href="#">Consultar Agendamento</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="notificationModal" tabindex="-1" aria-labelledby="notificationModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="notificationModalLabel">Notificações</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Sem novas notificações.</p>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
