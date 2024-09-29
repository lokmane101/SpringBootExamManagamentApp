<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
    

    <div>
        <h2>Modification d'un groupe</h2>
    </div>

    <div>
        <form:form action="${pageContext.request.contextPath}/groupe/modifierGroupe" method="POST" modelAttribute="groupeModel">
            <input type="hidden" name="idGroupe" value="${groupeModel.idGroupe}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <div class="row">
                <div class="col">
                    <label>Nom du Groupe</label>
                    <form:input path="nomGroupe" type="text" class="form-control" placeholder="nom du groupe" />
                    <form:errors path="nomGroupe" class="text-danger" />
                </div>
            </div>
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <button type="reset" class="btn btn-secondary">Annuler</button>
            </div>
        </form:form>
    </div>

    <style>
        label {
            font-size: 16px;
        }
        .form-control {
            width: 800px;
        }
        .row {
            margin-bottom: 15px;
        }
    </style>
</div>

    <jsp:include page="../fragments/userfooter.jsp" />