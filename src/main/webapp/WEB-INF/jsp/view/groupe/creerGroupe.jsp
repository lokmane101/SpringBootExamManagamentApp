<%@ page import="com.Exams.core.web.models.PersonnelModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
    

    <div>
        <h2>
            Créer un Groupe 
            <c:if test="${typeGroupe == 1}">
                par Filière
            </c:if>
            <c:if test="${typeGroupe == 2}">
                par Département
            </c:if>
            <c:if test="${typeGroupe == 3}">
                avec des Enseignants
            </c:if>
        </h2>
    </div>

    <div>
        <c:if test="${not empty msg}">
            <div class="alert alert-success" role="alert">${msg}</div>
        </c:if>
        <c:if test="${not empty msg1}">
            <div class="alert alert-success" role="alert">${msg1}</div>
        </c:if>
        <c:if test="${not empty msg2}">
            <div class="alert alert-${msg2Type}" role="alert">${msg2}</div>
        </c:if>
        
        <c:if test="${typeGroupe == 1}">
            <f:form action="${pageContext.request.contextPath}/groupe/CreerGroupeParFiliere" method="POST" modelAttribute="groupeModel">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="row">
                    <div class="col">
                        <label>Nom du Groupe</label>
                        <f:input path="nomGroupe" type="text" class="form-control" placeholder="nom" />
                        <f:errors path="nomGroupe" class="text-danger" />
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="nomFiliere">Filière</label>
                        <select name="nomFiliere" id="nomFiliere" class="form-control">
                            <c:forEach items="${filiereList}" var="f">
                                <option value="${f.nomFiliere}">
                                    <c:out value="${f.nomFiliere}" />
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div style="text-align: right">
                    <button type="submit" class="btn btn-primary">Créer</button>
                    <button type="reset" class="btn btn-secondary">Annuler</button>
                </div>
            </f:form>
        </c:if>

        <c:if test="${typeGroupe == 2}">
            <f:form action="${pageContext.request.contextPath}/groupe/CreerGroupeParDepartement" method="POST" modelAttribute="groupeModel">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="row">
                    <div class="col">
                        <label>Nom du Groupe</label>
                        <f:input path="nomGroupe" type="text" class="form-control" placeholder="nom" />
                        <f:errors path="nomGroupe" class="text-danger" />
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="nomDepartement">Département</label>
                        <select name="nomDepartement" id="nomDepartement" class="form-control">
                            <c:forEach items="${departementList}" var="d">
                                <option value="${d.nomDepartement}">
                                    <c:out value="${d.nomDepartement}" />
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div style="text-align: right">
                    <button type="submit" class="btn btn-primary">Créer</button>
                    <button type="reset" class="btn btn-secondary">Annuler</button>
                </div>
            </f:form>
        </c:if>

        <c:if test="${typeGroupe == 3}">
            <f:form action="${pageContext.request.contextPath}/groupe/CreerGroupe" method="POST" modelAttribute="groupeModel">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="row">
                    <div class="col">
                        <label>Nom du Groupe</label>
                        <f:input path="nomGroupe" type="text" class="form-control" placeholder="nom" />
                        <f:errors path="nomGroupe" class="text-danger" />
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="selectedProfessors">Enseignants</label>
                        <select name="selectedProfessors" id="selectedProfessors" class="form-control" multiple>
                            <c:forEach items="${enseignantList}" var="prof">
                                <option value="${prof.idPersonnel}">
                                    <c:out value="${prof.nom} ${prof.prenom}" />
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div style="text-align: right">
                    <button type="submit" class="btn btn-primary">Créer</button>
                    <button type="reset" class="btn btn-secondary">Annuler</button>
                </div>
            </f:form>
        </c:if>
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