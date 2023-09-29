<?php
include "Connessione.php";



        //Inserimento dati
    if(isset($_POST['InviaReg'])){
        if(empty($_POST['Nome']) || empty($_POST['Telefono']) || empty($_POST['Indirizzo']) || empty($_POST['Username']) || empty($_POST['Password'])){
            echo 'Devi compilare tutti i campi.';
        }else{
            $nome = $_POST['Nome'];
            $telefono = $_POST['Telefono'];
            $indirizzo = $_POST['Indirizzo'];
            $username = $_POST['Username'];
            $password = $_POST['Password'];

            $query = 'INSERT INTO Registrazione (Nome, Telefono, Indirizzo) VALUES ($nome, $telefono, $indirizzo);';

            $stmt = $connessione->prepare($query);
            $stmt->execute();

            $query = 'INSERT INTO Login (Username, Password) VALUES ($username, $password);';
            $stmt = $connessione->prepare($query);
            $stmt->execute();

            $connessione = null;
        }
    }


        //Controllo password
    if(isset($_POST['InviaLog'])){
        if(empty($_POST['Username']) || empty($_POST['Password'])){
            echo 'Devi compilare tutti i campi.';
        }else{
            $username = $_POST['Username'];
            $password = $_POST['Password'];

            $query = 'SELECT Password FROM LOGIN WHERE Username = $username;';

            $stmt = $connessione->prepare($query);
            $pass = $stmt->execute();

        if(empty($pass)){
            echo 'Utente non trovato';
        }
        else{
                if($pass == $password){
                    echo 'Accesso Approvato';
                }else{
                    echo 'Password errata';
                }
        }

            $connessione = null;
        }
    }

        //Lettura e presentazione dati utenti
    if(isset($_POST['Richiesta'])){

            $query = 'SELECT * FROM Registrazione;';
            $stmt = $connessione->prepare($query);
            $stmt->execute();

            if($stmt->rowCount() === 0){
                    $rowTable= '<tr><td>Nessun utente trovato</td></tr>';
            }else{
                while($row = $stmt->fetch()){
                $ids[] = $row['ID'];
                $nome[] = $row['Nome'];
                $telefono[] = $row['Telefono'];
                $indirizzo[] = $row['Indirizzo'];
                $username[] = $row['Username'];
                $password[] = $row['Password'];
                }

                for($i=0; $stmt->rowCount(); $i++){
                    $rowTable = '<tr><td>$ids[$i]</td><td>$username[$i]</td><td>$password[$i]</td><td>$nome[$i]</td><td>$telefono[$i]</td><td>$indirizzo[$i]</td></tr>';
                }
            }


            $connessione = null;
        }

        //Modifica password utenti
        if(isset($_POST['InviaAdmin'])){
            if(empty($_POST['ID']) || empty($_POST['Password'])){
                echo 'Inserisci tutti i campi.';
            }else{
                $id = $_POST['ID'];
                $password = $_POST['Password'];
    
                $query = 'UPDATE Login SET Password = $password; WHERE ID = $id';
            
                $stmt = $connessione->prepare($query);
                $stmt->execute();
    
                $connessione = null;
            }
        }

?>