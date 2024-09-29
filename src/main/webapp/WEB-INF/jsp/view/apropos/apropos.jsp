<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Our Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <style>    
    .propos{
    text-align: center;
    }
    .propos h2 {
            font-size:50px; /* Change this to the desired size */
            color: white; /* Optional: change the color */
            margin-top: 20px; /* Optional: add some top margin */
        }
    .propos p {
    		font-size:30px; /* Change this to the desired size */
            color: #363D45; /* Optional: change the color */
            margin-top: 20px; /* Optional: add some top margin */
    }
     
      .propos li {
    		font-size:30px; /* Change this to the desired size */
            color: #363D45; /* Optional: change the color */
            margin-top: 20px; /* Optional: add some top margin */
    }
       /*** FONTS ***/
        @import url('https://fonts.googleapis.com/css?family=Montserrat:900|Raleway:400,400i,700,700i');

        /*** VARIABLES ***/
        /* Colors */
        :root {
            --black: #1d1f20;
            --blue: #83e4e2;
            --green: #a2ed56;
            --yellow: #fddc32;
            --white: #fafafa;
        }

        /*** STYLE ***/
        * {
            box-sizing: border-box;
        }

        body {
            background-color: var(--white);
            color: var(--black);
            font-family: 'Raleway', sans-serif;
        }

        main {
            display: block;
            margin: 0 auto;
            max-width: 40rem;
            padding: 1rem;
            text-align: left;
        }

        ol.gradient-list {
            counter-reset: gradient-counter;
            list-style: none;
            margin: 1.75rem 0;
            padding-left: 1rem;
        }

        ol.gradient-list > li {
            background: white;
            border-radius: 0 0.5rem 0.5rem 0.5rem;
            box-shadow: 0.25rem 0.25rem 0.6rem rgba(0,0,0,0.05), 0 0.5rem 1.125rem rgba(75,0,0,0.05);
            counter-increment: gradient-counter;
            margin-top: 1rem;
            min-height: 3rem;
            padding: 1rem 1rem 1rem 3rem;
            position: relative;
        }

        ol.gradient-list > li::before,
        ol.gradient-list > li::after {
            background: linear-gradient(135deg, var(--blue) 0%, var(--green) 100%);
            border-radius: 1rem 1rem 0 1rem;
            content: '';
            height: 3rem;
            left: -1rem;
            overflow: hidden;
            position: absolute;
            top: -1rem;
            width: 3rem;
        }

        ol.gradient-list > li::before {
            align-items: flex-end;
            box-shadow: 0.25rem 0.25rem 0.6rem rgba(0,0,0,0.05), 0 0.5rem 1.125rem rgba(75,0,0,0.05);
            content: counter(gradient-counter);
            color: var(--black);
            display: flex;
            font: 900 1.5em/1 'Montserrat';
            justify-content: flex-end;
            padding: 0.125em 0.25em;
            z-index: 1;
        }

        ol.gradient-list > li + li {
            margin-top: 2rem;
        }
        </style>
</head>
<body>
    <jsp:include page="../fragments/userheader.jsp" />

    <div class="container">
        <h1 class="about">À propos de notre application</h1>
        <p class="aboutdesc">Cette application a été développée par: </p>
        <div class="profiles">
            <div class="profile">
                <div class="card-wrapper">
                    <div class="card">
                        <div class="card-image">
                            <img src="${pageContext.request.contextPath}/resources/img/AFKIR.png" alt="Afkir Mohamed">
                        </div>
                        <ul class="social-icons">
                            <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                            <li><a href="#"><i class="fab fa-github"></i></a></li>
                            <li><a href="#"><i class="fas fa-envelope"></i></a></li>
                        </ul>
                        <div class="details">
                            <h2><span class="job-title">Data & Software Engineer </span></h2>
                        </div>
                    </div>
                </div>
                <p><strong style="font-size: 2em; color: white;">Afkir Mohamed</strong></p>
            </div>
            <p style="font-size: 2em; color: white;">&</p>
            <div class="profile">
                <div class="card-wrapper">
                    <div class="card">
                        <div class="card-image">
                            <img src="${pageContext.request.contextPath}/resources/img/LOKMANE.png" alt="Akkouh Lokmane">
                        </div>
                        <ul class="social-icons">
                            <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                            <li><a href="#"><i class="fab fa-github"></i></a></li>
                            <li><a href="#"><i class="fas fa-envelope"></i></a></li>
                        </ul>
                        <div class="details">
                            <h2><span class="job-title">Data & Software Engineer </span></h2>
                        </div>
                    </div>
                </div>
                <p><strong style="font-size: 2em; color: white;">Akkouh Lokmane</strong></p>
            </div>
        </div>

        <p class="section-title">Outils utilisés:</p>
        <div class="icon-container">
            <div class="icon-wrapper">
                <img src="${pageContext.request.contextPath}/resources/img/security.png" alt="Spring Security">
                <p>Spring Security</p>
            </div>
            <div class="icon-wrapper">
                <img src="${pageContext.request.contextPath}/resources/img/spring-data.png" alt="Spring Data JPA">
                <p>Spring Data JPA</p>
            </div>
            <div class="icon-wrapper">
                <img class="custom-border-color" src="${pageContext.request.contextPath}/resources/img/Springboot.png" alt="Spring Boot">
                <p>Spring Boot</p>
            </div>
        </div>

        <p class="section-title">Technologie frontend:</p>
        <div class="icon-container">
            <div class="icon-wrapper">
                <img src="${pageContext.request.contextPath}/resources/img/jsp.png" alt="JSP">
                <p>JSP (JavaServer Pages)</p>
            </div>
        </div>

        <p class="section-title">Base de données:</p>
        <div class="icon-container">
            <div class="icon-wrapper">
                <img src="${pageContext.request.contextPath}/resources/img/OIP.jpeg" alt="MySQL">
                <p>MySQL</p>
            </div>
        </div>
        <div class='propos'>
        <h2>Description de l'application</h2>
        <div class="col-md-6 d-flex justify-content-center align-items-center position-relative">
            <div class="description-box-wrapper d-flex justify-content-center align-items-center">
                <div class="description-box" style=" text-align: center; margin-left:650px ; width:2000px">
                    <p class="description-text">Notre application vise à fournir une plateforme complète pour la gestion des examens au sein de l'École Nationale des Sciences Appliquées d'Al Hoceima (ENSAH), ainsi que pour la gestion des enseignants, des administrateurs et des éléments pédagogiques.</p>
		</div>
		</div>
		</div>
         <h2>Fonctionnalités clés</h2>
        <main>
            <ol class="gradient-list">
                <li>Faciliter la gestion des examens</li>
                <li>Optimiser la gestion des enseignants et des administrateurs</li>
                <li>Organiser efficacement les éléments pédagogiques</li>
                <li>Fournir une interface utilisateur intuitive et conviviale</li>
            </ol>
        </main>
        <h2>Architecture</h2>
        <p>L'application est structurée en suivant une architecture en trois couches</p><br>
        <p>- Couche Présentation respectant le modèle MVC</p>
        <p>- Couche Services Métiers</p>
        <p>- Couche d’accès aux données implémentant le pattern DAO</p>

        <h2>Version actuelle</h2>
        <p>Version 1.0.0</p>
        </div>
    </div>

    <jsp:include page="../fragments/userfooter.jsp" />
</body>
</html>
