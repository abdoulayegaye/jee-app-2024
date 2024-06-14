<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Product App | Detail</title>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%@include file="topBar.jsp" %>
        <div class="mt-5 container col-md-5 col-md-offset-1">
            <div class="card">
                <div class="center card-header">Detail d'un produit</div>
                <div class="card-body">
                    <div>
                        <label>ID :</label>
                        <span><code>${produit.id}</code></span>
                    </div>
                    <div>
                        <label>Designation :</label>
                        <span><code>${produit.designation}</code></span>
                    </div>
                    <div>
                        <label>Prix :</label>
                        <span><code>${produit.prix}</code></span>
                    </div>
                    <div>
                        <label>Quantite :</label>
                        <span><code>${produit.quantite}</code></span>
                    </div>
                    <div class="center">
                        <a href="index.do" class="btn btn-outline-dark">Retour a liste de produits</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
