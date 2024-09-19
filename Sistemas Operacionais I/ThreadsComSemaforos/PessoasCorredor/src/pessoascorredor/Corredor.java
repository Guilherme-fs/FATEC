/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pessoascorredor;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class Corredor extends Thread {

    private int distanciaPercorrida;
    private int tanhoCorredor = 200;
    Semaphore porta = new Semaphore(1);
    
    public Corredor() {
        
    }
    
    @Override
    public void run(){
        while(distanciaPercorrida < tanhoCorredor){
            try {
                Thread.sleep(1000);
                distanciaPercorrida += (int)((Math.random()*6-4)+4);
                System.out.println("A pessoa "+ threadId()+" andou "+distanciaPercorrida);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("A pessoa "+ threadId()+" chegou no final do corredor");
        try {
            porta.acquire();
            int tempo = (int) ((Math.random()*1001)+1000);
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            porta.release();
        }
        System.out.println("A pessoa "+ threadId()+" pasou pela porta");
    }
    
}
