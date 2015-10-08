<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumo do Cumprimentar Service</title>
    </head>

    <body>
        <c:if test="${not empty resposta}">
            <p>Resposta do servidor: <strong>${resposta}</strong></p>
        </c:if>

        <form action="cumprimentar.go"
              method="POST">
            <label>
                Informe seu nome: 
                <input type="text" name="nome">
            </label>

            <input type="submit" value="Enviar">
        </form>
    </body>
</html>

