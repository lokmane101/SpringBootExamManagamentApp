<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
    

    <div>
        <h2>Modification d'un Element Pédagogique</h2>
    </div>

    <div>
        <form:form action="${pageContext.request.contextPath}/user/modifierElement" method="POST" modelAttribute="elementPedagogiqueModel">
            <input type="hidden" name="idElementPedagogique" value="${elementPedagogiqueModel.idElementPedagogique}">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <div class="row">
                <div class="col">
                    <label>Titre</label>
                    <form:input path="titre" type="text" class="form-control" placeholder="Titre" />
                    <form:errors path="titre" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Enseignant</label>
                    <form:select path="enseignant" class="form-control" items="${ListEnseignants}" itemValue="idPersonnel" itemLabel="nom" />
                    <form:errors path="enseignant" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Coordinateur</label>
                    <form:select path="coordinateur" class="form-control" items="${ListEnseignants}" itemValue="idPersonnel" itemLabel="nom" />
                    <form:errors path="coordinateur" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Type Element</label>
                    <form:select path="typeElement" class="form-control" items="${ListTypesElements}" itemValue="idTypeElement" itemLabel="titre" />
                    <form:errors path="typeElement" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Niveau</label>
                    <form:select path="niveau" class="form-control" items="${ListNiveaux}" itemValue="idNiveau" itemLabel="titre" />
                    <form:errors path="niveau" class="text-danger" />
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