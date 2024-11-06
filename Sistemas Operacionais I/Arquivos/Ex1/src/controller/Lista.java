
package controller;

import java.util.LinkedList;
import java.util.ListIterator;

public class Lista<T> {
    private LinkedList<T> elementos;
    private ListIterator<T> iterador;

    public Lista() {
        this.elementos = new LinkedList<>();
    }

    public void adicionar(T elemento) {
        elementos.add(elemento);
    }

    public void iniciarDoFinal() {
        iterador = elementos.listIterator(elementos.size());
    }

    public boolean temAnterior() {
        return iterador != null && iterador.hasPrevious();
    }
    // Adiciona o elemento ao final da lista
    public void adicionarNoFinal(T elemento) {
        elementos.addLast(elemento); 
    }

    public T anterior() {
        return iterador.previous();
    }
}
