/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btntranslate;

    @FXML
    private TextArea txtrisultato;

    @FXML
    private TextField txttext;


    @FXML
    void handletranslate(ActionEvent event) {
    	Boolean ok;
    	String testo=txttext.getText().toLowerCase();
    	if(testo.contains(" ")) {
    		try{
    			ok=model.add(testo);
    			txttext.clear();
    			txtrisultato.clear();
    		}
    		catch(RuntimeException re) {
    			txtrisultato.setText(re.getMessage());
    			return;
    		}
    	}
    	else {
    		try{
    			LinkedList<String> trad=model.print(testo);
    			txtrisultato.setText("" + trad);
    		}
    		catch(RuntimeException re) {
    			txtrisultato.setText(re.getMessage());
    			return;
    		}
    	}
    }

    @FXML
    void initialize() {
        assert btntranslate != null : "fx:id=\"btntranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtrisultato != null : "fx:id=\"txtrisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttext != null : "fx:id=\"txttext\" was not injected: check your FXML file 'Scene.fxml'.";
    }

	public void setModel(Model model) {
		this.model=model;
	}

}

