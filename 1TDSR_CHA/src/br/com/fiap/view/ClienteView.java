package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ClienteView {
        public static void main(String[] args) {
            String cpf, nome, genero, motivoDeContato;
            String[] escolha = {"Inserir", "Excluir", "Listar"};
            int opcao;
            ClienteController clienteController = new ClienteController();

            do {
                try {
                    // Exibindo o menu de opções
                    opcao = JOptionPane.showOptionDialog(null,
                            "Escolha uma das opções abaixo para manipular um Cliente",
                            "Escolha",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, escolha, escolha[0]);

                    // Entrada do CPF do cliente, que será utilizada em todas as opções
                    cpf = JOptionPane.showInputDialog("Digite o CPF do cliente");

                    switch (opcao) {

                        case 0: // Inserir
                            String id_cliente = JOptionPane.showInputDialog("Digite o ID do cliente");
                            nome = JOptionPane.showInputDialog("Digite o nome do cliente");
                            genero = JOptionPane.showInputDialog("Digite o gênero do cliente");
                            motivoDeContato = JOptionPane.showInputDialog("Digite o motivo de contato");
                            Integer veiculoIdCarro = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do carro"));

                            // Chamando o método inserir do controller e exibindo o resultado
                            System.out.println(clienteController.inserirCliente(Integer.parseInt(id_cliente), cpf, nome, genero, motivoDeContato, veiculoIdCarro));

                            break;

                        case 1: // Alterar
                            String novoId_cliente = JOptionPane.showInputDialog("Digite o NOVO ID do cliente");
                            nome = JOptionPane.showInputDialog("Digite o NOVO nome do cliente");
                            genero = JOptionPane.showInputDialog("Digite o NOVO gênero do cliente");
                            motivoDeContato = JOptionPane.showInputDialog("Digite o NOVO motivo de contato");
                            veiculoIdCarro = Integer.valueOf(JOptionPane.showInputDialog("Digite o ID do veiculo"));

                            // Chamando o método alterar do controller e exibindo o resultado
                            System.out.println(clienteController.alterarCliente(Integer.parseInt(novoId_cliente), cpf, nome, genero, motivoDeContato, veiculoIdCarro));

                            break;

                        case 2: // Excluir
                            System.out.println(clienteController.excluirCliente(cpf));

                            break;

                        case 3: // Listar um cliente
                            JOptionPane.showMessageDialog(null, clienteController.listarCliente(cpf));

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

