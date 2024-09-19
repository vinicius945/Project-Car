package br.com.fiap.view;

import br.com.fiap.controller.MecanicoController;

import javax.swing.*;

public class MecanicoView {public static void main(String[] args) {
    String cpf, nome, informacaoDeContato, numeroPropostaComercial ;
    String[] escolha = {"Inserir", "Excluir", "Listar"};
    int opcao;
    MecanicoController mecanicoController = new MecanicoController();

    do {
        try {
            opcao = JOptionPane.showOptionDialog(null,
                    "Escolha uma das opções abaixo para manipular os dados do  mecanico",
                    "Escolha",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, escolha, escolha[0]);

            // Entrada da placa do carro, que será utilizada em todas as opções
            cpf = JOptionPane.showInputDialog("Digite o CPF do mecanico");

            switch (opcao) {

                case 0: // Inserir
                    String id_mecanico = JOptionPane.showInputDialog("Digite o ID do mecanico");
                    nome = JOptionPane.showInputDialog("Digite o nome do Mecânico: ");
                    informacaoDeContato = JOptionPane.showInputDialog("Digite o contato do mecanico: ");
                    numeroPropostaComercial = JOptionPane.showInputDialog("Digite o número de proposta comercial: ");



                    // Chamando o método inserir do controller e exibindo o resultado
                    System.out.println(mecanicoController.inserirMecanico(Integer.parseInt(id_mecanico), Integer.parseInt(cpf), nome, informacaoDeContato, Integer.parseInt(numeroPropostaComercial)));

                    break;

                case 1: // Alterar
                    String novoId_mecanico = JOptionPane.showInputDialog("Digite o NOVO ID do mecanico");
                    nome = JOptionPane.showInputDialog("Digite o NOVO nome do mecanico");
                    informacaoDeContato = JOptionPane.showInputDialog("Digite o NOVO contato do mecanico");
                    numeroPropostaComercial = JOptionPane.showInputDialog("Digite o novo número da proposta comercial");

                    // Ajuste: Passando todos os parâmetros esperados
                    System.out.println(mecanicoController.alterarMecanico(Integer.parseInt(novoId_mecanico), Integer.parseInt(cpf), nome, informacaoDeContato, Integer.parseInt(numeroPropostaComercial)));

                    break;

                case 2: // Excluir
                    System.out.println(mecanicoController.excluirMecanico(Integer.valueOf(cpf)));

                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, mecanicoController.listarUmMecanico(Integer.valueOf(cpf)));

                    break;

                default:
                    System.out.println("Opção Inválida!");

            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }

    } while (JOptionPane.showConfirmDialog(null,
            "Deseja continuar?",
            "Atenção!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == 0);

    JOptionPane.showMessageDialog(null, "Fim de Programa!");
}
}


