package com.example.reproductorenterointerfaces1.controlersView;

import com.example.reproductorenterointerfaces1.models.Song;
import com.example.reproductorenterointerfaces1.reproductorFunciontsSongs.ControllerSong;
import com.example.reproductorenterointerfaces1.servicies.ApiStoreClient;
import com.example.reproductorenterointerfaces1.utiles.Config;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.util.stream.Collectors.toList;

public class HelloController implements Initializable {


        public BorderPane listaCanciones;
      
        public AnchorPane vistaAyuda;
        public BorderPane listaFavoritos;
        public Button botonHelloViewongAnterior;
        public Button botonHelloViewsongStop;
        public Button botonHelloViewsongPlay;
        public Button botonHelloViewsongNext;
        @FXML
        private VistaReproductorController vistaReproductorController;

        @FXML
        private ListaCancionesController listaCancionesController;

        @FXML
        private ListaFavoritosController listaFavoritosController;


        @FXML
        private Button botonActionCancionStop;

        @FXML
        private ToggleButton botonOpcionAyuda1;

        @FXML
        private ToggleButton botonOpcionBuscar;

        @FXML
        private ToggleButton botonOpcionFavoritos;

        @FXML
        private ToggleButton botonOpcionListaCanciones;

        @FXML
        private ToggleButton botonOpcionReproductor;

        @FXML
        private ToggleButton botonOpcionSalir;

        @FXML
        private Button botonReproductorAtrasar;

        @FXML
        private Button botonReproductorCancionAdelante;

        @FXML
        private Button botonReproductorCancionAnterior;

        @FXML
        private Button botonReproductorCancionPLay;

        @FXML
        private Button botonReproductorCancionSiguiente;

        @FXML
        private VBox paneAyuda;

        @FXML
        private VBox paneBuscar;

        @FXML
        private FlowPane paneFavoritos;


        @FXML
        private FlowPane vistaReproductor;

        private ControllerSong controllerSong;

        private static Integer actualSong = 0;

        ApiStoreClient apiStoreClient = new ApiStoreClient();

        ArrayList<Song> listaDeCancionesParaTodaLaApp = new ArrayList<>();




        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                //al iniciar la aplicacion siempre vemos el reproductor
                vistaReproductor.toFront();

                botonOpcionReproductor.setOnAction(e -> vistaReproductor.toFront());
                botonOpcionFavoritos.setOnAction(e -> listaFavoritos.toFront());
                botonOpcionAyuda1.setOnAction(e ->vistaAyuda.toFront());
                botonOpcionListaCanciones.setOnAction(e ->listaCanciones.toFront());
                botonOpcionSalir.setOnAction(e -> System.exit(0));

                controllerSong = new ControllerSong();

                //obtenemos de la api
                obtenerCancionesParaTodaLaApp();


                //botones
                listListenerHelloControler();
                vistaReproductorControllerButons();
                listaCancionesControlerButons();
                listaFavoritosControllerButons();

                //listas
                listListeners();


        }

        private void pintarSONG(Song s){
                vistaReproductorController.idNombreAlbun.setText(s.getAlbum().getTitle());
                vistaReproductorController.idNombreArtistas.setText(s.getPublisher().toString());
                vistaReproductorController.idTituloLavel.setText(s.getTitle().toString());

        }

        private void listListeners() {

                listaCancionesController.listCancionesPrint.setOnMouseClicked(e ->{
                                Object songSelect = listaCancionesController.listCancionesPrint.getFocusModel().getFocusedItem();
                                Song song = (Song)songSelect;
                                if (song!=null){
                                        controllerSong.resetSong();
                                        controllerSong.play(song);
                                        pintarSONG(song);
                                }
                });
                listaFavoritosController.listCancionesPrint.setOnMouseClicked(e ->{
                        Object songSelect = listaFavoritosController.listCancionesPrint.getFocusModel().getFocusedItem();
                        Song song = (Song)songSelect;
                        if (song!=null){
                                controllerSong.resetSong();
                                controllerSong.play(song);
                                pintarSONG(song);
                        }
                });

        }

        private void listaFavoritosControllerButons() {
                listaFavoritosController.filechooser.setOnMouseClicked(a -> {
                       // openFilechooser();
                });

                listaFavoritosController.botonlista.setOnMouseClicked(a->{
                        obtenerCancionesParaTodaLaApp();
                });
                listaFavoritosController.botonBuscarPorArtista.setOnMouseClicked(a->{
                        var artistShearch = listaFavoritosController.busqueda.getText().toString().trim();
                        List<Song> listA = listaDeCancionesParaTodaLaApp.stream()
                                        .filter(s -> s.getPublisher()!= null).toList();


                        List<Song> listArtist = listA.stream()
                                .filter(s -> s.getPublisher().contains(listaFavoritosController.busqueda.getText().toString().trim()
                                )).toList();

                        listaFavoritosController.listCancionesPrint.getItems().clear();

                        for (int i = 0; i < listArtist.size(); i++) {
                                listaFavoritosController.listCancionesPrint.getItems().add(listArtist.get(i).showInList());
                        }
                });


                listaFavoritosController.botonBuscarPorCancion.setOnMouseClicked(a->{
                        var artistShearch = listaFavoritosController.busqueda.getText().toString().trim();
                        List<Song> listArtist = listaDeCancionesParaTodaLaApp.stream()
                                .filter(s -> s.getTitle().toString().contains(artistShearch)).toList();

                        listaFavoritosController.listCancionesPrint.getItems().clear();

                        for (int i = 0; i < listArtist.size(); i++) {
                                listaFavoritosController.listCancionesPrint.getItems().add(listArtist.get(i).showInList());
                        }
                });

        }



        private void listaCancionesControlerButons() {
                listaCancionesController.filechooser.setOnMouseClicked(a -> {
                      //  openFilechooser();
                });

                listaCancionesController.botonlista.setOnMouseClicked(a->{
                        obtenerCancionesParaTodaLaApp();
                });
                listaCancionesController.botonBuscarPorArtista.setOnMouseClicked(a->{
                        var artistShearch = listaCancionesController.busqueda.getText().toString().trim();
                        List<Song> listArtist = listaDeCancionesParaTodaLaApp.stream()
                                .filter(s -> s.getPublisher().toString().contains(artistShearch)).toList();

                        listaCancionesController.listCancionesPrint.getItems().clear();

                        for (int i = 0; i < listArtist.size(); i++) {
                                listaCancionesController.listCancionesPrint.getItems().add(listArtist.get(i).showInList());
                        }
                });
                listaCancionesController.botonBuscarPorCancion.setOnMouseClicked(a->{
                        var artistShearch = listaCancionesController.busqueda.getText().toString().trim();
                        List<Song> listArtist = listaDeCancionesParaTodaLaApp.stream()
                                .filter(s -> s.getTitle().toString().contains(artistShearch)).toList();

                        listaCancionesController.listCancionesPrint.getItems().clear();

                        for (int i = 0; i < listArtist.size(); i++) {
                                listaCancionesController.listCancionesPrint.getItems().add(listArtist.get(i).showInList());
                        }
                });
        }

       /** private void openFilechooser() {
                System.out.println("entro en filechooser");
                //filechooser de canciones
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("mp3"));
                File file = fileChooser.showOpenDialog(listaCancionesController.filechooser.getScene().getWindow());
                try {
                       Song s = new Song(

                        )
                        listaDeCancionesParaTodaLaApp.add(path)
                } catch (SQLException e) {
                        e.printStackTrace();
                }



        } */

        private void initListPanes() {

                //iniciar lista de canciones
                for (int i = 0; i < listaDeCancionesParaTodaLaApp.size(); i++) {
                        listaCancionesController.listCancionesPrint.getItems().add(listaDeCancionesParaTodaLaApp.get(i));
                }


                for (int i = 0; i < listaDeCancionesParaTodaLaApp.size(); i++) {
                        listaFavoritosController.listCancionesPrint.getItems().add(listaDeCancionesParaTodaLaApp.get(i));
                }

        }

        private void obtenerCancionesParaTodaLaApp() {

                Runnable task  = () -> {

                        try {

                                List<Song> list = apiStoreClient.getDataSongs();

                                for (int i = 0; i < list.size(); i++) {
                                       listaDeCancionesParaTodaLaApp.add(list.get(i));
                                }

                                //pasar las canciones a todas las pantallas
                                if (listaDeCancionesParaTodaLaApp.size()!=0){
                                        pintarSONG(listaDeCancionesParaTodaLaApp.get(0));
                                        initListPanes();
                                }



                        } catch (Exception e) {
                                e.printStackTrace();
                        }


                };
                new Thread(task).start();


        }

        private void listListenerHelloControler() {


                //stop
                this.botonHelloViewsongStop.setOnMouseClicked(a -> {
                        // todo print
                        System.out.println("das a stop en hello view");
                       controllerSong.stop();


                });
                //play
                this.botonHelloViewsongPlay.setOnMouseClicked(a -> {
                        // todo print
                        System.out.println("das a play en el hello wiew");
                        pintarSONG((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
                        controllerSong.play((Song) listaDeCancionesParaTodaLaApp.get(actualSong));
                });


                //next
                this.botonHelloViewsongNext.setOnMouseClicked(a -> {
                        //siguiente cancion

                        controllerSong.resetSong();
                        actualSong = actualSong +1;

                        if(actualSong==listaDeCancionesParaTodaLaApp.size()){
                                actualSong = 0 ;
                        }else {
                                //cancion posible
                        }
                        pintarSONG((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
                       controllerSong.play((Song) listaDeCancionesParaTodaLaApp.get(actualSong));
                });

                //before
                this.botonHelloViewongAnterior.setOnMouseClicked(a -> {
                        //todo print
                        System.out.println("entra en cancion anterior en el hello controler");
                        //cancion anterior
                        controllerSong.resetSong();
                        actualSong--;
                        if(actualSong>=0){
                                //cancion posible
                        }else {
                                //volvemos al fin de la lista
                                actualSong = listaDeCancionesParaTodaLaApp.size()-1 ;
                        }
                        pintarSONG((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
                        controllerSong.play((Song) listaDeCancionesParaTodaLaApp.get(actualSong));
                });
        }

        private void vistaReproductorControllerButons() {

                //play
               vistaReproductorController.buttonCancionPlay.setOnMouseClicked(a -> {
                       //print
                       System.out.println("le has dado a play en vista anidada");
                       pintarSONG((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
                       controllerSong.play((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
               });

               //stop
                vistaReproductorController.buttonCancionStop.setOnMouseClicked(a -> {
                        //print
                        System.out.println("le has dado a stop en vista anidada");
                        controllerSong.stop();
                });

                //next
                vistaReproductorController.buttonCancionNext.setOnMouseClicked(a -> {
                        //siguiente cancion
                        controllerSong.resetSong();
                        actualSong++;
                        if(listaDeCancionesParaTodaLaApp.size()==actualSong){
                                actualSong = 0 ;

                        }else {
                                //cancion posible
                        }
                        pintarSONG((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
                       controllerSong.play((Song) listaDeCancionesParaTodaLaApp.get(actualSong));
                });


                //before
                vistaReproductorController.buttonCancionAnterior.setOnMouseClicked(a -> {
                        //cancion anterior
                        controllerSong.resetSong();
                        actualSong--;
                        if(actualSong>=0){
                                //cancion posible
                        }else {
                                //volvemos al fin de la lista
                                actualSong = listaDeCancionesParaTodaLaApp.size()-1 ;
                        }
                        pintarSONG((Song)listaDeCancionesParaTodaLaApp.get(actualSong));
                       controllerSong.play((Song) listaDeCancionesParaTodaLaApp.get(actualSong));
                });
        }




}
