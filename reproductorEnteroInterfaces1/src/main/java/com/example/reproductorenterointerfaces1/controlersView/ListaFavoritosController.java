package com.example.reproductorenterointerfaces1.controlersView;

import com.example.reproductorenterointerfaces1.models.Song;
import com.example.reproductorenterointerfaces1.servicies.ApiStoreClient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaFavoritosController implements  Initializable {

    public TextField busqueda;
    public Button botonlista;
    public Button botonBuscarPorArtista;
    public Button botonBuscarPorCancion;
    public Button filechooser;
    ApiStoreClient apiStoreClient = new ApiStoreClient();

    @FXML
    ListView listCancionesPrint;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}
