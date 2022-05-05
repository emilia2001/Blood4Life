package controller;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainPageController implements Initializable {
    public BorderPane mainPageBorderPane;
    public Button addPatientButton;
    public Button showPatientsButton;
    public Button showUsersButton;
    public Button showDonationCentresButton;
    public Button showAppointmentsButton;
    public Button addDonationCentreButton;

    private Service service;
    private Stage stage;

    public void setService(Service service) {
        this.service = service;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void onAddPatientButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../addPatient-view.fxml"));
        Pane view = fxmlLoader.load();
        AddPatientController addPatientController = fxmlLoader.getController();
        addPatientController.setService(service);
        mainPageBorderPane.setCenter(view);
    }

    public void onShowPatientsButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../showPatients-view.fxml"));
        Pane view = fxmlLoader.load();
        ShowPatientsController showPatientsController = fxmlLoader.getController();
        showPatientsController.setService(service);
        mainPageBorderPane.setCenter(view);
    }

    public void onShowUsersButtonClick(ActionEvent actionEvent) {
    }

    public void onShowDonationCentresButtonnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../showDonationCentres-view.fxml"));
        Pane view = fxmlLoader.load();
        ShowDonationCentresController showDonationCentresController = fxmlLoader.getController();
        showDonationCentresController.setService(service);
        mainPageBorderPane.setCenter(view);
    }

    public void onShowAppointmentsButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../showAppointments-view.fxml"));
        Pane view = fxmlLoader.load();
        ShowAppointmentsController showAppointmentsController = fxmlLoader.getController();
        showAppointmentsController.setService(service);
        mainPageBorderPane.setCenter(view);
    }

    public void onAddDonationCentreButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../addDonationCentre-view.fxml"));
        Pane view = fxmlLoader.load();
        AddDonationCentreController addDonationCentreController = fxmlLoader.getController();
        addDonationCentreController.setService(service);
        mainPageBorderPane.setCenter(view);
    }
}
