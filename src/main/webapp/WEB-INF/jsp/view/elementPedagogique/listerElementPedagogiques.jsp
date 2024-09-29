<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Éléments Pédagogiques</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
    <!-- Ajout du lien vers Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <jsp:include page="../fragments/userheader.jsp" />
</head>
<body>
    <div class="container">
        <h2>Liste des Éléments Pédagogiques</h2>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th scope="col">Titre</th>
                        <th scope="col">Niveau</th>
                        <th scope="col">Enseignant</th>
                        <th scope="col">Coordinateur</th>
                        <th scope="col">Type</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="element" items="${elementPedagogiqueList}">
                        <tr>
                            <td><c:out value="${element.titre}" /></td>
                            <td><c:out value="${element.niveau.titre}" /></td>
                            <td><c:out value="${element.enseignant.nom}" /></td>
                            <td><c:out value="${element.coordinateur.nom}" /></td>
                            <td><c:out value="${element.typeElement.titre}" /></td>
                            <td>
                                <ul>
                                    <li><a class="modifier" href="<c:url value='/user/modifierElementForm?idElementPedagogique=${element.idElementPedagogique}' />">Modifier</a></li>
                                    <li><a class="supprimer" href="<c:url value='/user/deleteElementPedagogique/${element.idElementPedagogique}' />" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet élément ?');">Supprimer</a></li>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <a href="<c:url value='/user/showAddForm' />" class="btn btn-primary">Ajouter un nouvel élément pédagogique</a>
    </div>
    <jsp:include page="../fragments/userfooter.jsp" />
</body>
</html>
