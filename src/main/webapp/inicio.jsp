<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.ppsoo.model.entities.Cliente"%>
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
                <a class="navbar-brand" href="ServletCliente">
                    <img src="logo.png" alt="" width="80" height="70">
                </a>
                <div>
                    <a href="index.jsp" class="btn btn-outline-danger" tabindex="-1" role="button" aria-disabled="true" style="margin-right: 10px;">Sair</a>
                    <button style="margin-right: 10px;" class="btn btn-outline-success" type="button" data-bs-toggle="offcanvas" data-bs-target="#canvasEquipe" aria-controls="offcanvasRight">Equipe</button>
                </div>
            </div>
        </nav>
        <main class="d-flex justify-content-center">
            <%
                Cliente cliente = (Cliente) session.getAttribute("cliente");
            %>
            <div class="card text-center" style="margin: 30px;">
                <div class="card-body">
                  <h5 class="card-title">Faça seu pedido!</h5>
                  <p class="card-text">Monte seu bolo do seu jeito, de forma fácil e rápida.</p>
                  <a href="ServletPedido?op=criarPedido" class="btn btn-primary">Fazer Pedido</a>
                </div>
            </div>
            <div class="card text-center" style="margin: 30px;">
                <div class="card-body">
                  <h5 class="card-title">Pedidos Feitos</h5>
                  <p class="card-text">Veja os pedidos que você realizou.</p>
                  <a href="ServletPedido?op=verPedidos&idCliente=<%= cliente.getId() %>" class="btn btn-primary">Ver Pedidos</a>
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