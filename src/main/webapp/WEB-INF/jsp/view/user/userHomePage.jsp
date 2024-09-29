<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/userheader.jsp" />

<div class="container content-container d-flex justify-content-center align-items-start">
    <div class="row w-100">
        <div class="col-md-6 d-flex flex-column align-items-center">
            <h2 class="main-title">Gestion des Examens ENSAH</h2>
            <img src="${pageContext.request.contextPath}/resources/img/ensah.png" alt="ENSAH" class="img-fluid ensah-image">
        </div>
        <div class="col-md-6 d-flex justify-content-center align-items-center position-relative">
            <div class="description-box-wrapper d-flex justify-content-center align-items-center">
                <div class="description-box">
                    <p class="description-text">Optimisez la gestion de votre établissement et simplifiez l'organisation des examens grâce à une solution complète et intuitive.<br><br>
                    Gérez efficacement les enseignants, Administrateurs, Elément Pédagogique, planifiez des cours et organisez des examens.<br><br>
                    Communiquez facilement, analysez les résultats et accédez à des informations sécurisées.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../fragments/userfooter.jsp" />
