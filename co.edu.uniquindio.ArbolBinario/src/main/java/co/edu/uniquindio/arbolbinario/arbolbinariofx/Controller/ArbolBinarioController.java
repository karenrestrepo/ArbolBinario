package co.edu.uniquindio.arbolbinario.arbolbinariofx.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.arbolbinario.arbolbinariofx.ArbolBinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ArbolBinarioController {
    private ArbolBinario arbol = new ArbolBinario();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea atxtRecorridos;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnInorden;

    @FXML
    private Button btnPostorden;

    @FXML
    private Button btnPreorden;

    @FXML
    private Pane pnArbol;

    @FXML
    private TableView<?> tbDatosArbol;

    @FXML
    private TableColumn<?, ?> tcAltura;

    @FXML
    private TableColumn<?, ?> tcHojas;

    @FXML
    private TableColumn<?, ?> tcNivel;

    @FXML
    private TableColumn<?, ?> tcNodoMayor;

    @FXML
    private TableColumn<?, ?> tcNodoMenor;

    @FXML
    private TableColumn<?, ?> tcPeso;

    @FXML
    private TextField txtNodoDerecho;

    @FXML
    private TextField txtNodoIzquierdo;

    @FXML
    private TextField txtRaiz;

    @FXML
    void onAgregar(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onInorden(ActionEvent event) {

    }

    @FXML
    void onPostorden(ActionEvent event) {

    }

    @FXML
    void onPreorden(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}

