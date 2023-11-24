<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="/LoggedInPages/MyAssets/myAssets.css">
    <link rel="icon" type="image/x-icon" href="Imgs/logo.ico">
    <meta http-equiv="Refresh" content="20">
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
        <div class="conteiner-left">

       <table class="conteiner-main">
                       <thead>
                           <tr>
                               <th>Papel</th>
                               <th>Tipo-PRD</th>
                               <th>Apt-Min</th>
                               <th>Taxa(a.a)</th>

                           </tr>
                       </thead>
                       <tbody>
                           <c:forEach var="listIncomeUser" items="${listIncomeUser}">

                               <tr>
                                   <td>${listIncomeUser.getName()}</td>
                                   <td>${listIncomeUser.getType()}</td>
                                   <td>${listIncomeUser.getPrice()}</td>
                                   <td>${listIncomeUser.getFee()}%</td>
                               </tr>
                        </c:forEach>
                       </tbody>
                   </table>



        </div>
        <div class="conteiner-right">
<table class="conteiner-main">
            <thead>
              <tr>
                <th>Ação</th>
                <th>Qtd</th>
                <th>Média Valor comprado</th>
                <th>Média Preço/Ação</th>
                <th>Balanço</th>
               </tr>
            </thead>
            <tbody>
              <c:forEach var="listStockUser" items="${listStockUser}" varStatus="status">
              <tr>
              <td>${listStockUser.getNameStock()}</td>
              <td>${listStockUser.getQtd()}</td>
              <td>R$ ${listStockUser.getPricePay()}</td>
               <td>R$ ${listStockUser.getPriceNow()}</td>
               <td>R$ ${listStockUser.getBalance()}</td>
               </tr>
                </c:forEach>
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

