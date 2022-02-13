package main.test;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;

import javax.swing.text.MaskFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FXMLController implements Initializable {
    
	private FormatCadastrarExibir cadastrarExibir = new FormatCadastrarExibir();
	
	@FXML
    private TextField textField;

    @FXML
    void Event(KeyEvent event) {
    	TextFieldFormatter mask = new TextFieldFormatter();
    	mask.setMask("###.###.###-##");
    	mask.setCaracteresValidos("0123456789");
    	mask.setTf(textField);
    	mask.formatter();
    	
    }
    
    @FXML
    void clicar(ActionEvent event) throws ParseException {
    	String text = this.textField.getText();
    	
    	long cpfCadastrar = cadastrarExibir.cpfToCadastrar(text);
    	
    	System.out.println("Para Cadastrar: " + cpfCadastrar);
    	
    	String cpfExibir = cadastrarExibir.cpfToExbir(cpfCadastrar);
    	
    	System.out.println("Para Exibir: "+ cpfExibir);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
