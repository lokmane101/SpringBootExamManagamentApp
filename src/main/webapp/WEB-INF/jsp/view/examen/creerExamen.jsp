<%@ page import="com.Exams.core.web.models.PersonnelModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<jsp:include page="../fragments/userheader.jsp" />
<div class="container">
   
   <div>
       <h2>
           Planifier un Examen
       </h2>
   </div>
  
       <c:if test="${not empty msg}">
            <div class="alert alert-success" role="alert">${msg}</div>
        </c:if>
      
      
           <f:form action="${pageContext.request.contextPath}/examen/UpdateExam" method="POST" modelAttribute="examenModel">
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
              
               <div class="row">
                   <div class="col">
                       <label for="nomElement">Elément pédagogique</label>
                       <select name="nomElement" id="nomElement" class="form-control" required>
                           <c:forEach items="${elementList}" var="e">
                               <option value="${e.titre}">
                                   <c:out value="${e.titre}" />
                               </option>
                           </c:forEach>
                       </select>
                   </div>
               </div>
              
               <div class="row">
                   <div class="col">
                       <label for="selectedSalle">Salle</label>
                       <select name="selectedSalle" id="selectedSalle" class="form-control" multiple required>
                           <c:forEach items="${salleList}" var="s">
                               <option value="${s.nomSalle}">
                                   <c:out value="${s.nomSalle}" />
                               </option>
                           </c:forEach>
                       </select>
                   </div>
               </div>
               <div class="row">
                   <div class="col">
                       <label for="typeExamenList">Type Examen</label>
                       <select name="selectedTypeExamen" id="selectedTypeExamen" class="form-control" required >
                           <c:forEach items="${typeExamenList}" var="t">
                               <option value="${t.intitule}">
                                   <c:out value="${t.intitule}" />
                               </option>
                           </c:forEach>
                       </select>
                   </div>
                   </div>
                    <div class="row">
                   <div class="col">
                       <label for="typeExamenList">Session</label>
                       <select name="session" id="session" class="form-control" required >
                           <c:forEach items="${sessionList}" var="s">
                               <option value="${s.intitule}">
                                   <c:out value="${s.intitule}" />
                               </option>
                           </c:forEach>
                       </select>
                   </div>
                   </div>
                   <div class="row">
                   <div class="col">
                       <label for="coordinateur">Coordinateur</label>
                       <select name="coordinateur" id="coordinateur" class="form-control" required>
                           <c:forEach items="${enseignantList}" var="e">
                               <option value="${e.idPersonnel} ">
                                   <c:out value="${e.nom}" />
                               </option>
                           </c:forEach>
                       </select>
                   </div>
               </div>
    			<div class="row">
				   <div class="col">
				       <label for="date">Date</label>
				       <f:input path="date" type="date" class="form-control" placeholder="Date"  />
				       <f:errors path="date" class="text-danger" />
				    </div>
				    </div>
				    <div class="row">
				    <div class="col">
				        <label for="dureePrevue">Durée prévue</label>
							<f:input path="dureePrevue" type="text" class="form-control"  required="required" placeholder="H:mm"
							     pattern="([1-9]):[0-5][0-9]" title="Veuillez entrer un format d'heure valide (H:mm)" ></f:input>
				        <f:errors path="dureePrevue" class="text-danger" />
				    </div>
				    </div>
				    <div class="row">
				    <div class="col">
				        <label for="heureDeDebut">Heure de début</label>
				       <f:input path="heureDeDebut" type="text" class="form-control"
				         placeholder="HH:mm" required="required" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]"
				         title="Veuillez entrer un format d'heure valide (HH:mm)" ></f:input>
				        <f:errors path="heureDeDebut" class="text-danger" />
				    </div>
				    </div>
				    
				    </div>
               <div style="text-align: right">
                   <button type="submit" class="btn btn-primary">Suivant</button>
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
