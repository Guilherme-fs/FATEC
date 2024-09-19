/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cruzamentocarros;

/**
 *
 * @author guilh
 */
public class CruzamentoCarros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int sentido=0;
        for(int x=0; x<20; x++){
            Thread carro = new ControladorCarros(sentido);
            carro.start();
        }
        
    }
    
}
