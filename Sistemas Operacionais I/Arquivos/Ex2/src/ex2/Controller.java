/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Controller  extends SimpleFileVisitor<Path> {
    public void listarArquivosOrdenadosTamanho(String caminho) {
        File diretorio = new File(caminho);

        if (!diretorio.exists()) {
            System.out.println("O caminho especificado não existe.");
            return;
        }

        if (!diretorio.isDirectory()) {
            System.out.println("O caminho especificado não é um diretório.");
            return;
        }

        List<File> arquivos = new ArrayList<>();

        // Adiciona apenas arquivos na lista (exclui subdiretórios)
        for (File arquivo : diretorio.listFiles()) {
            if (arquivo.isFile()) {
                arquivos.add(arquivo);
            }
        }

        // Ordena a lista de arquivos por tamanho em ordem crescente
        arquivos.sort(Comparator.comparingDouble(File::length));

        System.out.println("Lista de arquivos no diretório: " + caminho);
        for (File arquivo : arquivos) {
            double tamanhoEmMB = (double) arquivo.length() / (1024 * 1024); // Converte para MB
            System.out.printf("Arquivo: %s - Tamanho: %f MB\n", arquivo.getName(), tamanhoEmMB);
        }
    }
}
