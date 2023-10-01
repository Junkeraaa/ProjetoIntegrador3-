document.addEventListener("DOMContentLoaded", function () {
console.log("DOMContentLoaded event fired");

    const alertElement = document.getElementById("alert");

    // Verifique se o alerta contém uma mensagem de erro e exiba-o
    const urlParams = new URLSearchParams(window.location.search);
    const error = urlParams.get("error");

    if (error) {
        alertElement.textContent = error;
        alertElement.style.display = "block";
    }
});

