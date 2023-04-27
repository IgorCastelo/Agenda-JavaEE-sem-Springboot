/**
 * Confirmação da Exclusão de um contato
 * @author Igor F. Castelo
 * @param idcon
 */
function confirmar (idcon){
	let resposta =  confirm("confirma a exclusão desse contato?")
	if(resposta===true){
		//alert(idcon);
		window.location.href = "delete?idcon="+ idcon
	} 
}