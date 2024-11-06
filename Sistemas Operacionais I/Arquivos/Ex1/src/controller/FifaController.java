/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class FifaController implements IFifaController{
    
    
    @Override
    public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException{   
        Pilha<String> pilha = new Pilha<>(); 
        BufferedReader lerArq = new BufferedReader(new FileReader(caminho + "\\" + nome));
        String linha = lerArq.readLine(); // Lê a primeira linha (cabeçalho) e ignora
        int posicaoNacionalidade=0;
        
        // A variável "linha" recebe "null" quando o processo de leitura atinge o final do arquivo
        while ((linha = lerArq.readLine()) != null) { // Lê da segunda até a última linha
            String[] palavrasLinha = linha.split(",");
            if (palavrasLinha[5].equals("Brazil")) {  // Verifica a nacionalidade
                pilha.empilhar(linha); 
                System.out.println("Jogador brasileiro empilhado: " + palavrasLinha[2]); 
            }
        }
        
        lerArq.close();
        return pilha;
    }

    @Override
    public void desempilharBrasileiros(Pilha<String> pilha) throws IOException {
        while (!pilha.isEmpty()) { // Percorre a pilha enquanto não estiver vazia
            String linha = pilha.desempilhar();
            String[] palavrasDaLinha = linha.split(",");
            
            if (palavrasDaLinha.length > 7) { 
                int overall = Integer.parseInt(palavrasDaLinha[7]); // Supondo que o Overall esteja na posição 7
                
                if (overall >= 80) {  // Verifica se o Overall é >= a 80
                    System.out.println(
                        "Nome: " + palavrasDaLinha[2] +  // Supondo que o nome esteja na posição 2
                        "\nOverall: " + palavrasDaLinha[7] + "\n"
                    );
                }
            }
        }
    }

    @Override
    public Lista listaRevelacoes(String caminho, String nome) throws IOException{
        Lista listaRevelacoes = new Lista();
        
        BufferedReader br = new BufferedReader(new FileReader(caminho + "\\" + nome));
        String linha;
        br.readLine(); // Ignora a primeira linha (cabeçalho)

        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            int idade = Integer.parseInt(dados[3].trim()); // Idade

            if (idade <= 20) {
                listaRevelacoes.adicionarNoFinal(linha);
            }
        }
            br.close();
        return listaRevelacoes;
    }

    @Override
    public void buscarListaBonsJovens(Lista lista) throws IOException{
        lista.iniciarDoFinal();
        while (lista.temAnterior()) {
            String jogador = (String) lista.anterior();
            String[] dados = jogador.split(",");
            String nome = dados[2].trim(); // Nome
            int idade = Integer.parseInt(dados[3].trim()); // Idade
            int overall = Integer.parseInt(dados[7].trim()); // Overall

            if (overall > 80 && idade <= 20) {
                System.out.println("Nome: " + nome + " | Idade: " + idade + " | Overall: " + overall);
            }
        }
    }
    
    public int acharPosicaoPalavra(String[] arrayPalavras, String palavra){
        // Verifica se o array é nulo ou vazio antes de tentar encontrar a palavra
        if (arrayPalavras == null || arrayPalavras.length == 0) {
            System.err.println("Erro: O array está vazio ou nulo.");
            return -1;
        }

        // Busca pela palavra no array
        for (int x = 0; x < arrayPalavras.length; x++) {
            if (arrayPalavras[x].equals(palavra)) {
                return x;  // Retorna a posição se a palavra for encontrada
            }
        }

        // Caso a palavra não seja encontrada
        System.err.println("Erro: A palavra '" + palavra + "' não foi encontrada no array.");
        return -1;
    }
    
}
