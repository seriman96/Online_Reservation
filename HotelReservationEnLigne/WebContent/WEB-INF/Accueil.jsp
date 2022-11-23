<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Reservation d'un hotel</title>
		<link  rel="stylesheet" href="files.css"> 
	</head>
	<body>
		<p><%@ include file="Navigation.jsp" %></p><br><br>
		<center><h1 style="color:lime"> ACCUEIL </h1></center>
		<div class="corps">
		<div id="slider">
			<img alt="Image hotel" src= "C:/Users/SERIMAN/Desktop/Projet_Jee/image/piscine-hotel-salam.jpg" width=350px height=300px class="imgHot"/>   
		</div>
		
		
		<div id="contient">
			<h2>Presentation</h2>
			<p class="desc">
				Situ� dans le quartier chic de Bamako le Royal Hotel represente le bon choix pour les clients qui veulent
				allier le charme � la tranquilit�.<br>L'hotel Royal 5 etoiles c'est l'assurance d'un grand confort et d'un service de qualit�,
				dans un cadre naturel de toute beaut�. Une atmosph�re de qui�tude r�gne dans ce coin de paradis, il vous suffira de vous laisser
				aller � la douceur de la vie Bamakoise.L'efficacit�,le charme et l'accueil chaleureux de tout le personnel qui feront de votre s�jour
				 un souvenir inoubliable.	
			</p>
		</div>
		<div class="promo">
			<h2 class="h2p">Promo</h2>
			<p class="p3">
				-Pour toute Reservation avec Avance,vous ne payerez que la moiti�e des frais de reservation<br>
				-Pour toute Reservation et paiement (Appartement ou Salle), vous ne paiyerez pas les frais<br> de reservation.
			</p>
		</div>	
			
			<div class="appart">
				<div class="infoApart">
					<h2>Nos Appartements</h2>
					<p>
						Les logements de l'hotel sont �quip�s d'un espace<br> de travaild'une t�l�vision satellite
						�cran plat,<br>d'un coffre fort �lectronique.Ils disposent<br> �galement d'une douche italienne, des toilettes <br>separ�es,
						d'un controle individuel de climatisation <br>et d'un acc�s wifi gratuit.<br>Les chambres sont de trois 3 types suivant<br>
						leurs espaces et le nombre d'occupants:<br>
					</p>
					<div id=singApDes>
						<p>
							<h2 class="titreSing">Single Appart</h2>
							Nos chambres singles, pour une personne sont compos�es<br>d'un lit simple et �quip�es d'une salle de bain.<br>
							Vous disposez d'une chambre d'un minimum de 13,5 m*m <br>contenant: un bureau, une t�l�
							un placard(dressing),<br> d'un t�l�phone.
						</p>
					</div>
					<div id=twinApDes>
						<p>
							<h2 class="titreSing">Twins Appart</h2>
							Nos chambres Twins, pour deux personnes,<br>sont compos�es de deux lits col�s<br> 
							ou separ�s selon votre souhait.<br>
							Vous disposez d'une chambre d'un minimum de 15 m*m <br> 
							et d'un ensemble de meubles pour votre confort.
						</p>
					</div>
					<div id=familApDes>
					<h2 class="titreSing">Familly Appart</h2>
						<p>
							Nos chambres Familiale, pour plusieurs personnes,<br> sont compos�es d'un grand lit <br>
							parentale et des lits pour enfants <br>
							Vous disposez d'une chambre d'un minimum de 15 m*m <br> 
							et d'un ensemble de meubles pour votre confort.
						</p>
					</div>
			</div>
			
			<div class="imgApart">
				<div id=singAp>
					<span class="span1">Single Appart<img alt="Image Sing" src= "C:/Users/SERIMAN/Desktop/Projet_Jee/image/chambre-�-coucher.jpg" width=150px height=100px class="simil"/>
					<p class="help"><span class="leftspan">50_000f/jour<a href="/HotelReservationEnLigne/Single"><br><span class="span3">Reserver</span></a></span></span></p>  
				</div>
				
				<div id=twinAp>
					<span class="span4">Twins Appart<img alt="Image Twins" src= "C:/Users/SERIMAN/Desktop/Projet_Jee/image/1200px-Hotel-room-renaissance-columbus-ohio.jpg" width=150px height=100px class="twiil"/>
					<p class="help"><span class="span5">60_000f/jour<a href="/HotelReservationEnLigne/Twins"><br><span class="span6">Reserver</span></a></span></span></p>  
				</div>
				
				<div id=familAp>
					<span class="span7">Family Appart<img alt="Image Family" src= "C:/Users/SERIMAN/Desktop/Projet_Jee/image/1020502665.jpg" width=150px height=100px class="famil"/>
					<p class="help"><span class="span8">70_000f/jour<a href="/HotelReservationEnLigne/Family"><br><span class="span9">Reserver</span></a></span></span></p>  
				</div>
			</div>
		</div>
			
		<div class="sale">
			<div class="infoSalle">
				<h2>Nos salles</h2>
				<p>
					En plus des logements, nous mettons � votre<br> disposition des solutions flexibles et innovante<br>
					pour vos �venements (d'affaires ou familliale):<br>Nous avons differents types de salles.
				</p>
				<div id="salReuDes">
					<h2 class="titreSing">Salle Reunion</h2>
					<p>
						Disposant d'une surface de 43cm*cm, ce salon met<br> � votre service l'equipement suivant:<br>
						Acc�s internet WIfi, Air conditionn�, Ecran et<br> Vid�o projeteur ainsi qu'un lecteur DVD/VHS.<br>
						Il dispose egalement d'un atout charme non<br> negligeable � savoir une verri�re ou peuvent <br>etre organis� vos pauses 
						gourmandes.
					</p>
				</div>
				<div id="salConfDes">
					<h2 class="titreSing">Salle de Conf�rence</h2>
					<p>
						Pouvant accueillir jusqu'� 100 personnes.<br> 
						Ce salon met � votre disposition les services<br> suivants:
						Acc�s internet WIfi, Air conditionn�,<br>Vid�o projeteur un lecteur DVD/VHS
						et une<br> sonorisation.Le tout dans une atmosphore tr�s <br>douce gr�ce � ses lumi�res r�glable selon vos envies.
					</p>
		   		</div>
				<div id="salCereDes">
					<h2 class="titreSing">Salle de C�r�monie</h2>
					<p>
						Pour vos �venements familliaux<br> (marage, anniverssaire, ...)<br>nous mettons � votre
						service une grande salle<br> pouvant accueillir un nombre important d'invit�s.<br>
						On vous accompagnons dans la r�alisation de votre<br>�venements avec la restauration, les decorations<br>floral
						et enfin avec le divertissement musical.
					</p>
		   		</div>
			</div>	
				
			<div class="imagSalle">
				<div id="salReuIm">
					<span class="span1d2">Salle Reunion<img alt="Img Salle reunion" src="C:/Users/SERIMAN/Desktop/Projet_Jee/image/rect700_Hotels_S_minaire_-_Hilton_la_D_fense.jpg" width=150px height=120px>
					<p class="help"><span class="span2d2">100_000f/jour<a href="/HotelReservationEnLigne/Reunion"><br><span class="span3d2">Reserver</span></a></span></span></p>
				</div>
			
				<div id="salConfIm">
					<span class="span4d2">Salle conf�rence<img alt="Img Salle Conference" src="C:/Users/SERIMAN/Desktop/Projet_Jee/image/cn1.jpg" width=150px height=120px>
					<p class="help"><span class="span5d2">100_000f/jour<a href="/HotelReservationEnLigne/Conference"><br><span class="span6d2">Reserver</span></a></span></span></p>
				</div>
			
			   <div id="salCereIm">
					<span class="span7d2">Salle c�r�monie<img alt="Img Salle C�r�monie" src="C:/Users/SERIMAN/Desktop/Projet_Jee/image/1454679169_3197_498324008.jpg" width=150px height=120px>
					<p class="help"><span class="span8d2">200_000f/jour<a href="/HotelReservationEnLigne/Ceremonie"><br><span class="span9d2">Reserver</span></a></span></span></p>
				</div>
			</div>
			
			<!---->  
		</div>
		<div class="conclu">
			<p class="pCon">
				Le Royal Hotel est l'endroit id�al pour vos sejours et autres<br> �venements.vous pouvez deguster chaque matin un petit-dejeuner 
				<br>continental.Le restaurent
				sur place sert une cuisine vari�e,<br> notamment des plats africains,francais et 
				internationnaux. 
			</p>
			<p class="decouv">Decouvrez les services supplementaires de l'hotel dans la barre de menu.</p>
		</div>
		</div>
		<p><%@ include file="footer.jsp" %></p>
	</body>
</html>