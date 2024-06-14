<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product App | Liste</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@include file="topBar.jsp "%>
    <div class="center mt-5 container col-md-10 col-md-offset-1">
        <div class="card">
            <div class="card-header">Liste des produits</div>
            <div class="card-body">
                <form action="search.do" method="get">
                    <div>
                        <label>Mot Cle</label>
                        <input type="text" name="motCle">
                        <button type="submit" class="btn btn-success">Rechercher</button>
                    </div>
                </form>
                <table class="center mb-3 table table-striped table-bordered">
                    <tr class="table-primary">
                        <th>ID</th>
                        <th>Designation</th>
                        <th>Prix</th>
                        <th>Quantite</th>
                        <th>Montant</th>
                        <th colspan="2">Action</th>
                    </tr>
                    <c:forEach items="${prodModel.produits}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.designation}</td>
                            <td>${p.prix}</td>
                            <td>${p.quantite}</td>
                            <td>${p.prix * p.quantite}</td>
                            <td>
                                <a href="edit.do?id=${p.id}" class="btn btn-outline-warning">Modifier</a>
                                <a href="delete.do?id=${p.id}" class="btn btn-outline-danger">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4">Montant Total</td>
                        <td>${ prodModel.total }</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
