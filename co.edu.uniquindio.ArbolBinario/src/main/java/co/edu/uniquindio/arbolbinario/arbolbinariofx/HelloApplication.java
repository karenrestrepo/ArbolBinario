package co.edu.uniquindio.arbolbinario.arbolbinariofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ArbolBinario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 755, 480);
        stage.setTitle("Arbol");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}