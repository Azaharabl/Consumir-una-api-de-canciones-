package com.example.reproductorenterointerfaces1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //sin internalizacionr
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
      //  Scene scene = new Scene(fxmlLoader.load(), 800, 500);


        //internacionalizacion
        Locale locale = new Locale("en", "EN");
        // Locale locale = new Locale("es", "ES");

        ResourceBundle bundle = ResourceBundle.getBundle("com.example.reproductorenterointerfaces1.strings.mensajes_"+locale);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"), bundle);
        Scene scene = new Scene(root, 800, 500);


        // aplicar a toda la escena el css
        scene.getStylesheets().add(getClass().getResource("css/css.css").toExternalForm());

        //titulo
        stage.setTitle("Retro Miusick Reproductor ");


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}