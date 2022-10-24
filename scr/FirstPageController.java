/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soduko;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class FirstPageController implements Initializable {

    @FXML
    private TextField G1L1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void onAction(ActionEvent event) {
        System.out.println("WatsUP");
    }

    @FXML
    private void checkAction(ActionEvent event) {
        System.out.print(G1L1.getText());
    }
    
}
