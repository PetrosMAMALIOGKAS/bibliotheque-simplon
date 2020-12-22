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
				<h1>Les Livres disponibles</h1>
				<label for="select-genre">Filter les livres par theme</label>
				<select name="genre" id="select-genre">
					<c:forEach var="genres" items="${listGenres}">
						<option value="<c:out value="${genres.getGenre_id()}" />"><c:out value="${genres.getNom()}" /></option>
					</c:forEach>
				</select>
				<form method="post" action="ControlLivre">
					<div id="list-livres">
						<table>
						    <tbody>
							<c:forEach var="livres" items="${listLivres}">
								<%! int counter = 1; %> 
								<tr>
						            <td><input type="radio" name="livre_id" id="livre-<%= counter %>" value="<c:out value="${livres.getId()}" />" /></td>
						            <td><label for="livre-<%= counter %>"><c:out value="${livres.getTitre()}" /></label></td>
						        </tr>
								<% counter++; %>   
							</c:forEach>
						    </tbody>
						</table>
					</div>
					<input type=submit name="choise" value="Supprimer" />
					<input type=submit name="choise" value="modifier" />
				</form>
			</section>
		</main>
		<jsp:include page="footer.jsp" />
	</div>
	
	
		
	

	
	
	
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
</body>
</html>