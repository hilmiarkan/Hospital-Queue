package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LihatAntriPetugasController implements Initializable {

    @FXML
    private TableView Tabel;
    @FXML
    private ComboBox filter;
    @FXML
    private TextField searchField;
    @FXML
    private TableColumn<Object, Integer> noantrianCol;
    @FXML
    private TableColumn<Object, String> namaCol;
    @FXML
    private TableColumn<Object, String> poliCol;
    @FXML
    private TableColumn<Object, String> dokterCol;
    @FXML
    private TableColumn<Object, String> tanggalCol;
    @FXML
    private TableColumn<Object, String> jenisCol;
    @FXML
    private AnchorPane popuplogout;
    @FXML
    private VBox home;

    String poli = "";

    public void openHomepagePetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    public void openLoginPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    public void openFormAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("FormAntriPetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    @FXML
    public void selectFilter(ActionEvent event) {
        if (filter.getValue().equals("Semua Poli")) {
            poli = "Semua Poli";
            loadTable();
        } else if (filter.getValue().equals("Poli Mata")) {
            poli = "Poli Mata";
            loadTable();
        } else if (filter.getValue().equals("Poli Jantung")) {
            poli = "Poli Jantung";
            loadTable();
        } else if (filter.getValue().equals("Poli Bedah")) {
            poli = "Poli Bedah";
            loadTable();
        }
    }

    private void filterTableViewData(String searchTerm) {
        loadTable();
        FilteredList<Object> filteredData = new FilteredList<>(Tabel.getItems(), p -> true);

        filteredData.setPredicate(data -> {
            if (searchTerm == null || searchTerm.isEmpty()) {
                return true;
            }
            String lowerCaseSearchTerm = searchTerm.toLowerCase();
            return data.getNama().toLowerCase().contains(lowerCaseSearchTerm);
        });

        Tabel.setItems(filteredData);
    }

    @FXML
    public void search(KeyEvent event){
        filterTableViewData(searchField.getText());
    }

    public void loadTable() {
        Database database = Database.getInstance();
        Object[] queuepolimata = database.getQueuePoliMata().toArray();
        Object[] queuepolibedah = database.getQueuePoliBedah().toArray();
        Object[] queuepolijantung = database.getQueuePoliJantung().toArray();

        ObservableList<Object> list = FXCollections.observableArrayList();

        if (poli.equals("Semua Poli") || poli.equals("")) {
            list.addAll(queuepolimata);
            list.addAll(queuepolijantung);
            list.addAll(queuepolibedah);
        } else if (poli.equals("Poli Mata")) {
            list.addAll(queuepolimata);
        } else if (poli.equals("Poli Jantung")) {
            list.addAll(queuepolijantung);
        } else if (poli.equals("Poli Bedah")) {
            list.addAll(queuepolibedah);
        }

        noantrianCol.setCellValueFactory(new PropertyValueFactory<Object, Integer>("noantrian"));
        namaCol.setCellValueFactory(new PropertyValueFactory<Object, String>("nama"));
        poliCol.setCellValueFactory(new PropertyValueFactory<Object, String>("poli"));
        dokterCol.setCellValueFactory(new PropertyValueFactory<Object, String>("dokter"));
        tanggalCol.setCellValueFactory(new PropertyValueFactory<Object, String>("tanggal"));
        jenisCol.setCellValueFactory(new PropertyValueFactory<Object, String>("jenis"));

        noantrianCol.setReorderable(false);
        namaCol.setReorderable(false);
        poliCol.setReorderable(false);
        dokterCol.setReorderable(false);
        tanggalCol.setReorderable(false);
        jenisCol.setReorderable(false);

        Tabel.setItems(list);
    }

    public void openPopUpLogOut() {
        FadeTransition fade = new FadeTransition();
        popuplogout.setVisible(true);
        fade.setNode(popuplogout);
        fade.setDuration(Duration.millis(200));
//            fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
        home.setEffect(new GaussianBlur(14));
    }

    @FXML
    void backlogout(ActionEvent event) throws IOException {

        FadeTransition fade = new FadeTransition();
        fade.setNode(popuplogout);
        fade.setDuration(Duration.millis(150));
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        home.setEffect(null);
        fade.setOnFinished(e -> {
            popuplogout.setVisible(false);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filter.getItems().addAll("Semua Poli", "Poli Mata", "Poli Jantung", "Poli Bedah");
        popuplogout.setVisible(false);
        loadTable();
    }
}