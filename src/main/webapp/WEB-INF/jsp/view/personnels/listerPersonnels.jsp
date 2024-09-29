<%@page import="com.Exams.core.web.models.PersonnelModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<div class="header-container">
    <jsp:include page="../fragments/userheader.jsp" />
</div>

<div class="container">  
    <h2>Liste des Personnels</h2>
    <div class="table-wrapper">
        <table class="fl-table">
            <thead>
                <tr>
                    <th scope="col">Type personnel</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${personnelsList}" var="p">
                    <tr>
                        <td>
                            <c:if test="${p.typePersonnel == 2}">
                                <span class="badge bg-primary">Enseignant</span>
                            </c:if>
                            <c:if test="${p.typePersonnel == 1}">
                                <span class="badge bg-success">Administrateur</span>
                            </c:if>
                        </td>
                        <td><c:out value="${p.nom}" /></td>
                        <td><c:out value="${p.prenom}" /></td>
                        <td>
                            <ul>
                                <li><a class="supprimer" href="${pageContext.request.contextPath}/user/deletePersonnel/${p.idPersonnel}"" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce personnel ?');">Supprimer</a></li>
                                <li><a class="modifier" href="${pageContext.request.contextPath}/user/ModifierPersonnelForm/${p.idPersonnel}">Modifier</a></li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
         <a href="<c:url value='/user/showForm?typePerson=1' />" class="btn btn-primary">Ajouter un administrateur</a>   
         <a href="<c:url value='/user/showForm?typePerson=2' />" class="btn btn-primary">Ajouter un enseignant</a>
        
    
</div>

    <jsp:include page="../fragments/userfooter.jsp" />