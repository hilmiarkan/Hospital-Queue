package com.example.hospital;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        // Create a FilteredList that wraps the table view's data
        FilteredList<Object> filteredData = new FilteredList<>(Tabel.getItems(), p -> true);

        // Set the filter Predicate to filter the data based on the search term
        filteredData.setPredicate(data -> {
            // If the search term is empty, show all the data
            if (searchTerm == null || searchTerm.isEmpty()) {
                return true;
            }

            // Otherwise, search for the search term in the data
            String lowerCaseSearchTerm = searchTerm.toLowerCase();
            return data.getNama().toLowerCase().contains(lowerCaseSearchTerm)
                    || data.getPoli().toLowerCase().contains(lowerCaseSearchTerm)
                    || data.getDokter().toLowerCase().contains(lowerCaseSearchTerm)
                    || data.getTanggal().toLowerCase().contains(lowerCaseSearchTerm)
                    || data.getJenis().toLowerCase().contains(lowerCaseSearchTerm);
        });

        // Set the table view's items to be the FilteredList
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filter.getItems().addAll("Semua Poli", "Poli Mata", "Poli Jantung", "Poli Bedah");

        loadTable();
//        Tabel.setOnMouseClicked(event -> {
//            // Check if the event was a double-click.
//            if (event.getClickCount() == 2) {
//                // Get the data for the clicked on row.
//                Object antrianTerpilih = (Object) Tabel.getSelectionModel().getSelectedItem();
//
//                // Do something with the data (e.g. switch to another scene and
//                // display the data in that scene).
//                System.out.println(antrianTerpilih);
//
//                FXMLLoader Loader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
//                Parent Page = null;
//                try {
//                    Page = Loader.load();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                Scene Scene = new Scene(Page, 1200, 700);
//
//                Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                primaryStage.setScene(Scene);
//            }
//        });
    }
}