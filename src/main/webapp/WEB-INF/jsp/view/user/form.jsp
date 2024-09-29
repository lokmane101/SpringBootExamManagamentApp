<%@page import="com.Exams.core.web.models.PersonnelModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
    

    <div>
        <h2>
            Formulaire d'ajout d'un
            <c:if test="${personnelModel.typePersonnel == 2}">
                Enseignant
            </c:if>
            <c:if test="${personnelModel.typePersonnel == 1}">
                Administrateur
            </c:if>
        </h2>
    </div>
                 <c:if test="${not empty msg2}">
            <div class="alert alert-${msg2Type}" role="alert">${msg2}</div>
        </c:if>

    <div>
        <f:form action="${pageContext.request.contextPath}/user/addPersonnel" method="POST" modelAttribute="personnelModel">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <div class="row">
                <div class="col">
                    <label>Nom</label>
                    <f:input path="nom" type="text" class="form-control" placeholder="nom" />
                    <f:errors path="nom" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Prénom</label>
                    <f:input path="prenom" type="text" class="form-control" placeholder="prenom" />
                    <f:errors path="prenom" class="text-danger" />
                </div>
            </div>                      
            <f:hidden path="typePersonnel" />
      		
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

            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <button type="reset" class="btn btn-secondary">Annuler</button>
            </div>
        </f:form>
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
