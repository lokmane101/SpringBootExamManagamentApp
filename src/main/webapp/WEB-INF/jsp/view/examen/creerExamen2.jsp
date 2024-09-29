<%@ page import="com.Exams.core.bo.Surveillance" %>
<%@ page import="com.Exams.core.bo.Salle" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
    <div>
        <h2>Choisir le nombre de professeurs pour chaque salle et le type d'assignement</h2>
    </div>
    <form:form action="${pageContext.request.contextPath}/examen/UpdateExam2" method="POST" modelAttribute="examenModel">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <c:forEach var="surveillance" items="${examenModel.surveillances}">
            <div class="surveillance-input" style="margin-top: 20px;">
                <label class="surveillance-label" for="${surveillance.salle.nomSalle}">La salle : <span >${surveillance.salle.nomSalle}</span></label>
                <input type="number" id="${surveillance.salle.nomSalle}" name="${surveillance.salle.nomSalle}" min="0" value="2" required/>
            </div>
        </c:forEach>

        <div class="group" style="margin-top: 50px;">
            <input type="radio" id="groupeAssignmet" name="assignmentMethod" value="groupeAssignmet" required>
            <label for="groupeAssignmet">Assigner surveillants par groupe</label>
            <input type="radio" id="randomAssignment" name="assignmentMethod" value="randomAssignment" required>
            <label for="randomAssignment">Assigner surveillants aléatoirement</label>
        </div>

        <div style="text-align: right; margin-top: 20px;">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <button type="reset" class="btn btn-secondary">Annuler</button>
        </div>
    </form:form>
</div>

<jsp:include page="../fragments/userfooter.jsp" />
