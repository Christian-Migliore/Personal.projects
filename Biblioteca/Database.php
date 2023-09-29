<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/Style.css?ts=<?=time()?>&quot">
    <title>Database</title>
</head>
<body>
    <div class="Container">
        <div class="Content">
            <div class="Nav">
                <span>
                    <h3><a href="Index.php">HOME</a></h3>
                </span>
            </div>

            <h1>Dati Utenti</h1>

            <div class="Table">
                <table>
                    <caption><h2>Utenti</h2></caption>    
                    <thead>
                        <tr><td>ID</td><td>Username</td><td>Password</td><td>Nome</td><td>Telefono</td><td>Indirizzo</td></tr>
                    </thead>
                    <tbody>
                        <?php echo $rowTable ?>
                    </tbody>
                </table>
            </div>

            <input class="button" type="button" name="Richiesta" value="Mostra dati">

        </div>
    </div>
</body>
</html>