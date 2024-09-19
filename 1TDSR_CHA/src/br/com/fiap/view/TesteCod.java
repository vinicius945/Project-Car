package br.com.fiap.view;

import javax.swing.*;

public class TesteCod {
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            String[] sistemas = {"Carro", "Cliente", "Peça", "Mecanico", "Agendamento", "Problema", "Sair"};
            int opcao = JOptionPane.showOptionDialog(null,
                    "Escolha qual sistema você deseja acessar",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, sistemas, sistemas[0]);

            switch (opcao) {
                case 0: // Acessar sistema de Carros
                    ChaView.main(null);  // Chamando a interface do Carro
                    break;

                case 1: // Acessar sistema de Clientes
                    ClienteView.main(null);  // Chamando a interface do Cliente
                    break;

                case 2: // Acessar sistema de Fornecedores
                    PecaView.main(null);  // Chamando a interface do Fornecedor
                    break;

                case 3: //Acessar sistema de Mêcanicos
                    MecanicoView.main(null);
                    break;

                case 4: //Acessar sistema de agendamentos
                    AgendamentoView.main(null);
                    break;

                case 5:
                    ProblemaView.main(null);
                    break;
                case 6: // Sair do programa
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }
    }
}


