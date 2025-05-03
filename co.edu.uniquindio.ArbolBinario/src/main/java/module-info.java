module co.edu.uniquindio.arbolbinario.arbolbinariofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.arbolbinario.arbolbinariofx to javafx.fxml;
    opens co.edu.uniquindio.arbolbinario.arbolbinariofx.Controller;
    exports co.edu.uniquindio.arbolbinario.arbolbinariofx;
    exports co.edu.uniquindio.arbolbinario.arbolbinariofx.Controller;
}