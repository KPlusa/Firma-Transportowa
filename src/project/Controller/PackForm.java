package project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.Utils.DataUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PackForm extends DataUtil implements  Initializable {



    @FXML
    private AnchorPane APMain;
    @FXML
    public Label name;


    @FXML
    public Label clientType;




    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ClientOrder.fxml"));
        Parent root = loader.load();
         AddOrderform addOrderform= loader.getController();
        addOrderform.setName(getName(), addOrderform.name);
        addOrderform.setClientType(getClientType(), addOrderform.clientType);
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }
    @FXML
    void goMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ClientMenuForm.fxml"));
        Parent root = loader.load();
        ClientMenuForm clientMenuForm= loader.getController();
        clientMenuForm.setName(getName(), clientMenuForm.name);
        clientMenuForm.setClientType(getClientType(), clientMenuForm.clientType);
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }
 @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
