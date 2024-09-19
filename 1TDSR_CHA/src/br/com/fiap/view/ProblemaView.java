package br.com.fiap.view;

import br.com.fiap.controller.CarroController;
import br.com.fiap.controller.ProblemaController;

import javax.swing.*;

public class ProblemaView {
    public static void main(String[] args) {
        String descricao_1, causa_raiz, solucao;
        String[] escolha = {"Inserir"};
        int opcao;
        ProblemaController problemaController = new ProblemaController();

        do {
            try {
                // Exibindo o menu de opções
                opcao = JOptionPane.showOptionDialog(null,
                        "Escolha uma das opções abaixo para verificar o problema",
                        "Escolha",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, escolha, escolha[0]);


                switch (opcao) {

                    case 0: // Inserir
                        String id_problema = JOptionPane.showInputDialog("Digite o ID do problema");
                        descricao_1 = JOptionPane.showInputDialog("Digite a descricao");
                        causa_raiz = JOptionPane.showInputDialog("Digite a causa raiz");
                        solucao = JOptionPane.showInputDialog("Digite a solucao");

                        // Chamando o método inserir do controller e exibindo o resultado
                        System.out.println(problemaController.inserir(Integer.parseInt(id_problema),descricao_1, causa_raiz ,solucao));

                        break;
                    default:
                        System.out.println("Opção Inválida!");

                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace(); // Mostrar detalhes do erro para depuração
            }

        } while (JOptionPane.showConfirmDialog(null,
                "Deseja continuar?",
                "Atenção!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }
}
