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

               <span>${sessionScope.user}</span> | Saldo: <span>${sessionScope.saldo}</span>  <a class="buyIncomesink" href="#" ><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="#ffff" viewBox="0 0 256 256"><path d="M136,120v56a8,8,0,0,1-16,0V120a8,8,0,0,1,16,0ZM239.86,98.11,226,202.12A16,16,0,0,1,210.13,216H45.87A16,16,0,0,1,30,202.12l-13.87-104A16,16,0,0,1,32,80H68.37L122,18.73a8,8,0,0,1,12,0L187.63,80H224a16,16,0,0,1,15.85,18.11ZM89.63,80h76.74L128,36.15ZM224,96H32L45.87,200H210.13Zm-51.16,23.2-5.6,56A8,8,0,0,0,174.4,184a7.44,7.44,0,0,0,.81,0,8,8,0,0,0,7.95-7.2l5.6-56a8,8,0,0,0-15.92-1.6Zm-89.68,0a8,8,0,0,0-15.92,1.6l5.6,56a8,8,0,0,0,8,7.2,7.44,7.44,0,0,0,.81,0,8,8,0,0,0,7.16-8.76Z"></path></svg>

               <div class = "conteiner-incomes">
                <div class = "buyIncomesForm" style = "display: none">
                   <form action="/buyIncomes" method="post">
                       <input type="text" id="buyIncomes" name="buyIncomes" placeholder="Digite a empresa" required>
                   </form>

                </div>

                </div>
               </a>


                </div>
    </section>

    <div class="conteiners">
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
                    <c:forEach var="fixedIncome" items="${incomesList}">

                        <tr>
                            <td>${fixedIncome.getName()}</td>
                            <td>${fixedIncome.getType()}</td>
                            <td>${fixedIncome.getPrice()}</td>
                            <td>${fixedIncome.getFee()}%</td>
                        </tr>
                 </c:forEach>
                </tbody>
            </table>
    </div>

    <script>
       const buyIncomesLink = document.querySelector('.buyIncomesink');
       const buyIncomesForm = document.querySelector('.buyIncomesForm');

       buyIncomesLink.addEventListener('click', () => {
           buyIncomesForm.style.display = 'block';
           buyIncomesForm.style.transform = 'translateY(0)';
           buyIncomesForm.style.transition = 'transform 0.5s ease-in-out';
       });


    </script>
</body>
</html>
