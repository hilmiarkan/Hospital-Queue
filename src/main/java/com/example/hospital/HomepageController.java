package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageController {

//    @FXML
//    private VBox root;

    private Scene HomepageScene;
    private Scene FormAntriScene;
    private Scene HomepagePetugasScene;
    private Scene LoginPetugasScene;
    private Scene FormAntriPetugasScene;
    private Scene LihatAntriPetugasScene;

//    public static boolean isSplashLoaded = false;

    public void setHomepageScene(Scene scene) {
        HomepageScene = scene;
    }
    public void setFormAntriScene(Scene scene) {
        FormAntriScene = scene;
    }

    public void setHomepagePetugasScene(Scene scene) {
        HomepagePetugasScene = scene;
    }

    public void setLoginPetugasScene(Scene scene) {
        LoginPetugasScene = scene;
    }

    public void setFormAntriPetugasScene(Scene scene) {
        FormAntriPetugasScene = scene;
    }

    public void setLihatAntriPetugasScene(Scene scene) {
        LihatAntriPetugasScene = scene;
    }


    public void openHomepageScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(HomepageScene);
    }

    public void openFormAntriScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(FormAntriScene);
    }

    public void openHomepagePetugasScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(HomepagePetugasScene);
    }

    public void openLoginPetugasScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(LoginPetugasScene);
    }

    public void openFormAntriPetugasScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(FormAntriPetugasScene);
    }

    public void openLihatAntriPetugasScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(LihatAntriPetugasScene);
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        if(!isSplashLoaded) {
//            try {
//                loadSplashScreen();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }

//    private void loadSplashScreen() throws IOException {
//
//        isSplashLoaded = true;
//
//        VBox pane = FXMLLoader.load(getClass().getResource("Splash.fxml"));
//        root.getChildren().setAll(pane);
//
//        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
//        fadeIn.setFromValue(0);
//        fadeIn.setToValue(1);
//        fadeIn.setCycleCount(1);
//
//        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
//        fadeOut.setFromValue(1);
//        fadeOut.setToValue(0);
//        fadeOut.setCycleCount(1);
//
//        fadeIn.play();
//
//        fadeIn.setOnFinished((e) -> {
//            fadeOut.play();
//        });
//
//        fadeOut.setOnFinished((e) -> {
//            try {
//                VBox ye = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
//                root.getChildren().setAll(ye);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });
//    }


}