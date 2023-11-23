<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="loggedIn.css">
    <link rel="icon" type="image/x-icon" href="Imgs/logo.ico">
</head>
<body>

    <section class="head">
    <header>

        <a class="logo" href="../../index.html"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>
       
    </header>
    <div class="corner-text">
        <button id="redirectToIndexBtn">LogOut</button>

        <span>${sessionScope.user}</span>

        <hr class="line">
    </div>
    </section>


    <div class="investments">

        <a href="/getAssets" class="meusAtivos"><img src="../../Imgs/MeusAtivos.png" alt=""></a>
        <a href="/getIncomes" class="meusAtivos"><img src="../../Imgs/RendaFixa.png" alt=""></a>
        <a href="/getStocks" class="meusAtivos"><img src="/Imgs/RendaVariavel.png" alt=""></a>

    </div>

    <script>
        
        document.getElementById("redirectToIndexBtn").addEventListener("click", function() {
            
            window.location.href = "/index.html";
        });
    </script>


</body>
</html>
