/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provatriatlo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class Prova extends Thread {
    private int id;
    private int distanciaPercorridaCorrida;
    private int distanciaPercorridaCiclismo;
    private static Semaphore armas[] = new Semaphore[5];
    private int pontuacaoTiros = 0;
    private int pontuacaoCorrida = 0;
    private int pontuacaoCiclismo = 0;
    private static int pontosCorrida = 260;
    private static int pontosCiclismo = 260;
    private static int colocacao=0;
    private static Semaphore pontos = new Semaphore(1);
    private static int pontuacao[][] = new int [2][25];
    
    static {
        for (int i = 0; i < armas.length; i++) {
            armas[i] = new Semaphore(1);
        }
    }
    
    public Prova(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            corrida();
            tiroAlvo();
        } catch (InterruptedException ex) {
            Logger.getLogger(Prova.class.getName()).log(Level.SEVERE, null, ex);
        }
        ciclismo();
        pontuacao();
    }
    
    public void corrida() throws InterruptedException{
        while(distanciaPercorridaCorrida < 3000){
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Prova.class.getName()).log(Level.SEVERE, null, ex);
            }
            distanciaPercorridaCorrida += ((Math.random()*5)+20);
        }
        try {
            pontos.acquire();
            pontosCorrida-=10;
            pontuacaoCorrida = pontosCorrida;
            System.out.println("o Competidor "+id+" conseguiu "+pontuacaoCorrida+" pontos na prova de corrida");
        } catch (Exception e) {
            System.err.println("Thread interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            pontos.release();
        }
        
    }
    
    public void tiroAlvo() throws InterruptedException{
        // Adquirir qualquer arma disponível
        Semaphore armaEscolhida = null;

        try {
            // Tentar adquirir uma das cinco armas disponíveis 
            for (Semaphore arma : armas) {
                if (arma.tryAcquire()) { 
                    armaEscolhida = arma;
                    break; // Sai do loop ao pegar a primeira arma disponível
                }
            }

            if (armaEscolhida == null) {
                // Se nenhuma arma foi encontrada com tryAcquire(), esperar por uma arma
                armaEscolhida = armas[(int) (Math.random() * armas.length)];
                armaEscolhida.acquire(); // Bloqueia até que a arma seja liberada
            }

            // O atleta faz 3 tiros
            for (int y = 0; y < 3; y++) {
                int tempoTiro = (int) ((Math.random() * (3000 - 500)) + 500); 
                Thread.sleep(tempoTiro);
                int pontuacaoTiro = (int) (Math.random() * 11); 
                pontuacaoTiros += pontuacaoTiro;
            }
        } catch (Exception e) {
            System.err.println("Thread interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            if (armaEscolhida != null) {
                armaEscolhida.release(); 
            }
        }

        System.out.println("O atleta " + id + " conseguiu " + pontuacaoTiros + " pontos nos tiros.");
    }
    
    public void ciclismo(){
        while(distanciaPercorridaCiclismo < 5000){
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(Prova.class.getName()).log(Level.SEVERE, null, ex);
            }
            distanciaPercorridaCiclismo += ((Math.random()*11)+30);
        }
        synchronized (Prova.class) {
            pontosCiclismo-=10;
            pontuacaoCiclismo = pontosCiclismo;
            System.out.println("o Competidor "+id+" chegou conseguiu "+pontuacaoCiclismo+" pontos na prova de ciclismo");
        }
    }

    public void pontuacao() {
        int potuacaoTotal = pontuacaoCiclismo+pontuacaoCorrida+pontuacaoTiros;
        synchronized(Prova.class){
            pontuacao[0][id] = id;
            pontuacao[1][id] = potuacaoTotal;
        }
        
    }
    
    public static void exibirResultadoFinal() {
        // Implementação do Bubble Sort para ordenar as pontuações
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24 - i; j++) {
                if (pontuacao[1][j] < pontuacao[1][j + 1]) {
                    // Trocar as pontuações
                    int auxPontuacao = pontuacao[1][j];
                    pontuacao[1][j] = pontuacao[1][j + 1];
                    pontuacao[1][j + 1] = auxPontuacao;

                    // Trocar os IDs correspondentes
                    int auxId = pontuacao[0][j];
                    pontuacao[0][j] = pontuacao[0][j + 1];
                    pontuacao[0][j + 1] = auxId;
                }
            }
        }

        // Exibir o resultado final após a ordenação
        System.out.println("\n--- Resultado Final ---");
        for (int x = 0; x < 25; x++) { // Iterar sobre todos os competidores
            System.out.println((x + 1) + "º lugar: Competidor " + pontuacao[0][x]
                    + " com " + pontuacao[1][x] + " pontos.");
        }
    }
}
