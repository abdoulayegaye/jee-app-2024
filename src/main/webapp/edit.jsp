<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product App | Modifier</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="topBar.jsp" %>
<div class="mt-5 container col-md-6 col-md-offset-1">
    <div class="card">
        <div class="center card-header">Edition d'un produit</div>
        <div class="card-body">
            <form action="index.do" method="post">
                <div class="form-group">
                    <label>ID</label>
                    <input class="form-control" type="text" name="id" value="${produit.id}" readonly disabled>
                </div>
                <div class="form-group">
                    <label>Designation</label>
                    <input class="form-control" type="text" name="designation" value="${produit.designation}" required>
                </div>
                <div class="form-group">
                    <label>Prix</label>
                    <input class="form-control" type="text" name="prix" value="${produit.prix}" required>
                </div>
                <div class="form-group">
                    <label>Quantite</label>
                    <input class="form-control" type="text" name="quantite" value="${produit.quantite}" required>
                </div>
                <div class="center form-group">
                    <input class="btn btn-success" type="submit" name="modifier" value="Modifier">
                    <input class="btn btn-danger" type="reset" name="annuler" value="Annuler">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
