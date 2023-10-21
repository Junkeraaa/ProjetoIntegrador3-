<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="loggedIn.css">
</head>
<body>

    <section class="head">
    <header>

        <a class="logo" href="../../index.html"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>
       
    </header>


    <div class="corner-text">


        <%
           String user = (String)request.getAttribute("user");
           if (user != null) {
        %>
        <div id="username" class="username">
            <%= user %>
        </div>
        <%
           }
        %>


        <hr class="line">
    </div>


    </section>


    <div class="investments">

        <a href="" class="meusAtivos"><img src="../../Imgs/MeusAtivos.png" alt=""></a>
        <a href="" class="meusAtivos"><img src="../../Imgs/RendaFixa.png" alt=""></a>
        <a href="" class="meusAtivos"><img src="../../Imgs/RendaVariavel.png" alt=""></a>

    </div>

  


</body>
</html>
