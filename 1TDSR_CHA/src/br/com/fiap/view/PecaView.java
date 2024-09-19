package br.com.fiap.view;

import br.com.fiap.controller.PecaController;

import javax.swing.*;

public class PecaView {
    public static void main(String[] args) {
        String nome, compatibilidade, estoque;
        String[] escolha = {"Inserir", "Excluir", "Listar"};
        int opcao;
        PecaController pecaController = new PecaController();

        do {
            try {
                // Exibindo o menu de opções
                opcao = JOptionPane.showOptionDialog(null,
                        "Escolha uma das opções abaixo para manipular uma Peça",
                        "Escolha",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, escolha, escolha[0]);

                nome = JOptionPane.showInputDialog("Digite o Nome da Peça");

                switch (opcao) {

                    case 0: // Inserir
                        String id_peca = JOptionPane.showInputDialog("Digite o ID da Peça");
                        compatibilidade = JOptionPane.showInputDialog("Digite o a compatibilidade da peça");
                        estoque = JOptionPane.showInputDialog("Digite o estoque");

                        // Chamando o método inserir do controller e exibindo o resultado
                        String resultado = pecaController.inserirPeca(Integer.parseInt(id_peca), nome, compatibilidade, estoque);
                        JOptionPane.showMessageDialog(null, resultado);

                        break;

                    case 1: // Alterar
                        Integer novoId_peca = Integer.valueOf(JOptionPane.showInputDialog("Digite o NOVO ID da peça"));
                        nome = JOptionPane.showInputDialog("Digite o NOVO nome da peça");
                        compatibilidade = JOptionPane.showInputDialog("Digite A NOVA compatibilidade");
                        estoque = JOptionPane.showInputDialog("Digite o NOVO estoque");


                        resultado = pecaController.alterarPeca(novoId_peca, nome, compatibilidade, estoque);
                        JOptionPane.showMessageDialog(null, resultado);

                        break;

                    case 2:
                        resultado = pecaController.excluirPeca(nome);
                        JOptionPane.showMessageDialog(null, resultado);

                        break;

                    case 3:
                        resultado = pecaController.listarPeca(nome);
                        JOptionPane.showMessageDialog(null, resultado);

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                e.printStackTrace(); //
            }

        } while (JOptionPane.showConfirmDialog(null,
                "Deseja continuar?",
                "Atenção!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }
}
