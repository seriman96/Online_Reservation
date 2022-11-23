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
		<form action="Sup" method="post">
			
			
			  <table>
				 <tr>
					<td class="td17">Identifiant</td>
					<td class="td16">Nom</td>
					<td class="td15">prenom</td>
					<td class="td14">N° Compte</td>
					<td class="td10">Suppression </td>
				 </tr> 
				<c:forEach var="clt" items="${ sortieClient }" >
								 <tr> 
									<td class="td9"><input type="number" name="idc" value="${clt.idCl }"></td>
									<td class="td8"><c:out value="${clt.nomCl }"/></td>
									<td class="td7"><c:out value="${clt.prenomCl }"/></td>
									<td class="td6"><c:out value="${clt.compte }"/></td>
									<!-- <td><a href="Sup?IdCl=${clt.idCl}&action=Supprimer">supprimer</a></td> -->
									<td class="td4"><input type="submit" name="supp" value="Supprimer"></td>
								 </tr>	
				</c:forEach>
				
				
				
			 </table> 
			 <input class="met4" type="button" value="Retour" onclick="history.back();">
		</form>
	</body>
</html>