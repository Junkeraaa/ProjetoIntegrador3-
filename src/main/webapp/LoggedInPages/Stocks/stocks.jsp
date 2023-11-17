<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="stocks.css">
    <link rel="icon" type="image/x-icon" href="Imgs/logo.ico">
</head>
<body>

    <section class="head">

    <header>

        <a class="logo" href="../loggedIn.jsp"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>



    </header>

    <div class="textAsset">Renda Variável</div>

    <hr class="line">

    <div class="corner-text">
        <span>${sessionScope.user}</span> | Saldo:  <span>${sessionScope.saldo}</span>
    </div>

    </section>
<div class="conteiners">
    
    <div class="conteiner-main">
        <table>
            <thead>
                <tr>
                    <th>Ação</th>
                    <th>Vl-Início</th>
                    <th>$-Ação</th>
                    <th>Balanço</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>PETR4</td>
                    <td>R$ 19,00</td>
                    <td>R$ 20,00</td>
                    <td>1%</td>
                    <td class="action-buttons">
                        <button>Compra</button>
                        <button>Venda</button>
                    </td>
                </tr>
                <tr>
                    <td>APPL</td>
                    <td>R$ 10,00</td>
                    <td>F$ 20,00</td>
                    <td>100%</td>
                    <td class="action-buttons">
                        <button>Compra</button>
                        <button>Venda</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    

</div>



</body>
</html>
