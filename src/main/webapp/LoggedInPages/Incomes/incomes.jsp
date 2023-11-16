<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="incomes.css">
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
                    <th>Papel</th>
                    <th>Tipo-PRD</th>
                    <th>Apt-Min</th>
                    <th>Taxa(a.a)</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>CDB-ITAU</td>
                    <td>CDB</td>
                    <td>R$ 200,00</td>
                    <td>10%</td>
                    <td class="action-buttons">
                        <button>Compra</button>
                        <button>Venda</button>
                    </td>
                </tr>
                <tr>
                    <td>Pag2023</td>
                    <td>LCA</td>
                    <td>F$ 500,00</td>
                    <td>12%</td>
                    <td class="action-buttons">
                        <button>Compra</button>
                        <button>Venda</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    

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
