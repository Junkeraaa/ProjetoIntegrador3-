
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
            <table class="conteiner-main">
                <thead>
                    <tr>
                        <th>Ação</th>
                        <th>Vl-Início</th>
                        <th>$-Ação</th>
                        <th>Balanço</th>
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
                            <td><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="#ffffff" viewBox="0 0 256 256"><path d="M136,120v56a8,8,0,0,1-16,0V120a8,8,0,0,1,16,0ZM239.86,98.11,226,202.12A16,16,0,0,1,210.13,216H45.87A16,16,0,0,1,30,202.12l-13.87-104A16,16,0,0,1,32,80H68.37L122,18.73a8,8,0,0,1,12,0L187.63,80H224a16,16,0,0,1,15.85,18.11ZM89.63,80h76.74L128,36.15ZM224,96H32L45.87,200H210.13Zm-51.16,23.2-5.6,56A8,8,0,0,0,174.4,184a7.44,7.44,0,0,0,.81,0,8,8,0,0,0,7.95-7.2l5.6-56a8,8,0,0,0-15.92-1.6Zm-89.68,0a8,8,0,0,0-15.92,1.6l5.6,56a8,8,0,0,0,8,7.2,7.44,7.44,0,0,0,.81,0,8,8,0,0,0,7.16-8.76Z"></path></svg></td>


                         </tr>
                     </c:forEach>
                 </tbody>

            </table>
    </div>
</body>
</html>
