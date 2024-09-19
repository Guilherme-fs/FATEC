/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cruzamentocarros;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class ControladorCarros extends Thread{
    
    private int sentido;
    Semaphore semaforo = new Semaphore(1);

    public ControladorCarros(int sentido) {
        this.sentido = sentido;
    }
    
    @Override
    public void run() {
        int id = (int) threadId();
        sentido = (int) ((Math.random() * 4) + 1);
        try {
            semaforo.acquire();
            if (sentido == 1) {
                System.out.println("O carro " + id + " seguiu no sentido norte");
            }
            if (sentido == 2) {
                System.out.println("O carro " + id + " seguiu no sentido sul");
            }
            if (sentido == 3) {
                System.out.println("O carro " + id + " seguiu no sentido leste");
            }
            if (sentido == 4) {
                System.out.println("O carro " + id + " seguiu no sentido oeste");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorCarros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            semaforo.release();
        }

    }
}
