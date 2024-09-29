<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
	<div>
		<h2>
			Mise à jour d'un
			<c:if test="${personnelModel.typePersonnel== 1}" var="variable">
					Administrateur
				</c:if>
			<c:if test="${personnelModel.typePersonnel== 2}" var="variable">
					Enseignant
				</c:if>



		</h2>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/user/ModifierPersonnel"
			method="POST" modelAttribute="personnelModel">
			<f:hidden path="idPersonnel" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">

			<f:hidden path="typePersonnel" />
 
			<div class="row">

				<div class="col">
					<label>Nom</label>
					<f:input path="nom" type="text" class="form-control"
						placeholder="nom" />
					<f:errors path="nom" class="text-danger" />
				</div>
			</div>


			<div class="row">
				<div class="col">
					<label>Prénom</label>
					<f:input path="prenom" type="text" class="form-control"
						placeholder="prenom" />
					<f:errors path="prenom" class="text-danger" />
				</div>
			</div>


			<div class="row">
				<c:if test="${personnelModel.typePersonnel == 2}">
                <div class="row">
                    <div class="col">
                        <label>Filière</label>
                        <f:select path="filiere" class="form-control" items="${filiereList}" itemValue="idFiliere" itemLabel="nomFiliere" />
                        <f:errors path="filiere" class="text-danger" />
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label>Département</label>
                        <f:select path="departement" class="form-control" items="${departementList}" itemValue="idDepartement" itemLabel="nomDepartement" />
                        <f:errors path="departement" class="text-danger" />
                    </div>
                </div>
           
            </c:if>

			</div>


			<div style="text-align: right">
				<button type="submit" class="btn btn-primary">Modifier</button>
				<button type="reset" class="btn btn-secondary">Annuler</button>
			</div>

		</f:form>
	</div>



	<jsp:include page="../fragments/userfooter.jsp" />