package com.example.hospital;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPetugasController implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;
    Boolean apakah_alert_active = false;
    Boolean apakah_alertbelumpenuh_active = false;
    @FXML
    private HBox alerta;
    @FXML
    private HBox alertbelumpenuh;



    public void closeAlerta() {
        TranslateTransition moveOut = new TranslateTransition();
        moveOut.setNode(alerta);
        moveOut.setDuration(Duration.millis(200));
        moveOut.setCycleCount(1);
        moveOut.setByY(-94);
        moveOut.play();
        apakah_alert_active = false;
    }

    public void openAlerta() {
        TranslateTransition moveIn = new TranslateTransition();
        moveIn.setNode(alerta);
        moveIn.setDuration(Duration.millis(200));
        moveIn.setCycleCount(1);
        moveIn.setByY(94);
        moveIn.play();
        apakah_alert_active = true;
//        moveIn.setOnFinished(e -> {
//            Timeline timeline = new Timeline(new KeyFrame(
//                    Duration.seconds(7),
//                    event -> closeAlerta()
//            ));
//            timeline.play();
//        });
    }

    public void closeAlertBelumPenuh() {
        TranslateTransition moveOut = new TranslateTransition();
        moveOut.setNode(alertbelumpenuh);
        moveOut.setDuration(Duration.millis(200));
        moveOut.setCycleCount(1);
        moveOut.setByY(-94);
        moveOut.play();
        apakah_alertbelumpenuh_active = false;
    }

    public void openAlertBelumPenuh() {
        TranslateTransition moveIn = new TranslateTransition();
        moveIn.setNode(alertbelumpenuh);
        moveIn.setDuration(Duration.millis(200));
        moveIn.setCycleCount(1);
        moveIn.setByY(94);
        moveIn.play();
        apakah_alertbelumpenuh_active = true;
//        moveIn.setOnFinished(e -> {
//            Timeline timeline = new Timeline(new KeyFrame(
//                    Duration.seconds(7),
//                    event -> closeAlerta()
//            ));
//            timeline.play();
//        });
    }

    public void loginAction(ActionEvent actionEvent) throws IOException {
        if (usernameField.getText().equals("") || passwordField.getText().equals("")) {
            System.out.println("Monggo diisi");
            if(apakah_alert_active){
                closeAlerta();
            }
            if (apakah_alertbelumpenuh_active) {

                TranslateTransition moveOut = new TranslateTransition();
                moveOut.setNode(alertbelumpenuh);
                moveOut.setDuration(Duration.millis(200));
                moveOut.setCycleCount(1);
                moveOut.setByY(-94);
                moveOut.play();
                apakah_alertbelumpenuh_active = false;
                moveOut.setOnFinished(e -> {
                    openAlertBelumPenuh();
                });
            } else {
                openAlertBelumPenuh();
            }

        } else if (usernameField.getText().equals("admin")&& passwordField.getText().equals("admin")) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
            Parent Page = Loader.load();
            Scene Scene = new Scene(Page, 1200, 700);

            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(Scene);
        } else{
            System.out.println("username password salah");
            if(apakah_alertbelumpenuh_active){
                closeAlertBelumPenuh();
            }
            if (apakah_alert_active) {

                TranslateTransition moveOut = new TranslateTransition();
                moveOut.setNode(alerta);
                moveOut.setDuration(Duration.millis(200));
                moveOut.setCycleCount(1);
                moveOut.setByY(-94);
                moveOut.play();
                apakah_alert_active = false;
                moveOut.setOnFinished(e -> {
                    openAlerta();
                });
            } else {
                openAlerta();
            }
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database database = Database.getInstance();
    }
}