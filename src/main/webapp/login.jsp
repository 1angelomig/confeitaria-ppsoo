<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" ; charset="UTF-8">
    <title>Confeitaria</title>
    <link rel="icon" href="logo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

<body class="d-flex justify-content-center">
    <div style="height: 100vh; width: 800px; background-color: rgb(227, 231, 210);">
        <nav class="navbar bg-light">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">
                    <img src="logo.png" alt="" width="80" height="70">
                </a>
                <button style="margin-right: 10px;" class="btn btn-outline-success" type="button" data-bs-toggle="offcanvas" data-bs-target="#canvasEquipe" aria-controls="offcanvasRight">Equipe</button>
            </div>
        </nav>
        <%
            String message = (String) session.getAttribute("msg");

            if(message != null){
        %>
        <div class="card text-center" style="margin: 30px;">
            <div class="card-body">
                <h5 class="card-title"><%= message %></h5>
            </div>
        </div>  
        <%
            }
        %>
        <c:remove var="msg" scope="session"/>
        <main>
            <div class="card" style="margin: 30px;">
                <div class="card-body">
                    <h5 class="card-title">Login</h5>
                    <form method="post" action="ServletCliente?op=login">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                            <label for="senha" class="form-label">Senha</label>
                            <input type="password" class="form-control" id="senha" name="senha">
                        </div>
                        <button type="submit" class="btn btn-primary">Entrar</button>
                    </form>
                </div>
            </div>
        </main>
    </div>

    <div class="offcanvas offcanvas-end" tabindex="-1" id="canvasEquipe" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">Equipe de Desenvolvimento</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <h6>Bruno Holder</h6>
            <h6>Larissa Silva</h6>
            <h6>Miguel Angelo</h6>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>

</html>