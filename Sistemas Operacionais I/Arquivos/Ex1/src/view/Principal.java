
package view;

import controller.FifaController;
import controller.IFifaController;
import controller.Lista;
import controller.Pilha;
import java.io.IOException;


public class Principal {
    public static void main(String[] args) throws IOException {
        IFifaController controller = new FifaController();
        String caminho = "fifa19";
        String nomeArquivo = "data.csv";
        
        //FifaController fc = new FifaController();
        //fc.desempilharBrasileiros(fc.empilhaBrasileiros(caminho, nomeArquivo));

        try {
            // Empilha jogadores brasileiros
            Pilha<String> brasileiros = controller.empilhaBrasileiros(caminho, nomeArquivo);
            System.out.println("Jogadores Brasileiros Empilhados:");

            // Desempilha e exibe jogadores brasileiros com Overall > 80
            controller.desempilharBrasileiros(brasileiros);

            // Lista jogadores revelação (idade <= 20)
            Lista revelacoes = controller.listaRevelacoes(caminho, nomeArquivo);
            System.out.println("\nJogadores Revelação Listados:");

            // Busca e exibe jovens bons jogadores (Overall > 80 e idade <= 20)
            controller.buscarListaBonsJovens(revelacoes);

        } catch (Exception e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
}
