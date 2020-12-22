<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp" />
		<main class="main-flex-container">
			<jsp:include page="menu.jsp" />
			<section id="content">
				<h3>les information de livre à ajouter</h3>
				<form action="ControlAjouterLivre" method="Post">
					<label for="auteur-select">Auteur</label><br/>
					<select name="auteur_id" id="auteur-select" class="select-css">
						<option value="">--Please choose an option--</option>
						<c:forEach var="auteur" items="${listAuteurs}">
						<option value="<c:out value="${auteur.getId_auteur()}" />">
							<c:out value="${auteur.getNom()}" /> <c:out value="${auteur.getPrenom()}" />
						</option>
						</c:forEach>
					</select>
					<br/>
					<br/>
					<label for="genre-select">Genre</label><br/>
					<select name="genre_id" id="genre-select" class="select-css">
						<option value="">--Please choose an option--</option>
						<c:forEach var="genre" items="${listGenres}">
						<option value="<c:out value="${genre.getGenre_id()}" />">
							<c:out value="${genre.getNom()}" /> 
						</option>
						</c:forEach>
					</select>
					<br/>
					<br/>
					<label for="titre-id">Titre de livre</label><br/>
					<input type="text" name="titre" id="titre-id" />
					<br/>
					<br/>
					<input type="submit" value="ajouter" />
				</form>
			</section>
		</main>
		<jsp:include page="footer.jsp" />
	</div>
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
</body>
</html>