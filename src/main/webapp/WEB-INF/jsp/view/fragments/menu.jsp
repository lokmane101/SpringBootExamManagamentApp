<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav me-auto">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page"
               href="${pageContext.request.contextPath}/user/showuserHome">Accueil</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">Gestion des Personels</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/showForm?typePerson=1">Ajouter un administrateur</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/showForm?typePerson=2">Ajouter un enseignant</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/ListerPersonnels">Liste des personnels</a>
                </li>
            </ul>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">Gestion des Groupes</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/groupe/initGroupe">Ajouter un groupe</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/groupe/ListerGroupes">Liste des groupes</a>
                </li>
            </ul>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">Gestion des �l�ments p�dagogiques</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/showAddForm">Ajouter un �l�ment p�dagogique</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/ListerElementPedagogiques">Liste des �l�ments p�dagogiques</a>
                </li>
            </ul>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">Gestion des examens</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/examen/initExam">Planifier un examen</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/examen/ListerExamens">Liste des Examens Planifi�s</a>
                </li>
            </ul>
        </li>
        <li  class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath}/aPropos">� propos </a>    </li>
    </ul>
    <f:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-logout">Se d�connecter</button>
    </f:form>
</div>
