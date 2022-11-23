<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Reservation d'un hotel</title>
		<link type="text/css" rel="stylesheet" href="files.css">
		<script type="text/javascript" src="afficher_cacher_div.js"></script>
	</head>
	<body>
		<p><%@ include file="Navigation.jsp" %></p><br><br>
		<center><h1 style="color:lime">RESERVATION Salle de cérémonie</h1></center>
		
		<center>
		<h2 class="infoC">Formulaire de Reservation</h2>
		<fieldset id="fiels1">
		<form method="post" action="Ceremonie">
			<fieldset id="fiel1">
				<legend><h2 class="infoC">Information sur le client</h2></legend>
				<label for="Lnom">Nom:</label>
				<input name="nom" type="text" id="nom"><br>
				<label for="Lprenom">Prenom:</label>
				<input name="prenom" type="text" id="pren"><br>
				
				<label for="Lcon">Contact:</label>
				<input name="contact" type="number" id="cont"><br>
				
				<label for="Lage">Age:</label>
				<input name="age" type="number" id="ag"><br>
				
				<label for="Lcomp">Compte:</label>
				<input name="compte" type="text" id="compt" placeholder="ML000" required="required"><br>
				
				<label for="Lemai">Email:</label>
				<input name="email" type="text" id="ema">
			</fieldset><br>
			<fieldset id="fiel2">
				<legend><h2 class="infoRes">Information sur la reservation</h2></legend>
				<label for="Ltr">vous avez choisi:</label>
				<select name="type" id="typ" disabled="disabled">
					<option value="salle de cérémonie" selected="selected">Salle de cérémonie</option>
				</select><br>
				<label for="Ldr">Debut:</label>
			<input name="debut" type="text" id="deb" placeholder="01-janvier-2019" required="required"><br>
			<label for="Lfr">Fin:</label>
			<input name="fin" type="text" id="fi" placeholder="04-janvier-2019" required="required"><br>
			<label for="Lmode">Choisissez votre mode de reservation</label>
			<select name="mode" id="modeR">
				<option value="Reservation simple">Simple reservation(frais de reservation 100% payé)</option>
				<option value="Reservation avec avance" id="bouton_texte" onclick="javascript:afficher_cacher('texte');">Reservation avec avance(reduction de 50% du frais de reservation)</option>
				<option value="Tout payé">Tout payé(reservation sans frais de reservation)</option>
			</select><br>
			<label for="labAv" id="texte">Saisissez votre avance:<input type="number" id="texte" name="avance"></label><br>
				<script type="text/javascript">
					afficher_cacher('texte');
				</script>
			</fieldset><br>
			<input type="submit" value="Reserver" name="reservation">
		</form>
	    </fieldset>
		</center>
	</body>
</html>