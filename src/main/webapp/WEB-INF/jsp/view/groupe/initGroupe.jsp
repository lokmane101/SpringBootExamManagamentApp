<%@page import="com.Exams.core.web.models.PersonnelModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container">
    <div>
        <h2>Ajouter un Groupe</h2>
    </div>

    <div>
        <a href="derictToCreerGroupeParFiliere" class="btn btn-custom">Créer Groupe par Filière</a>
        <a href="derictToCreerGroupeParDepartement" class="btn btn-custom">Créer Groupe par Département</a>
        <a href="derictToCreerGroupe" class="btn btn-custom">Créer Groupe</a>
    </div>

    <div style="margin-bottom: 50px;"></div>
</div>

<jsp:include page="../fragments/userfooter.jsp" />
