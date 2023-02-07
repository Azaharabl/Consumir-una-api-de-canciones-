package com.example.reproductorenterointerfaces1.controlersView;

import com.example.reproductorenterointerfaces1.models.Song;
import com.example.reproductorenterointerfaces1.servicies.ApiStoreClient;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VistaReproductorController implements Initializable {

    public Button buttonCancionAnterior;
    
    public Button buttonCancionStop;
    public Button buttonCancionNext;
    public Button buttonCancionPlay;
    public FlowPane vistaReproductor;
    public Label idTituloLavel;
    public Label idNombreAlbun;
    public Label idNombreArtistas;
    public ImageView idPortadaImagen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



}
