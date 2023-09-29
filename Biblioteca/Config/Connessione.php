<?php

$server= 'localhost';
$user= 'root';
$password= 'root';

try{
    $connessione= new PDO("mysql:host=$server;dbname=Biblioteca",$user,$password);

    $connessione->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    echo 'Connessione riuscita';
}catch(PDOException $e){
    echo 'Connessione non riuscita' . $e->getMessage();
}

$connessione=null;
?>