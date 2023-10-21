<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registre-se</title>
    <link rel="stylesheet" href="/LoggedOutPages/RegisterPage/register.css">
</head>
<body>

<div class="head">
    <a class="logo" href="../../index.html"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>
</div>
<div class="container-full">

 <div class="condicional">

    <% Boolean hasMessageUser = (Boolean)request.getAttribute("hasMessageUser");
    Boolean hasMessagePassword = (Boolean)request.getAttribute("hasMessagePassword");
    Boolean hasMessageFinal = (Boolean)request.getAttribute("hasMessageFinal");
    String existUser = (String)request.getAttribute("existUser");
    String passwordMessage = (String)request.getAttribute("passwordMessage");
    String successMessage = (String)request.getAttribute("Success");

   if (hasMessageUser != null && hasMessageUser) {
       %>
       <div id="message" class="message" role="alert">
       <!-- Usuário existente-->
           <strong>ATTENTION!</strong> <%= existUser %>
           <button type="button" id="closeButton" class="close-button">X</button>
       </div>
       <%
       } else if (hasMessagePassword != null && hasMessagePassword) {
       %>
       <!-- Senha menor que 6 caracteres -->
       <div id="message" class="message" role="alert">
                  <strong>ATTENTION!</strong> <%= passwordMessage %>
                  <button type="button" id="closeButton" class="close-button">X</button>
              </div>
       <%
       } else if(hasMessageFinal != null && hasMessageFinal){
           %>
              <div id="messageSuccess" class="messageSuccess" role="alert">
                  <strong>SUCCESS!</strong> <%= successMessage %>
                  <button type="buttonSuccess" id="closeButtonSuccess" class="close-button">X</button>
              </div>
       <%
       }
       %>

</div>

<div class="container">
    <h2>Registro de Usuário</h2>
    <form action="/register" method="post">
        <label for="username">Login:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Registrar</button>
    </form>
</div>



</div>

<script>

var messageSuccessDiv = document.getElementById('messageSuccess');
var messageDiv = document.getElementById('message');

function closeMessageSuccess() {
    messageSuccessDiv.remove();

    setTimeout(function() {
        window.location.href = 'index.html';
    }, 3000);
}

function closeMessage() {

    messageDiv.remove();

    }

if (messageSuccessDiv) {
    setTimeout(closeMessageSuccess, 3000);
}

if(messageDiv){
    setTimeout(closeMessage, 3000);

}

var closeButtonSuccess = document.getElementById('closeButtonSuccess');

if (closeButtonSuccess) {
    closeButtonSuccess.addEventListener('click', function() {
        closeMessageSuccess();
    });
}
</script>


</body>
</html>
