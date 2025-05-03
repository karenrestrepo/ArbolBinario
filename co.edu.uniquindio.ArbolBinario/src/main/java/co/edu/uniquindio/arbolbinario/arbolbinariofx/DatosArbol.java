package co.edu.uniquindio.arbolbinario.arbolbinariofx;

public class DatosArbol {

    private int altura;
    private int hojas;
    private int nivelRaiz;
    private int nodoMayor;
    private int nodoMenor;
    private int peso;

    public DatosArbol(int altura, int hojas, int nivelRaiz, int nodoMayor, int nodoMenor, int peso) {
        this.altura = altura;
        this.hojas = hojas;
        this.nivelRaiz = nivelRaiz;
        this.nodoMayor = nodoMayor;
        this.nodoMenor = nodoMenor;
        this.peso = peso;
    }

    public int getAltura() { return altura; }
    public int getHojas() { return hojas; }
    public int getNivelRaiz() { return nivelRaiz; }
    public int getNodoMayor() { return nodoMayor; }
    public int getNodoMenor() { return nodoMenor; }
    public int getPeso() { return peso; }
}
