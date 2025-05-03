package co.edu.uniquindio.arbolbinario.arbolbinariofx;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {
    private Nodo raiz;

    public boolean estaVacio() {
        return raiz == null;
    }

    public void agregar(int dato) {
        raiz = agregarRecursivo(raiz, dato);
    }

    private Nodo agregarRecursivo(Nodo actual, int dato) {
        if (actual == null){
            return new Nodo(dato);
        }
        if (dato < actual.dato){
            actual.izquierdo = agregarRecursivo(actual.izquierdo, dato);
        }
        else if (dato > actual.dato){
            actual.derecho = agregarRecursivo(actual.derecho, dato);
        }
        return actual;
    }

    public boolean existe(int valor) {
        return existeRecursivo(raiz, valor);
    }

    private boolean existeRecursivo(Nodo actual, int valor) {
        if (actual == null){
            return false;
        }
        if (valor == actual.dato){
            return true;
        }
        return valor < actual.dato
                ? existeRecursivo(actual.izquierdo, valor)
                : existeRecursivo(actual.derecho, valor);
    }
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor) != null;
    }

    private Nodo buscarRec(Nodo actual, int valor) {
        if (actual == null) return null;
        if (actual.dato == valor) return actual;

        Nodo encontrado = buscarRec(actual.izquierdo, valor);
        if (encontrado == null) {
            encontrado = buscarRec(actual.derecho, valor);
        }
        return encontrado;
    }


    public void agregarIzquierdo(int padre, int hijo) {
        Nodo nodoPadre = buscarRec(raiz, padre);
        if (nodoPadre != null) {
            if (nodoPadre.izquierdo == null) {
                nodoPadre.izquierdo = new Nodo(hijo);
            } else {
                System.out.println("El hijo izquierdo ya existe.");
            }
        }
    }

    public void agregarDerecho(int padre, int hijo) {
        Nodo nodoPadre = buscarRec(raiz, padre);
        if (nodoPadre != null) {
            if (nodoPadre.derecho == null) {
                nodoPadre.derecho = new Nodo(hijo);
            } else {
                System.out.println("El hijo derecho ya existe.");
            }
        }
    }


    public int obtenerPeso() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo nodo) {
        if (nodo == null){
            return 0;
        }
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }

    public int obtenerAltura() {
        return altura(raiz);
    }

    private int altura(Nodo nodo) {
        if (nodo == null){
            return -1;
        }
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int obtenerNivel(int dato) {
        return nivel(raiz, dato, 0);
    }

    private int nivel(Nodo nodo, int dato, int nivel) {
        if (nodo == null){
            return -1;
        }
        if (nodo.dato == dato){
            return nivel;
        }
        int next = dato < nodo.dato ? nivel(nodo.izquierdo, dato, nivel + 1)
                : nivel(nodo.derecho, dato, nivel + 1);
        return next;
    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(Nodo nodo) {
        if (nodo == null){
            return 0;
        }
        if (nodo.izquierdo == null && nodo.derecho == null){
            return 1;
        }
        return contarHojasRec(nodo.izquierdo) + contarHojasRec(nodo.derecho);
    }

    public int obtenerNodoMenor() {
        return menor(raiz).dato;
    }

    private Nodo menor(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public int obtenerNodoMayor() {
        return mayor(raiz).dato;
    }

    private Nodo mayor(Nodo nodo) {
        while (nodo.derecho != null){
            nodo = nodo.derecho;}
        return nodo;
    }


    public void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo eliminarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return null;
        }
        if (dato < nodo.dato) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = eliminarRec(nodo.derecho, dato);
        } else {
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;
            Nodo menor = menor(nodo.derecho);
            nodo.dato = menor.dato;
            nodo.derecho = eliminarRec(nodo.derecho, menor.dato);
        }
        return nodo;
    }

    public void borrarArbol() {
        raiz = null;
    }
    private Nodo buscarNodo(Nodo actual, int valor) {
        if (actual == null) return null;
        if (actual.dato == valor) return actual;
        Nodo encontrado = buscarNodo(actual.izquierdo, valor);
        return (encontrado != null) ? encontrado : buscarNodo(actual.derecho, valor);
    }
    public String recorrerInorden() {
        StringBuilder sb = new StringBuilder();
        inorden(raiz, sb);
        return sb.toString();
    }

    private void inorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            inorden(nodo.izquierdo, sb);
            sb.append(nodo.dato).append(" ");
            inorden(nodo.derecho, sb);
        }
    }


    private String inorden(Nodo nodo) {
        if (nodo == null) {
            return "";
        }
        return inorden(nodo.izquierdo) + nodo.dato + " " + inorden(nodo.derecho);
    }

    public String recorridoPreorden() {
        StringBuilder sb = new StringBuilder();
        preorden(raiz, sb);
        return sb.toString().trim();
    }

    private void preorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.dato).append(" ");
            preorden(nodo.izquierdo, sb);
            preorden(nodo.derecho, sb);
        }
    }

    public String recorridoPostorden() {
        StringBuilder sb = new StringBuilder();
        postorden(raiz, sb);
        return sb.toString().trim();
    }

    private void postorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            postorden(nodo.izquierdo, sb);
            postorden(nodo.derecho, sb);
            sb.append(nodo.dato).append(" ");
        }
    }

    public String imprimirAmplitud() {
        if (raiz == null){
            return "";
        }
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        StringBuilder sb = new StringBuilder();
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            sb.append(actual.dato).append(" ");
            if (actual.izquierdo != null) cola.add(actual.izquierdo);
            if (actual.derecho != null) cola.add(actual.derecho);
        }
        return sb.toString().trim();
    }

    public Nodo getRaiz() {
        return raiz;
    }}

