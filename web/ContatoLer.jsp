<%-- 
    Document   : contatoSucesso
    Created on : 10/08/2017, 20:37:58
    Author     : ice
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ContatoLer</title>
    </head>
    <body>
        <h1>Contato</h1>
        <p>
            <table border = '1'> 
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>E-mail</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${codigo}</td>
                        <td>${nome}</td>
                        <td>${email}</td>
                    </tr>
                </tbody>
            </table>
        </p>
    </body>
</html>
