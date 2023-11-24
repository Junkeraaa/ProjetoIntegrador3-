<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="LoggedInPages/MyAssets/myAssets.css">
    <link rel="icon" type="image/x-icon" href="Imgs/logo.ico">
</head>
<body>

    <section class="head">
        <header>
            <a class="logo" href="/LoggedInPages/loggedIn.jsp"><img src="/Imgs\LogoSuutz.png" alt=""></a>
        </header>
    
        <div class="textAsset">Meus Ativos</div>
    
        <hr class="line">
    
        <div class="corner-text">
            <span>${sessionScope.user}</span> | Saldo:  <span>${sessionScope.saldo}</span>
            <a class="updateBalanceLink" href="#">
                <img src="../..\Imgs\Mais.png" alt="">
                <div class="conteiner-plus">

                    <div id="updateBalanceForm" style="display: none;">
                        <form action="/UpdateBalanceServlet" method="post">
                            <input type="number" id="newBalance" name="newBalance" required>
                            <button type="submit">Atualizar Saldo</button>
                        </form>
                    </div>
                    

                </div>
            </a>
        </div>
    </section>
    
    <div class="conteiners">
        <div class="conteiner-left">Mensagem teste</div>
        <div class="conteiner-right">Mensagem teste</div>
    </div>
    
    
    
    
    <script>
        const updateBalanceLink = document.querySelector('.updateBalanceLink');
        const updateBalanceForm = document.getElementById('updateBalanceForm');
        
        updateBalanceLink.addEventListener('click', () => {
            updateBalanceForm.style.display = 'block';
            updateBalanceForm.style.transform = 'translateY(0)';
            updateBalanceForm.style.transition = 'transform 0.5s ease-in-out';
        });
        
    </script>

</body>
</html>

