/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pessoascorredor;

/**
 *
 * @author guilh
 */
public class PessoasCorredor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int x=0; x<4; x++){
            Thread pessoa = new Corredor();
            pessoa.start();
        }
    }
    
}
