package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Image icon = new Image(Main.class.getResource("Hearth.png").toString());

        primaryStage.getIcons().add(icon);

        FXMLLoader HomepageLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent HomepagePage = HomepageLoader.load();
        Scene HomepageScene = new Scene(HomepagePage, 1200, 700);

        FXMLLoader SplashLoader = new FXMLLoader(getClass().getResource("Splash.fxml"));
        Parent SplashPage = SplashLoader.load();
        Scene SplashScene = new Scene(SplashPage, 1200, 700);
        primaryStage.setTitle("RSUD Dr.Soeprapto Cepu");

        primaryStage.setScene(SplashScene);
        primaryStage.show();



        FadeTransition fadeIn = new FadeTransition(Duration.seconds(.5), SplashPage);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(.5), SplashPage);
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