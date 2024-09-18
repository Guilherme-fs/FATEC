/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cavaleiros;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class threadCavaleiro extends Thread {

    private int id;
    private static int posicaoCavaleiro;
    private boolean pegouTocha = false;
    private boolean pegouPedra = false;
    private Semaphore tocha;
    private Semaphore pedra;
    private static int aumentarVelocidade = 0;
    private static Semaphore portaEscolhida = new Semaphore(1);
    private static boolean[] portas = {false, false, false, false};



    public threadCavaleiro(int id, Semaphore tocha, Semaphore pedra) {
            this.id = id;
            this.pedra = pedra;
            this.tocha = tocha;
    }
    
    public void cavaleirosAndando(){
        Random r = new Random();

        while(posicaoCavaleiro<2000) {
            if(posicaoCavaleiro>=500 && pegouTocha == false) {
                if(tocha.tryAcquire()) {
                    aumentarVelocidade = 2;
                    pegouTocha = true;
                    System.out.println("Cavaleiro "+id+" pegou a Tocha");
                }
            }
            if(posicaoCavaleiro>=1500 && pegouPedra == false) {
                if(pedra.tryAcquire()) {
                    aumentarVelocidade = 2;
                    pegouPedra = true;
                    System.out.println("Cavaleiro "+id+" pegou a Pedra");
                }
            }
            posicaoCavaleiro += aumentarVelocidade + 2;//+ r.nextInt(2);
            System.out.println("Cavaleiro "+id+" andou "+posicaoCavaleiro);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
    @Override
    public void run() {
        
        cavaleirosAndando();
        escolherPorta();
        
    }

    private void escolherPorta() {
        
        
        
        Random r = new Random();
        try {
            portaEscolhida.acquire(); // Garantir que só um cavaleiro por vez escolhe a porta
            int portaEscolhida;
            do {
                portaEscolhida = r.nextInt(4); // Escolhe aleatoriamente uma porta de 0 a 3
            } while (portas[portaEscolhida]); // Garante que a porta não foi escolhida antes

            portas[portaEscolhida] = true; // Marca a porta como escolhida
            System.out.println("Cavaleiro " + id + " escolheu a porta " + (portaEscolhida + 1));

            if (portaEscolhida == r.nextInt(4)) {
                System.out.println("Cavaleiro " + id + " encontrou a saída e sobreviveu!");
            } else {
                System.out.println("Cavaleiro " + id + " foi devorado por monstros!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            portaEscolhida.release();
        }
    }
    
}
