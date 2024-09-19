package br.com.fiap.view;

import br.com.fiap.controller.AgendamentoController;

import javax.swing.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgendamentoView {
    public static void main(String[] args) {
        String cliente, veiculo, data_hora, tipo_servico;
        String[] escolha = {"Inserir"};
        int opcao;
        AgendamentoController agendamentoController = new AgendamentoController();

        do {
            try {
                // Exibindo o menu de opções
                opcao = JOptionPane.showOptionDialog(null,
                        "Escolha uma das opções abaixo para realizar o agendamento",
                        "Escolha",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, escolha, escolha[0]);

                switch (opcao) {

                    case 0: // Inserir
                        String id_agendamento = JOptionPane.showInputDialog("Digite o ID do agendamento");
                        cliente = JOptionPane.showInputDialog("Digite o cliente");
                        veiculo = JOptionPane.showInputDialog("Digite o veiculo do proprietário");
                        data_hora = JOptionPane.showInputDialog("Digite a data e hora do agendamento (dd-MM-yy HH:mm), exemplo: 24-05-15 14:30");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm");
                        java.util.Date date = sdf.parse(data_hora);
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        tipo_servico = JOptionPane.showInputDialog("Digite o tipo de serviço");

                        // Convertendo a data e hora para java.sql.Date

                        System.out.println(AgendamentoController.Inserir(Integer.parseInt(id_agendamento), cliente, veiculo, sqlDate, tipo_servico));

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