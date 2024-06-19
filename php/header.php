<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous" defer></script>

    <!-- CSS da Aplicação -->
    <link rel="stylesheet" href="../css/style.css">



</head>

<body>
    <header>

        <div class="grid-header">
            <div class="hamburguer">
                <button class="btn btn-hamburguer" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions"> <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5" />
                    </svg></button>

                <div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">

                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">Vacina Brasil</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>

                    <div class="offcanvas-body">
                        <nav class="navbar bg-body-tertiary">
                            <div>
                                <ul class="nav navbar-header">
                                    <li class="nav-item">
                                        <a class="navbar-brand" id="home" href="#">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="navbar-brand" id="informativos" href="#">Informativos</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="navbar-brand" id="vacinas" href="#">Vacinas</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="navbar-brand" id="agendamentos" href="#">Agendamento</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="navbar-brand" id="consultarAgendamentos" href="#">Consultar Agendamento</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>

            <div id="titulo">
                <h1>Vacina Brasil</h1>
            </div>
        </div>

    </header>