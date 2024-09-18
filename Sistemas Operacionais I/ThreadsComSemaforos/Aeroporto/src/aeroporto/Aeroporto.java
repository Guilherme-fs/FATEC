/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aeroporto;

/**
 *
 * @author guilh
 */
public class Aeroporto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int id=0; id<12; id++){
            Thread aviao = new Aeronaves(id);
            aviao.start();
        }
        
    }
    
}
