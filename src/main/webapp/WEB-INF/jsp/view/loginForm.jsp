<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <style>
        body.login-page {
            background: url("${pageContext.request.contextPath}/resources/img/schoolpic.png") no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        .wrapper {
            width: 100%;
            max-width: 400px;
            border-radius: 8px;
            padding: 30px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.5);
            backdrop-filter: blur(8px);
            -webkit-backdrop-filter: blur(8px);
        }
        button {
            background: transparent; /* Transparent background */
            color: #fff; /* White text */
            border: 2px solid #fff; /* White border */
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 3px;
            font-size: 16px;
            transition: 0.3s ease;
        }
        button:hover {
            background: rgba(255, 255, 255, 0.15); /* Slightly visible background on hover */
            color: #fff;
        }
    </style>
</head>
<body class="login-page">
    <div class="wrapper">
        <form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
            <h2>Authentification</h2>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <c:if test="${param.error!=null}">
                <c:choose>
                    <c:when test="${param.error=='disabled'}">
                        <div class="alert alert-danger">Account Disabled</div>
                    </c:when>
                    <c:when test="${param.error=='locked'}">
                        <div class="alert alert-danger">Account Locked</div>
                    </c:when>
                    <c:when test="${param.error=='expired'}">
                        <div class="alert alert-danger">Account Expired</div>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-danger">Please verify your login or password</div>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <div class="input-field">
                <input name="username" type="text" required>
                <label>Nom d'utilisateur</label>
            </div>
            <div class="input-field">
                <input name="password" type="password"  required>
                <label>Mot de passe</label>
            </div>
            <div class="forget">
                <label for="remember">
                    <input type="checkbox" id="remember">
                    <p>Souviens de moi</p>
                </label>
                <a href="#">Mot de passe oublié?</a>
            </div>
            <button type="submit">Se Connecter</button>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
