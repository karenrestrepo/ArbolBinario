package co.edu.uniquindio.arbolbinario.arbolbinariofx.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.arbolbinario.arbolbinariofx.ArbolBinario;
import co.edu.uniquindio.arbolbinario.arbolbinariofx.DatosArbol;
import co.edu.uniquindio.arbolbinario.arbolbinariofx.Nodo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<DatosArbol> tbDatosArbol;

    @FXML
    private TableColumn<DatosArbol, Integer> tcAltura;

    @FXML
    private TableColumn<DatosArbol, Integer> tcHojas;

    @FXML
    private TableColumn<DatosArbol, Integer> tcNivel;

    @FXML
    private TableColumn<DatosArbol, Integer> tcNodoMayor;

    @FXML
    private TableColumn<DatosArbol, Integer> tcNodoMenor;

    @FXML
    private TableColumn<DatosArbol, Integer> tcPeso;

    @FXML
    private TextField txtNodoDerecho;

    @FXML
    private TextField txtNodoIzquierdo;

    @FXML
    private TextField txtRaiz;

    @FXML
    void onAgregar(ActionEvent event) {
        try {
            String raizStr = txtRaiz.getText().trim();
            String izquierdoStr = txtNodoIzquierdo.getText().trim();
            String derechoStr = txtNodoDerecho.getText().trim();

            if (raizStr.isEmpty()) {
                atxtRecorridos.setText("Debes ingresar un valor para el nodo raíz o de referencia.");
                return;
            }

            int valorRaiz = Integer.parseInt(raizStr);

            // Si el árbol está vacío, se agrega la raíz
            if (arbol.estaVacio()) {
                arbol.agregar(valorRaiz);
                atxtRecorridos.setText("Se agregó la raíz: " + valorRaiz);
            } else {
                if (!arbol.buscar(valorRaiz)) {
                    atxtRecorridos.setText("El nodo raíz especificado no existe en el árbol.");
                    return;
                }

                // Si existe, se intentan agregar los hijos izquierdo y derecho si están presentes
                if (!izquierdoStr.isEmpty()) {
                    int valorIzquierdo = Integer.parseInt(izquierdoStr);
                    arbol.agregarIzquierdo(valorRaiz, valorIzquierdo);
                    atxtRecorridos.appendText("\nSe agregó hijo izquierdo: " + valorIzquierdo);
                }

                if (!derechoStr.isEmpty()) {
                    int valorDerecho = Integer.parseInt(derechoStr);
                    arbol.agregarDerecho(valorRaiz, valorDerecho);
                    atxtRecorridos.appendText("\nSe agregó hijo derecho: " + valorDerecho);
                }
            }

            // Limpiar campos después de agregar
            txtRaiz.clear();
            txtNodoIzquierdo.clear();
            txtNodoDerecho.clear();

        } catch (NumberFormatException e) {
            atxtRecorridos.setText("Error: Ingresa solo números enteros.");
        }
        mostrarDatosArbol();
        dibujarArbol();

    }


    @FXML
    void onEliminar(ActionEvent event) {
        arbol.borrarArbol();
        atxtRecorridos.setText("El árbol ha sido eliminado.");
        tbDatosArbol.getItems().clear();
        dibujarArbol();

    }

    @FXML
    void onInorden(ActionEvent event) {
        if (arbol.estaVacio()) {
            atxtRecorridos.setText("El árbol está vacío.");
        } else {
            String recorrido = arbol.recorrerInorden();
            atxtRecorridos.setText("Recorrido Inorden:\n" + recorrido);
        }
    }

    @FXML
    void onPreorden(ActionEvent event) {
        if (arbol.estaVacio()) {
            atxtRecorridos.setText("El árbol está vacío.");
        } else {
            String recorrido = arbol.recorridoPreorden();
            atxtRecorridos.setText("Recorrido Preorden:\n" + recorrido);
        }
    }

    @FXML
    void onPostorden(ActionEvent event) {
        if (arbol.estaVacio()) {
            atxtRecorridos.setText("El árbol está vacío.");
        } else {
            String recorrido = arbol.recorridoPostorden();
            atxtRecorridos.setText("Recorrido Postorden:\n" + recorrido);
        }
    }

    private void mostrarDatosArbol() {
        tbDatosArbol.getItems().clear();
        if (!arbol.estaVacio()) {
            int altura = arbol.obtenerAltura();
            int hojas = arbol.contarHojas();
            int nivel = arbol.obtenerAltura() - 1;
            int nodoMayor = arbol.obtenerNodoMayor();
            int nodoMenor = arbol.obtenerNodoMenor();
            int peso = arbol.obtenerPeso();

            DatosArbol datos = new DatosArbol(altura, hojas, nivel, nodoMayor, nodoMenor, peso);
            tbDatosArbol.getItems().add(datos);
        }
    }
    private void dibujarArbol() {
        pnArbol.getChildren().clear();
        Nodo raiz = arbol.getRaiz();
        if (raiz != null) {
            dibujarNodo(raiz, pnArbol.getWidth() / 2, 30, pnArbol.getWidth() / 4, null);
        }
    }

    private void dibujarNodo(Nodo nodo, double x, double y, double separacion, Nodo padre) {
        if (nodo == null) return;

        // Dibuja la línea que conecta con el padre
        if (padre != null) {
            double xPadre = x + (nodo == padre.izquierdo ? separacion : -separacion);
            double yPadre = y - 50;

            javafx.scene.shape.Line linea = new javafx.scene.shape.Line(x, y, xPadre, yPadre);
            pnArbol.getChildren().add(linea);
        }

        // Dibuja el nodo (círculo + valor)
        javafx.scene.shape.Circle circulo = new javafx.scene.shape.Circle(x, y, 20);
        circulo.setStyle("-fx-fill: lightblue; -fx-stroke: black;");
        javafx.scene.text.Text texto = new javafx.scene.text.Text(x - 7, y + 5, String.valueOf(nodo.dato));

        pnArbol.getChildren().addAll(circulo, texto);

        // Llamada recursiva para los hijos
        dibujarNodo(nodo.izquierdo, x - separacion, y + 70, separacion / 2, nodo);
        dibujarNodo(nodo.derecho, x + separacion, y + 70, separacion / 2, nodo);
    }



    @FXML
    void initialize() {
        tcAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        tcHojas.setCellValueFactory(new PropertyValueFactory<>("hojas"));
        tcNivel.setCellValueFactory(new PropertyValueFactory<>("nivelRaiz"));
        tcNodoMayor.setCellValueFactory(new PropertyValueFactory<>("nodoMayor"));
        tcNodoMenor.setCellValueFactory(new PropertyValueFactory<>("nodoMenor"));
        tcPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

    }

}

