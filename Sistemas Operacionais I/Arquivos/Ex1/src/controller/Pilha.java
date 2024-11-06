/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.LinkedList;

/**
 *
 * @author guilh
 */
public class Pilha<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void empilhar(T elemento) {
        elementos.addFirst(elemento);
    }

    public T desempilhar() {
        return elementos.removeFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }
}
        
