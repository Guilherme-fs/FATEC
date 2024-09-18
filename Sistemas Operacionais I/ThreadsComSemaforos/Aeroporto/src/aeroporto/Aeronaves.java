/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeroporto;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class Aeronaves extends Thread {
    private int id;
    private static Semaphore pistaNorte = new Semaphore(1);
    private static Semaphore pistaSul = new Semaphore(1);
    
    
    public Aeronaves(int id) {
        this.id = id;
        
    }
    
    @Override
    public void run(){
        
        int escolhaPista = (int) ((Math.random()*2)+1);
        
        if(escolhaPista==1){
            try {
                pistaNorte.acquire();
                decolagem();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeronaves.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                pistaNorte.release();
            }
        }
        if(escolhaPista==2){
            try {
                pistaSul.acquire();
                decolagem();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeronaves.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                pistaSul.release();
            }
        }
        
    }
    
    public void decolagem() throws InterruptedException{
        System.out.println("O avião "+id+" esta manobrando");
        int manobra = (int) (300+(Math.random()*(700-300)));
        Thread.sleep(manobra);
        
        System.out.println("O avião "+id+" esta taxiando");
        int taxiar = (int) (500+(Math.random()*(1000-500)));
        Thread.sleep(taxiar);
        
        System.out.println("O avião "+id+" esta decolando");
        int decolagem = (int) (600+(Math.random()*(800-600)));
        Thread.sleep(decolagem);
        
        System.out.println("O avião "+id+" esta afastando da área");
        int afastamento = (int) (300+(Math.random()*(800-300)));
        Thread.sleep(afastamento);
    }
    
}
