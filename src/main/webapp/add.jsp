<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product App | Ajouter</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@include file="topBar.jsp" %>
    <div class="mt-5 container col-md-6 col-md-offset-1">
        <div class="card">
            <div class="center card-header">Ajout d'un produit</div>
            <div class="card-body">
                <form action="create.do" method="post">
                    <div class="form-group">
                        <label>Designation</label>
                        <input class="form-control" type="text" name="designation" required>
                    </div>
                    <div class="form-group">
                        <label>Prix</label>
                        <input class="form-control" type="text" name="prix" required>
                    </div>
                    <div class="form-group">
                        <label>Quantite</label>
                        <input class="form-control" type="text" name="quantite" required>
                    </div>
                    <div class="center form-group">
                        <input class="btn btn-info" type="submit" name="valider" value="Enregister">
                        <input class="btn btn-danger" type="reset" name="annuler" value="Annuler">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
