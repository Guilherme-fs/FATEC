/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author guilh
 */
public interface IFifaController {
    public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
    public void desempilharBrasileiros(Pilha<String> pilha) throws IOException;
    public Lista listaRevelacoes(String caminho, String nome) throws IOException;
    public void buscarListaBonsJovens(Lista lista) throws IOException;
}
