<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Groupes</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
    <!-- Ajout du lien vers Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <jsp:include page="../fragments/userheader.jsp" />
</head>
<body>
    <div class="container">
        <h2>Liste des Groupes</h2>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Nombre de membres</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="grp" items="${groupeList}">
                        <tr>
                            <td><c:out value="${grp.nomGroupe}" /></td>
                            <td><c:out value="${grp.getEnseignants().size()}" /></td>
                            <td>
                                <ul>
                                    <li><a class="modifier" href="<c:url value='/groupe/modifierGroupeForm?idGroupe=${grp.idGroupe}' />">Modifier</a></li>
                                    <li><a class="supprimer" href="<c:url value='/groupe/deleteGroupe/${grp.idGroupe}' />" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce groupe ?');">Supprimer</a></li>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <a href="<c:url value='/groupe/initGroupe' />" class="btn btn-primary">Ajouter un nouveau groupe</a>
    </div>
    <jsp:include page="../fragments/userfooter.jsp" />
</body>
</html>
