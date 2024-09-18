/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provatriatlo;

/**
 *
 * @author guilh
 */
public class ProvaTriatlo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Criar uma coleção para armazenar os atletas
        Prova[] atletas = new Prova[25];  
        for(int id=0; id<25; id++){
            atletas[id] = new Prova(id);
            atletas[id].start();
        }
        
        // Esperar que todos os atletas terminem
        for (Prova atleta : atletas) {
            atleta.join();
        }

        // Exibir o resultado final
        Prova.exibirResultadoFinal();
    }
    
}
