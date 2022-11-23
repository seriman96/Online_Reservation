<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Reservation d'un hotel</title>
		<link  rel="stylesheet" href="files.css">
		 <link rel="stylesheet" href="mon_script.js" > 
	</head>
	<body>
		<p><%@ include file="naviga.jsp" %></p><br><br><br><br><br>
		<c:choose>
		  <c:when test="${empty message }">
		  	<center><h1 style="color:lime"> CONNECTE </h1></center>
		  </c:when>
		  <c:otherwise>
		  	<center><h1 style="color:lime">NON CONNECTE</h1></center>
		  </c:otherwise>
		  </c:choose>
		
		<div class="corps">
		<div id="slider">
			<img alt="Image hotel" src= "C:/Users/SERIMAN/Desktop/Projet_Jee/image/piscine-hotel-salam.jpg" width=350px height=300px class="imgHot"/>   
		</div>
		
		<c:choose>
		  <c:when test="${empty message}">
		  	<div id="contient1">
				<ul>
				
					<li class="acue11"><a href="/HotelReservationEnLigne/Bonjourss" class="relt">Accueil</a></li>
					<li class="reserv">
							<form name="reservation">
								<select name="menuReserv" id="menuReserv">
									<option value="reserv">Ajouter</option>
									<option value="/HotelReservationEnLigne/Formulaire">Ajouter un appartement</option>
									<option value="/HotelReservationEnLigne/FormulaireS">Ajouter une salle</option>
								</select>
							</form>
						</li>
				</ul>
				<script type="text/javascript">
					var urlMenu = document.getElementById('menuReserv');
					urlMenu.onchange = function() {
						var userOption = this.options[this.selectedIndex];
						if(userOption.value != "reserv"){
							window.open(userOption.value);
						}
					}
				</script>	
					<form action="Liste" method="post">
						<input type="submit" value="Lister_client" name="lister">
					</form>	
			
			</div>
		  </c:when>
		  <c:otherwise>
		  	<center><p style="color:red"><c:out value="${message}"/></p></center>
		  </c:otherwise>
		  </c:choose>
		
		</div>
	</body>
</html>