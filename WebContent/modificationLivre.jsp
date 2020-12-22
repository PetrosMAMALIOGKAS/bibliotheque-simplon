<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Livre</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
<div id="page-container">
		<jsp:include page="header.jsp" />
		<main class="main-flex-container">
			<jsp:include page="menu.jsp" />
			<h3>le livre pour modifier</h3>
			<section id="content">
				<c:set var = "id_auteur_pour_modification" scope = "page" value = "${livrePourModifier.getAuteur().getId_auteur()}"/>
				<c:set var = "id_genre_pour_modification" scope = "page" value = "${livrePourModifier.getGenre().getGenre_id()}"/>
				
				<form action="ControlListerLivresModification" method="post">
					titre :
					<input type="text" name="titre" value="<c:out value="${livrePourModifier.getTitre()}" />" />
					<input type="hidden" name="id_livre" value="<c:out value="${livrePourModifier.getId()}" />" />
					<br/>
					auteur :
					<select name="auteur_id" class="select-css" >
						<c:forEach var="auteur" items="${listAuteurs}">
							<c:set var = "id_auteur_dans_boucle" scope = "page" value = "${auteur.getId_auteur()}"/>
							<option value="<c:out value="${auteur.getId_auteur()}" />" 
							   <c:if test="${id_auteur_dans_boucle.equals(id_auteur_pour_modification)}">
							   		selected=selected
							   </c:if>
							>     <!--  end option -->
							   		
								   <c:out value="${auteur.getNom()}" /> <c:out value="${auteur.getPrenom()}" /> 
							</option>
						</c:forEach>
					</select>
					<br/>
					theme:
					<select name="genre_id" class="select-css" >
						<c:forEach var="genre" items="${listGenres}">
							<c:set var = "id_genre_dans_boucle" scope = "page" value = "${genre.getGenre_id()}"/>
							<option value="<c:out value="${genre.getGenre_id()}" />" 
							   <c:if test="${id_genre_dans_boucle.equals(id_genre_pour_modification)}">
							   		selected=selected
							   </c:if>
							>  <!--  end option -->
							   		
								   <c:out value="${genre.getNom()}" />
							</option>
						</c:forEach>
					</select>
					<br/>
					<input type="submit" value="modification" />
				</form>
			</section>
		</main>
		<jsp:include page="footer.jsp" />
	</div>
	
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
</body>
</html>