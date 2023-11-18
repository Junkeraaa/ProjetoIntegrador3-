<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suutz Investments</title>
    <link rel="stylesheet" type="text/css" href="/LoggedInPages/Incomes/incomes.css">
    <link rel="icon" type="image/x-icon" href="Imgs/logo.ico">
</head>
<body>

    <section class="head">
        <header>
            <a class="logo" href="/LoggedInPages/loggedIn.jsp"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>
        </header>

        <div class="textAsset">Renda Fixa</div>
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
                        <th>Papel</th>
                        <th>Tipo-PRD</th>
                        <th>Apt-Min</th>
                        <th>Taxa(a.a)</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fixedIncome" items="${incomesList}">

                        <tr>
                            <td>${fixedIncome.getName()}</td>
                            <td>${fixedIncome.getType()}</td>
                            <td>1000</td>
                            <td>${fixedIncome.getFee()}%</td>
                            <td><button>Comprar</button></td>
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
