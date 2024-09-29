<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../fragments/userheader.jsp" />

   
<div class="container">
  <h2>Modification d'un Examen</h2>

  <form:form action="${pageContext.request.contextPath}/examen/associerPV" method="POST" modelAttribute="examenModel">
    <input type="hidden" name="idExamen" value="${examenModel.idExamen}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <div class="row">
      <div class="col">
        <label for="pv">PV</label>
        <form:input path="pv" type="file" id="pv" name="pvFile" class="form-control" required="required" />
        <form:errors path="pv" class="text-danger" />
        <form:hidden path="pv" id="pvPath" /> 
      </div>
    </div>

    <div class="row">
      <div class="col">
        <label for="epreuve">Epreuve</label>
        <form:input path="epreuve" type="file" id="epreuve" name="epreuveFile" class="form-control" required="required" />
        <form:errors path="epreuve" class="text-danger" />
        <form:hidden path="epreuve" id="epreuvePath" />
      </div>
    </div>

    <div class="row">
      <div class="col">
        <label for="rapportTextuelle">Rapport textuelle</label>
        <form:input path="rapportTextuelle" type="text" class="form-control" placeholder="Rapport textuelle" required="required"/>
        <form:errors path="rapportTextuelle" class="text-danger" />
      </div>
    </div>

    <div class="row">
      <div class="col">
        <label for="DureeReelle">Durée Réelle</label>
        <form:input path="dureeReelle" type="text" class="form-control" placeholder="H:mm" required="required" pattern="([1-9]):[0-5][0-9]" title="Veuillez entrer un format d'heure valide (H:mm)"/>
        <form:errors path="dureeReelle" class="text-danger" />
      </div>
    </div>

    <div style="text-align: right">
      <button type="submit" class="btn btn-primary">Enregistrer</button>
      <button type="reset" class="btn btn-secondary">Annuler</button>
    </div>
  </form:form>
</div>

<jsp:include page="../fragments/userfooter.jsp" />

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
