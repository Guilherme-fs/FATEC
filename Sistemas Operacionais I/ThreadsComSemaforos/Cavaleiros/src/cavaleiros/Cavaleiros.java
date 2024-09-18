/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cavaleiros;

import java.util.concurrent.Semaphore;

/**
 *
 * @author guilh
 */
public class Cavaleiros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i =3;
        //Semaphore semaforo = Semaphore(i);
        //System.out.println("jasgdjv");
        Semaphore tocha = new Semaphore(1);
	Semaphore pedra = new Semaphore(1);
            for(int x=0; x<4; x++) {
		Thread c = new threadCavaleiro(x, tocha, pedra);
		c.start();
	}
    
    }
    
}
