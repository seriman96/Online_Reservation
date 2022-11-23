<!Doctype html> 
<html>
	<head>
		 <title>Navi</title>
		 <meta charset="utf-8">
		 <link rel="stylesheet" href="files.css" >
		 <link rel="stylesheet" href="mon_script.js" >
	</head>
	<body>
		
		<div id="title">
			<center>
				<img alt="Logo_Hotel" src="C:/Users/SERIMAN/Desktop/Projet_Jee/image/tn_th.jpg" height=50px  class="logoHotel"/>
	        </center>
	        
		</div>
		<center><h2> Bienvenu sur Royal Hotel </h2></center>
		<div class="navconct"><a href="/HotelReservationEnLigne/Connection">Connexion</a></div>
		<div id="searchZone">
	        <div id="searchArea">
				<input type="text" placeholder="Search :"/>
				<input type="image" src="C:/Users/SERIMAN/Desktop/Projet_Jee/image/search.png" width="25px" height="30px" class="serao"/>
			</div>
			</div>
	       
	       <center> 
	       	<div id="nav">
	       		<div id="links">
	       			<ul>
						<li class="acue"><a href="/HotelReservationEnLigne/Bonjourss">Accueil</a></li>
						<li class="reserv">
							<form name="reservation">
								<select name="menuReserv" id="menuReserv">
									<option value="reserv">Reserver</option>
									<option value="/HotelReservationEnLigne/Formulaire">Reservez un appartement</option>
									<option value="/HotelReservationEnLigne/FormulaireS">Reservez une salle</option>
								</select>
							</form>
						</li>
						<li class="serv"><a href="/HotelReservationEnLigne/Addservice">Service - Supplementaire</a></li>
					
					
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
	       		</div>
	       	</div>
	       	</center>
	 	    
			
	</body>
</html>		
		