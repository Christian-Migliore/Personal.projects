<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/Style.css?ts=<?=time()?>&quot">
    <title>Registrati</title>
</head>
<body>
    <div class="Container">
        <div class="Content">
            <div class="Nav">
                <span>
                    <h3><a href="Index.php">HOME</a></h3>
                </span>
            </div>

            <h1>Registrati</h1>

            <div class="Form">
                <form method="POST" action="./Config/Connessione.php">
                    <div class="first">
                        <input class="text" type="text" name="Nome" placeholder="Mario Rossi">
                        <input class="text" type="text" name="Telefono" placeholder="+39 - 338*******">
                    </div>

                    <div class="second">
                        <input class="text" type="text" name="Indirizzo" placeholder="Viale Italia">
                    </div>

                    <div class="third">
                        <input class="text" type="text" name="Username" placeholder="Mario.rossi21">
                        <input class="text" type="password" name="Password" placeholder="Password">
                    </div>

                    <input class="button" type="button" name="InviaReg" value="Invia">
                </form>
            </div>

        </div>
    </div>



</body>
</html>