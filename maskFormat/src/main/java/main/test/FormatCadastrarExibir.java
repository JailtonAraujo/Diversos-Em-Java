package main.test;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class FormatCadastrarExibir {

	
	public String cpfToExbir(Long cpf) throws ParseException {
		String newCpf = cpf.toString();
		
		if(newCpf.length() < 11) {
			while(newCpf.length() < 11) {
				newCpf = "0"+newCpf;
			}
		}
		
		MaskFormatter formatter = new MaskFormatter();
		formatter.setMask("###.###.###-##");
		formatter.setValueContainsLiteralCharacters(false);
		
		return formatter.valueToString(newCpf);
		
	}
	
	public Long cpfToCadastrar(String cpf) {
		
		//char search[] = {'.','-'};
		
		String newCpf = cpf.replace(".", "");
		newCpf = newCpf.replace("-", "");
		
		long longCpf = Long.valueOf(newCpf);
		
		return longCpf;
	} 
}
