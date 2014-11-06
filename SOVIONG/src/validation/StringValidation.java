package validation;

import javax.swing.JOptionPane;

public class StringValidation {

	public static boolean validacaoTextoVazio(String texto){
		if(texto.isEmpty()){
			JOptionPane.showMessageDialog(null, "Valores inválidos");
			return false;
		}else
			return true;
	}
	
	public static boolean validacaoCampoNumericoIntegerNaoMoeda(String texto){
		
		try{
			Integer.parseInt(texto);
			return true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Valores inválidos");
			return false;
		}
	}
}

