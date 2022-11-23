<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Reservation d'un hotel</title>
		<link type="text/css" rel="stylesheet" href="files.css">
		<script type="text/javascript" src="afficher_cacher_div.js"></script>
	</head>
	<body>
		<center>
		<c:choose>
		  <c:when test="${! empty erreur }">
		  <p class="erreur"><c:out value="${erreur }"/></p>
		  <input class="met4" type="button" value="Modifier" onclick="history.back();">
		  </c:when>
		  <c:otherwise>
		  	<fieldset id="fielCent">
			<fieldset id="client">
				<legend>Identité du client</legend>
				<c:forEach var="tab" items="${ donneClient }" >
				  	<div class="divclie">
						<p class="idc">Id:</p>
						<p class="idc1"><c:out value="${ tab.idCl}"/></p><br>
						<p class="idn">Nom:</p>
						<p class="idn1"><c:out value="${ tab.nomCl}"/></p><br>
						<p class="idp">Prenom:</p>
						<p class="idp1"><c:out value="${ tab.prenomCl}"/></p>
					</div>	
		    	</c:forEach>
			</fieldset><br>
			<fieldset id="reservation">
				<legend>Information de la reservation</legend>
				<c:forEach var="tab1" items="${ donneReservation }" >
				    <div class="revatInfo">
				    	<p class="dre">Date de Reservation:</p>
				    	<p class="dre1">
				    		<c:set var="now" value="<%=new java.util.Date()%>" />
				    		<strong>
					           <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${now}" />
					        </strong>	
				    	</p><br>
				    	<p class="comp">A compté du:</p>
				    	<p class="comp1"><c:out value="${ tab1.debutR}"/></p><br>
				    	<p class="typre">Type de Reservation:</p>
				    	<p class="typre1"><c:out value="${ tab1.modeR}"/></p><br>
				  		<p class="typre2">N° Reservation:</p>
				  		<p class="typre3"><c:out value="${ tab1.idRe}"/></p><br>
				  		<p class="frre">Frais de Reservation:</p>
				  		<p class="frre1"><c:out value="${ tab1.fraisR}"/> FCFA</p><br>
				  		<c:set var="A_Reserv" value="${ tab1.sommeRecu}"/>
						<c:set var="fres_R" value="${ tab1.fraisR}"/>
						<p class="avan">Avance sur payement:</p>
						<p class="avan1"><c:out value="${A_Reserv -  fres_R}"/> FCFA</p><br>
						<p class="somt">Somme Totale Recue:</p>
						<p class="somt1"><c:out value="${A_Reserv}"/> FCFA</p><br>
						<p class="somr">Somme Restant:</p>
						<p class="somr1"><c:out value="${ tab1.sommeRestant}"/> FCFA</p><br>
				    </div>
		    </c:forEach>
		    <c:forEach var="tab2" items="${ donneTarif }" >
			    <div class="tarifInfo">
			    	<p class="durs">Durée du Sejour:</p>
			    	<p class="durs1"><c:out value="${ tab2.sejour}"/>jours</p><br>
			    	<p class="prixj">Prix journalier de l'appart:</p>
			    	<p class="prixj1"><c:out value="${ tab2.prixJ}"/> FCFA</p><br>
			    	<p class="prixse">Prix correspondant au sejour:</p>
			    	<p class="prixse1"><c:out value="${ tab2.prixS}"/> FCFA</p><br>
			    </div>	
		    </c:forEach>
		    <c:forEach var="tab3" items="${ donneAppart }" >
			    <div class="apartemt">
				    <c:choose>
					  <c:when test="${! empty tab3.typeA && ! empty tab3.idAp }">
					  	<p class="typAprts">Type Appart:</p>
				    	<p class="typAprts1"><c:out value="${ tab3.typeA}"/></p>
				    	<p class="typAprts2">N°:</p>
				    	<p class="typAprts3"><c:out value="${ tab3.idAp}"/></p><br>
					  </c:when>
					  <c:otherwise>
					  	<p class="typAprts">Type Salle:</p>
					  	<p class="typAprts1"><c:out value="${ tab3.typeS}"/></p>
				    	<p class="typAprts2">N°:</p>
				    	<p class="typAprts3"><c:out value="${ tab3.idSl}"/></p><br>
					  </c:otherwise>
			  		</c:choose>	
			    </div>	
		    </c:forEach>   
			</fieldset>  
		<div class="remer">
			<p class="pass">"Passer un agréable sejour dans la residence Royal Hotel"</p>
		</div>	
		</fieldset>
		  </c:otherwise>  
		</c:choose>
		</center>
	</body>
</html>