<?php
    phpinfo();
    
    $servidor = "127.0.0.1";
    $usuario  = "root";
    $senha    = "daniel";
    $banco    = "dbvacinacao";

    try {
        $pdo = new PDO("mysql:host={$servidor};dbname={$banco};port=3333;charset=utf8;",$usuario,$senha);
    } catch (Exception $e) {
        echo "<p>Erro ao tentar conectar</p>";
        echo $e->getMessage();
    }
    