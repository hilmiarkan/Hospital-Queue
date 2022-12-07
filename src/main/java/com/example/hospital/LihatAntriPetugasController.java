package com.example.hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LihatAntriPetugasController implements Initializable {

    @FXML
    private TableView Tabel;
    @FXML
    private TableColumn<ObjectPoliMata, Integer> noantrianCol;
    @FXML
    private TableColumn<ObjectPoliMata, String> namaCol;
    @FXML
    private TableColumn<ObjectPoliMata, String> poliCol;
    @FXML
    private TableColumn<ObjectPoliMata, String> dokterCol;
    @FXML
    private TableColumn<ObjectPoliMata, String> tanggalCol;
    @FXML
    private TableColumn<ObjectPoliMata, String> jenisCol;


    public void openHomepageScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openFormAntriScene(ActionEvent actionEvent) throws IOException {

        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("FormAntri.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openHomepagePetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openLoginPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openFormAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("FormAntriPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openLihatAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("LihatAntriPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openInvoiceScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database database = Database.getInstance();
        QueuePoliMata queue = database.getQueuePoliMata();
        ObjectPoliMata[] array = queue.toArray();

        ObservableList<ObjectPoliMata> list = FXCollections.observableArrayList(array);

        noantrianCol.setCellValueFactory(new PropertyValueFactory<ObjectPoliMata, Integer>("noantrian"));
        namaCol.setCellValueFactory(new PropertyValueFactory<ObjectPoliMata, String>("nama"));
        poliCol.setCellValueFactory(new PropertyValueFactory<ObjectPoliMata, String>("poli"));
        dokterCol.setCellValueFactory(new PropertyValueFactory<ObjectPoliMata, String>("dokter"));
        tanggalCol.setCellValueFactory(new PropertyValueFactory<ObjectPoliMata, String>("tanggal"));
        jenisCol.setCellValueFactory(new PropertyValueFactory<ObjectPoliMata, String>("jenis"));

        noantrianCol.setReorderable(false);
        namaCol.setReorderable(false);
        poliCol.setReorderable(false);
        dokterCol.setReorderable(false);
        tanggalCol.setReorderable(false);
        jenisCol.setReorderable(false);

        Tabel.setItems(list);

        Tabel.setOnMouseClicked(event -> {
            // Check if the event was a double-click.
            if (event.getClickCount() == 2) {
                // Get the data for the clicked on row.
                ObjectPoliMata antrianTerpilih = (ObjectPoliMata) Tabel.getSelectionModel().getSelectedItem();

                // Do something with the data (e.g. switch to another scene and
                // display the data in that scene).
                System.out.println(antrianTerpilih);

                FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                Parent InvoicePage = null;
                try {
                    InvoicePage = InvoiceLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

                Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                primaryStage.setScene(InvoiceScene);
            }
        });
    }
}