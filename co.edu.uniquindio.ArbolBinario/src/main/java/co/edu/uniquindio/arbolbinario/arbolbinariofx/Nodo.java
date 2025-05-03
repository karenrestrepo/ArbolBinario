package co.edu.uniquindio.arbolbinario.arbolbinariofx;

public class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}
