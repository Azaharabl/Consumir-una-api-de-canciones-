package com.example.reproductorenterointerfaces1.controlersView;

import com.example.reproductorenterointerfaces1.models.Song;
import com.example.reproductorenterointerfaces1.servicies.ApiEstoreService;
import com.example.reproductorenterointerfaces1.servicies.ApiStoreClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import okhttp3.Call;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListaCancionesController implements Initializable {

    @FXML
    public ListView listCancionesPrint;
    @FXML
    public BorderPane listaCanciones;
    @FXML
    public Button botonlista;
    @FXML
    public TextField busqueda;
    public Button botonBuscarPorArtista;
    public Button botonBuscarPorCancion;
    public Button filechooser;

    ApiStoreClient apiStoreClient = new ApiStoreClient();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
