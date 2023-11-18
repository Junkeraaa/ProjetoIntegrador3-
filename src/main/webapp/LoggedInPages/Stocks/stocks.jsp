
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="/LoggedInPages/Stocks/stocks.css">
    <link rel="icon" type="image/x-icon" href="/Imgs/logo.ico">
    <meta http-equiv="Refresh" content="5">
</head>

<body>

    <section class="head">

        <header>

            <a class="logo" href="/LoggedInPages/loggedIn.jsp"><img src="/Imgs\LogoSuutz.png" alt=""></a>

        </header>

        <div class="textAsset">Renda Variável</div>

        <hr class="line">

        <div class="corner-text">
            <span>${sessionScope.user}</span> | Saldo: <span>${sessionScope.saldo}</span>
        </div>

    </section>
    <div class="conteiners">

        <div class="conteiner-main">
            <table>
                <thead>
                    <tr>
                        <th>Ação</th>
                        <th>Vl-Inicio</th>
                        <th>$-Acao</th>
                        <th>Balanco</th>
                        <th></th>
                    </tr>
                </thead>
                 <tbody>
                     <c:forEach var="stock" items="${stocksList}" varStatus="status">
                         <tr>
                             
                            <td>${stock.getNameStock()}</td>
                            <td>R$ ${sessionScope.stockInitialValues[status.index]}</td>
                            <td>R$ ${stock.getPriceStock()}</td>
                            <td>R$ ${stockBalance}</td>
                            <td><button>Comprar</button></td>


                         </tr>
                     </c:forEach>
                 </tbody>

            </table>
        </div>
    </div>
</body>
</html>
