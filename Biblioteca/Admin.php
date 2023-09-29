<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/Style.css?ts=<?=time()?>&quot">
    <title>Admin</title>
</head>
<body>
    <div class="Container">
        <div class="Content">
            <div class="Nav">
                <span>
                    <h3><a href="Index.php">HOME</a></h3>
                </span>
            </div>

            <h1>Amministrazione</h1>

            <div class="Form">
                    <form method="POST" action="./Config/Connessione.php">
                        <div class="first">
                            <span><h3>Inserisci ID</h3></span>
                            <input class="text" type="text" name="ID" placeholder="1/2/3">
                        </div>

                        <div class="second">
                            <span><h3>Cambia password</h3></span>
                            <input class="text" type="password" name="Password" placeholder="Password">
                            <input class="button" type="button" name="InviaAdmin" value="Invia">
                        </div>
                    </form>
            </div>
        </div>

    </div>



</body>
</html>