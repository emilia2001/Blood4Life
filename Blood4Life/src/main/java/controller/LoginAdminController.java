package controller;

import exception.ServerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;

public class LoginAdminController {
    public TextField usernameTextField;
    public PasswordField passwordTextField;
    public Label errorLabel;

    private Service service;
    private Stage stage;

    public void setService(Service service) {
        this.service = service;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void onAdminLoginButtonClick(ActionEvent actionEvent) {
        try {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            service.loginAdmin(username, password);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("loginAdmin-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 660, 500);
            LoginAdminController loginAdminController = fxmlLoader.getController();
            loginAdminController.setService(service);
            loginAdminController.setStage(stage);
            stage.setTitle("Blood4Life");
            stage.setScene(scene);
            stage.show();
        } catch (IOException | ServerException exception) {
            errorLabel.setText(exception.getMessage());
        }
    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("loginUser-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 500);
        LoginUserController loginUserController = fxmlLoader.getController();
        loginUserController.setService(service);
        loginUserController.setStage(stage);
        stage.setTitle("Blood4Life");
        stage.setScene(scene);
        stage.show();
    }
}
