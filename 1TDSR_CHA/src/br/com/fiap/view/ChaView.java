package br.com.fiap.view;

import br.com.fiap.controller.CarroController;

import javax.swing.*;

public class ChaView {
    public static void main(String[] args) {
        String placa, modelo, cpf;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        int opcao;
        CarroController carroController = new CarroController();

        do {
            try {
                // Exibindo o menu de opções
                opcao = JOptionPane.showOptionDialog(null,
                        "Escolha uma das opções abaixo para manipular um Carro",
                        "Escolha",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, escolha, escolha[0]);

                // Entrada da placa do carro, que será utilizada em todas as opções
                placa = JOptionPane.showInputDialog("Digite a placa do carro");

                switch (opcao) {

                    case 0: // Inserir
                        String id_veiculo = JOptionPane.showInputDialog("Digite o ID do carro");
                        modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
                        cpf = JOptionPane.showInputDialog("Digite o CPF do proprietário");

                        // Chamando o método inserir do controller e exibindo o resultado
                        System.out.println(carroController.inserirCarro(Integer.parseInt(id_veiculo), placa, Integer.parseInt(cpf), modelo));

                        break;

                    case 1: // Alterar
                        String novoId_veiculo = JOptionPane.showInputDialog("Digite o NOVO ID do carro");
                        modelo = JOptionPane.showInputDialog("Digite o NOVO modelo do carro");
                        cpf = JOptionPane.showInputDialog("Digite o NOVO CPF do proprietário");

                        // Ajuste: Passando todos os parâmetros esperados
                        System.out.println(carroController.alterarCarro(Integer.parseInt(novoId_veiculo), placa, Integer.parseInt(cpf), modelo));

                        break;

                    case 2: // Excluir
                        System.out.println(carroController.excluirCarro(placa));

                        break;

                    case 3: // Listar um carro
                        JOptionPane.showMessageDialog(null, carroController.listarUmCarro(placa));

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

