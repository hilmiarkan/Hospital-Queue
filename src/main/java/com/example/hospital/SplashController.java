package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SplashController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    private Scene HomepageScene;
    private Scene FormAntriScene;
    private Scene HomepagePetugasScene;
    private Scene LoginPetugasScene;
    private Scene FormAntriPetugasScene;
    private Scene LihatAntriPetugasScene;

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
}