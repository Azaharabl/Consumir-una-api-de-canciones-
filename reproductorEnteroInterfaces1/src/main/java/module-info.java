module com.example.reproductorenterointerfaces1 {
    requires javafx.controls;
    requires javafx.fxml;

    //Paso 2 cosas a añadidas -------------------------------------------------


    //meter para que fucncione llamada a api
    requires java.net.http;

    //metemos la de json
    requires  org.json;

    //algunos mas para usar retrofit hay que añadir a maven en el pomp
    requires okhttp3;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires gson;
    requires java.sql;
    requires javafx.media;


    opens com.example.reproductorenterointerfaces1 to javafx.fxml, gson;
    exports com.example.reproductorenterointerfaces1;
    exports com.example.reproductorenterointerfaces1.controlersView;
    exports com.example.reproductorenterointerfaces1.models to  gson;
    opens com.example.reproductorenterointerfaces1.controlersView to gson, javafx.fxml;
    opens com.example.reproductorenterointerfaces1.models to gson, javafx.fxml;
    exports com.example.reproductorenterointerfaces1.reproductorFunciontsSongs;
    opens com.example.reproductorenterointerfaces1.reproductorFunciontsSongs to gson, javafx.fxml;
    exports com.example.reproductorenterointerfaces1.utiles;
    opens com.example.reproductorenterointerfaces1.utiles to gson, javafx.fxml;


}