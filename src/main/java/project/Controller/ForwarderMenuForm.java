package project.Controller;

import project.Utils.DataUtil;
import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.StageStyle;
import project.Factory.Menu;
import project.Factory.MenuFactory;
import project.Observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForwarderMenuForm extends MenuFactory implements Initializable, Menu {
    @FXML
    private AnchorPane APMain;
    @FXML
    public Label name;
    @FXML
    public Label clientType;
    @FXML
    public Label information;
    Observer observer = new Observer();

    @FXML
    void prices(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ForwarderPriceListForm.fxml"));
        Parent root = loader.load();
        ForwarderPriceListForm forwarderPriceListForm = loader.getController();
        forwarderPriceListForm.setName(DataUtil.getName(), forwarderPriceListForm.name);
        forwarderPriceListForm.setClientType(DataUtil.getClientType(), forwarderPriceListForm.clientType);
        forwarderPriceListForm.information.setText(observer.getStatus());
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void branch(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ForwarderAddBranch.fxml"));
        Parent root = loader.load();
        AddbranchForm addbranchForm = loader.getController();
        addbranchForm.setName(DataUtil.getName(), addbranchForm.name);
        addbranchForm.setClientType(DataUtil.getClientType(), addbranchForm.clientType);
        addbranchForm.information.setText(observer.getStatus());
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void asign(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AssignOrderForm.fxml"));
        Parent root = loader.load();
        AssignOrder assignOrder = loader.getController();
        assignOrder.setName(DataUtil.getName(), assignOrder.name);
        assignOrder.setClientType(DataUtil.getClientType(), assignOrder.clientType);
        assignOrder.information.setText(observer.getStatus());
        observer.setStatus("");
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void payment(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PaymentForm.fxml"));
        Parent root = loader.load();
        PaymentForm paymentForm = loader.getController();
        paymentForm.setName(DataUtil.getName(), paymentForm.name);
        paymentForm.setClientType(DataUtil.getClientType(), paymentForm.clientType);
        paymentForm.information.setText(observer.getStatus());
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void goLogin(MouseEvent event) throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginForm.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene);
        window.show();
        LoginForm loginForm = loader.getController();
        LoginForm.observer.stop();
        LoginForm.allowDrag(root, window);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Observer observer = new Observer();
        information.setText(observer.getStatus());
    }

    @Override
    public Parent loadFXML(FXMLLoader loader, ForwarderMenuForm forwarderMenuForm, JFXTextField mail, String clientType) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/View/ForwarderMenu.fxml"));
        Parent root = loader.load();
        forwarderMenuForm = loader.getController();
        forwarderMenuForm.setName(mail.getText(), forwarderMenuForm.name);
        forwarderMenuForm.setClientType(clientType, forwarderMenuForm.clientType);
        return root;
    }

    @Override
    public Parent loadFXML(FXMLLoader loader, CourierMenuForm courierMenuFormMenuForm, JFXTextField mail, String clientType) throws IOException {
        return null;
    }

    @Override
    public Parent loadFXML(FXMLLoader loader, ClientMenuForm clientMenuForm, JFXTextField mail, String clientType) throws IOException {
        return null;
    }
}