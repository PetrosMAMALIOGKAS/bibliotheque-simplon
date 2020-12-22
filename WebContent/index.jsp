<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<div id="page-container">
	<!-- * **********************************************************************************
		 *	The file must be included this way in order to recognise the jstl taglibs in header.jsp 
	     *  jsp:include  returns the output of the included page and not the source code  
	     **********************************************************************************-->
		<%@ include file="header.jsp" %>  
		<main class="main-flex-container">
			<jsp:include page="menu.jsp" />
			<section id="content">
				<h2 class="centered">bienvenu à la bibliotheque</h2>
			</section>
		</main>
		<jsp:include page="footer.jsp" />
	</div>
	
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
</body>
</html>