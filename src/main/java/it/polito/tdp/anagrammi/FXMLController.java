package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAnagramma;

    @FXML
    private Button buttonReset;

    @FXML
    private TextField inputParola;

    @FXML
    private TextArea outputCorretti;

    @FXML
    private TextArea outputScorretti;
    
    @FXML
    private Model m = new Model();

    @FXML
    void doAnagramma(ActionEvent event) {
    	outputCorretti.clear();
    	outputScorretti.clear();
    	Map<String, Boolean> mappaAnagrammi = m.anagramma(inputParola.getText());
    	m.checkParola(mappaAnagrammi);
    	for(String s : mappaAnagrammi.keySet()) {
    		if(mappaAnagrammi.get(s)==true)
    			outputCorretti.appendText(s + "\n");
    		else
    			outputScorretti.appendText(s + "\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	inputParola.clear();
    	outputCorretti.clear();
    	outputScorretti.clear();
    }

    @FXML
    void initialize() {
        assert buttonAnagramma != null : "fx:id=\"buttonAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonReset != null : "fx:id=\"buttonReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert inputParola != null : "fx:id=\"inputParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert outputCorretti != null : "fx:id=\"outputCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert outputScorretti != null : "fx:id=\"outputScorretti\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
