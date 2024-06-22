<?php
if (isset($_GET['param'])) {
    $page = explode("/", $_GET['param']);
    $pasta = $page[0] ?? NULL;
    $arquivo = $page[1] ?? NULL;
    $page = "$pasta/$arquivo";
    if (file_exists("$page.php")) {
        require "header.php";
        require "$page.php";
        require "footer.php";
    } else {
        echo '<h1>Página não encontrada</h1>';
    }
}
?>

