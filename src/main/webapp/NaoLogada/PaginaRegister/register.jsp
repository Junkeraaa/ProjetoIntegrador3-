<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registre-se</title>
    <link rel="stylesheet" href="/NaoLogada/PaginaRegister/register.css">
</head>
<body>

<div class="head">
    <a class="logo" href="../../index.html"><img src="../..\Imgs\LogoSuutz.png" alt=""></a>
</div>
<div class="container-full">

 <div class="condicional">

    <% Boolean hasMessage = (Boolean)request.getAttribute("hasMessage");
    String existUser = (String)request.getAttribute("existUser");
    String passwordMessage = (String)request.getAttribute("passwordMessage");

   if (hasMessage != null && hasMessage) {
       %>
       <div id="message" class="message" role="alert">
       <!-- Usuário existente-->
           <strong>ATTENTION!</strong> <%= existUser %>
           <button type="button" id="closeButton" class="close-button">X</button>
       </div>
       <%
       } else if (hasMessage != null && hasMessage) {
       %>
       <!-- Senha menor que 6 caracteres -->
       <div id="message" class="message" role="alert">
                  <strong>ATTENTION!</strong> <%= passwordMessage %>
                  <button type="button" id="closeButton" class="close-button">X</button>
              </div>
       <%
       } else {
       %>

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

var messageDiv = document.getElementById('message');
var closeButton = document.getElementById('closeButton');


function closeMessage() {

    messageDiv.remove();
}


closeButton.addEventListener('click', function() {
    closeMessage();
});


setTimeout(closeMessage, 5000);


</script>

</body>
</html>
