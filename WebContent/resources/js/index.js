/**
 *  Autor: Pedro Pereira Rangel Junior
 *  Data: 5/03/2021
 */

function validarCampos() {
	
	if(document.getElementById('modeloCarro').value == '') {
		
		alert("Informe o Modelo do Carro");
		document.getElementById('modeloCarro').focus();
		return false;
		
	}
	
	else if(document.getElementById('placaCarro').value == '') {
		
		alert("Informe a placa do veículo");
		document.getElementById('placaCarro').focus();
		return false;
	}
}