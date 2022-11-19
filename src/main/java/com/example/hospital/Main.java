package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Hello.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//
//        Parent a = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
//        Parent b = FXMLLoader.load(getClass().getResource("FormAntri.fxml"));
//        Parent c = FXMLLoader.load(getClass().getResource("LoginPetugas.fxml"));

// getting loader and a pane for the HOMEPAGE scene.
// loader will then give a possibility to get related controller
        FXMLLoader HomepageLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent HomepagePage = HomepageLoader.load();
        Scene HomepageScene = new Scene(HomepagePage, 1200, 700);

// getting loader and a pane for the FORM ANTRI scene
        FXMLLoader FormAntriLoader = new FXMLLoader(getClass().getResource("FormAntri.fxml"));
        Parent FormAntriPage = FormAntriLoader.load();
        Scene FormAntriScene = new Scene(FormAntriPage, 1200, 700);

// getting loader and a pane for the LOGIN PETUGAS scene
        FXMLLoader LoginPetugasLoader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent LoginPetugasPage = LoginPetugasLoader.load();
        Scene LoginPetugasScene = new Scene(LoginPetugasPage, 1200, 700);

// getting loader and a pane for the HOMEPAGE PETUGAS scene
        FXMLLoader HomepagePetugasLoader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent HomepagePetugasPage = HomepagePetugasLoader.load();
        Scene HomepagePetugasScene = new Scene(HomepagePetugasPage, 1200, 700);

// getting loader and a pane for the FORM ANTRI PETUGAS scene
        FXMLLoader FormAntriPetugasLoader = new FXMLLoader(getClass().getResource("FormAntriPetugas.fxml"));
        Parent FormAntriPetugasPage = FormAntriPetugasLoader.load();
        Scene FormAntriPetugasScene = new Scene(FormAntriPetugasPage, 1200, 700);

// getting loader and a pane for the LIHAT ANTRI PETUGAS scene
        FXMLLoader LihatAntriPetugasLoader = new FXMLLoader(getClass().getResource("LihatAntriPetugas.fxml"));
        Parent LihatAntriPetugasPage = LihatAntriPetugasLoader.load();
        Scene LihatAntriPetugasScene = new Scene(LihatAntriPetugasPage, 1200, 700);

// getting loader and a pane for the SPLASH scene
        FXMLLoader SplashLoader = new FXMLLoader(getClass().getResource("Splash.fxml"));
        Parent SplashPage = SplashLoader.load();
        Scene SplashScene = new Scene(SplashPage, 1200, 700);

//----------------------------------------------------------------------------------------------------------------------------

// injecting scene into the controller of the HOMEPAGE scene
        HomepageController homepage = (HomepageController) HomepageLoader.getController();
        homepage.setHomepageScene(HomepageScene);
        homepage.setFormAntriScene(FormAntriScene);
        homepage.setLoginPetugasScene(LoginPetugasScene);
        homepage.setHomepagePetugasScene(HomepagePetugasScene);
        homepage.setFormAntriPetugasScene(FormAntriPetugasScene);
        homepage.setLihatAntriPetugasScene(LihatAntriPetugasScene);

// injecting scene into the controller of the FORM ANTRI scene
        FormAntriController formantri = (FormAntriController) FormAntriLoader.getController();
        formantri.setHomepageScene(HomepageScene);
        formantri.setFormAntriScene(FormAntriScene);
        formantri.setLoginPetugasScene(LoginPetugasScene);
        formantri.setHomepagePetugasScene(HomepagePetugasScene);
        formantri.setFormAntriPetugasScene(FormAntriPetugasScene);
        formantri.setLihatAntriPetugasScene(LihatAntriPetugasScene);

// injecting scene into the controller of the LOGIN PETUGAS scene
        LoginPetugasController loginpetugas = (LoginPetugasController) LoginPetugasLoader.getController();
        loginpetugas.setHomepageScene(HomepageScene);
        loginpetugas.setFormAntriScene(FormAntriScene);
        loginpetugas.setLoginPetugasScene(LoginPetugasScene);
        loginpetugas.setHomepagePetugasScene(HomepagePetugasScene);
        loginpetugas.setFormAntriPetugasScene(FormAntriPetugasScene);
        loginpetugas.setLihatAntriPetugasScene(LihatAntriPetugasScene);

        // injecting scene into the controller of the HOMEPAGE PETUGAS scene
        HomepagePetugasController homepagepetugas = (HomepagePetugasController) HomepagePetugasLoader.getController();
        homepagepetugas.setHomepageScene(HomepageScene);
        homepagepetugas.setFormAntriScene(FormAntriScene);
        homepagepetugas.setLoginPetugasScene(LoginPetugasScene);
        homepagepetugas.setHomepagePetugasScene(HomepagePetugasScene);
        homepagepetugas.setFormAntriPetugasScene(FormAntriPetugasScene);
        homepagepetugas.setLihatAntriPetugasScene(LihatAntriPetugasScene);

// injecting scene into the controller of the FORM ANTRI PETUGAS scene
        FormAntriPetugasController formantripetugas = (FormAntriPetugasController) FormAntriPetugasLoader.getController();
        formantripetugas.setHomepageScene(HomepageScene);
        formantripetugas.setFormAntriScene(FormAntriScene);
        formantripetugas.setLoginPetugasScene(LoginPetugasScene);
        formantripetugas.setHomepagePetugasScene(HomepagePetugasScene);
        formantripetugas.setFormAntriPetugasScene(FormAntriPetugasScene);
        formantripetugas.setLihatAntriPetugasScene(LihatAntriPetugasScene);

// injecting scene into the controller of the LOGIN PETUGAS scene
        LihatAntriPetugasController lihatantripetugas = (LihatAntriPetugasController) LihatAntriPetugasLoader.getController();
        lihatantripetugas.setHomepageScene(HomepageScene);
        lihatantripetugas.setFormAntriScene(FormAntriScene);
        lihatantripetugas.setLoginPetugasScene(LoginPetugasScene);
        lihatantripetugas.setHomepagePetugasScene(HomepagePetugasScene);
        lihatantripetugas.setFormAntriPetugasScene(FormAntriPetugasScene);
        lihatantripetugas.setLihatAntriPetugasScene(LihatAntriPetugasScene);

// injecting scene into the controller of the SPLASH scene
        SplashController splash = (SplashController) SplashLoader.getController();
        splash.setHomepageScene(HomepageScene);
        splash.setFormAntriScene(FormAntriScene);
        splash.setLoginPetugasScene(LoginPetugasScene);
        splash.setHomepagePetugasScene(HomepagePetugasScene);
        splash.setFormAntriPetugasScene(FormAntriPetugasScene);
        splash.setLihatAntriPetugasScene(LihatAntriPetugasScene);

        primaryStage.setTitle("RSUD Dr.Soeprapto Cepu");
        primaryStage.setScene(SplashScene);
        primaryStage.show();

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), SplashPage);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), SplashPage);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.play();

        fadeIn.setOnFinished((e) -> {
            fadeOut.play();
        });

        fadeOut.setOnFinished((e) -> {
            primaryStage.setScene(HomepageScene);
            primaryStage.show();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}