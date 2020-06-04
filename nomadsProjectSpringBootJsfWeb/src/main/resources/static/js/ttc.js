function calculTTC(){
	var ht = Number(document.getElementsByClassName("horsTaxe")[0].value);	
	console.log(ht);
	var tva = Number(document.getElementsByClassName("tauxTva")[0].value);
	var ttc = Number(ht * (1 + tva / 100));
	document.getElementsByClassName("prixTTC")[0].value = ttc;		
}