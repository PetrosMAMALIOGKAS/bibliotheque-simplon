
<header>
	<div class="flex-container">
       <img src="./assets/logo-b.png" alt="logo de bibiotheque fictif" id="header-image-logo" />
       <h2 id="header-titre">Biblioteque fictif</h2>
       <div id="header-error-message">
      	 <ul class="messages-list">
			<c:forEach var="message" items="${messages}">
				<li><c:out value="${message}"></c:out></li>
			</c:forEach>
		</ul>
       </div>
    </div>
</header>