<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Liste des Examens</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <jsp:include page="../fragments/userheader.jsp" />
</head>
<body>
<div class="container">
    <h2>Liste des Examens</h2>
    <div class="table-wrapper">
        <table class="fl-table">
            <thead>
                <tr>
                    <th>Element</th>
                    <th>Semestre</th>
                    <th>Date</th>
                    <th>Année Universitaire</th>
                    <th>Session</th>
                    <th>Type Examen</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="examen" items="${examenList}">
                    <tr>
                        <td><c:out value="${examen.elementPedagogique.titre}" /></td>
                        <td><c:out value="${examen.semestre.intitule}" /></td>
                        <td><c:out value="${examen.date}" /></td>
                        <td><c:out value="${examen.anneeUniversitaire}" /></td>
                        <td><c:out value="${examen.session.intitule}" /></td>
                        <td><c:out value="${examen.typeExamen.intitule}" /></td>
                        <td>
                            <ul>
                                <li><a class="associer" href="<c:url value='/examen/associerPVForm?idExamen=${examen.idExamen}' />">Associer un pv</a></li>
                                <li><a class="modifier" href="<c:url value='/examen/modifierExamenForm/${examen.idExamen}' />">Modifier</a></li>
                                <li><a class="supprimer" href="<c:url value='/examen/deleteExamen/${examen.idExamen}' />" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet Examen ?');">Supprimer</a></li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>

<jsp:include page="../fragments/userfooter.jsp" />
