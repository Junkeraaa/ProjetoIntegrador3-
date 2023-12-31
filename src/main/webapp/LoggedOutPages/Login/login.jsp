<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="UTF-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login</title>
  <link rel="stylesheet" href="/LoggedOutPages/Login/login.css">
  <link rel="icon" type="image/x-icon" href="Imgs/logo.ico">
</head>
<body>

<div class="head">
    <a class="logo" href="../../index.html"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>
</div>

    <div class="container-full">
    <div class="condicional">

    <% Boolean hasMessage = (Boolean)request.getAttribute("hasMessage");
    String message = (String)request.getAttribute("message");

    if (hasMessage != null && hasMessage) {
    %>

    <div id="message" class="message" role="alert">
       <strong>ATTENTION!</strong> <%= message %>
       <button type="button" id="closeButton" class="close-button">X</button>
    </div>

    <%
    }
    %>
    
</div>


   <div class="container">
             


       <h2>Logar</h2>
       <form action="/login" method="post">
           <label for="username">Login:</label>
           <input type="text" id="username" name="username" required>

           <label for="password">Senha:</label>
           <input type="password" id="password" name="password" required>

           <button type="submit">Logar</button>
       </form>
   </div>

</div>

<script>

var messageDiv = document.getElementById('message');
var closeButton = document.getElementById('closeButton');


function closeMessage() {

    messageDiv.remove();
}


closeButton.addEventListener('click', function() {
    closeMessage();
});


setTimeout(closeMessage, 3000);


</script>


</body>
</html>