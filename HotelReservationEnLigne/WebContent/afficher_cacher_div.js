function afficher_cacher(id)
{
    if(document.getElementById(id).style.visibility == "hidden")
    {
    	 document.getElementById(id).style.visibility="visible";
        document.getElementById('bouton_'+id).innerHTML='Reservation avec avance(reduction de 50% du frais de reservation)';
    }
    else
    {

        document.getElementById(id).style.visibility="hidden";//hidden
        document.getElementById('bouton_'+id).innerHTML="Reservation avec avance(reduction de 50% du frais de reservation)";
    }
    return true;
}
//Cacher le texte
//Afficher le texte