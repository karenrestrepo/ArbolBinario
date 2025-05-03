module co.edu.uniquindio.arbolbinario.arbolbinariofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.arbolbinario.arbolbinariofx to javafx.fxml;
    exports co.edu.uniquindio.arbolbinario.arbolbinariofx;
}