package com.jonas.digitalbank;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Entrada de dados do cliente
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String cpf = JOptionPane.showInputDialog("Digite seu CPF:");
        String email = JOptionPane.showInputDialog("Digite seu e-mail:");
        String telefone = JOptionPane.showInputDialog("Digite seu telefone:");
        String endereco = JOptionPane.showInputDialog("Digite seu endereço:");

        Cliente cliente1 = new Cliente(nome, cpf, email, telefone, endereco);

        String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
        Conta conta1 = new Conta(numeroConta, cliente1);

        JOptionPane.showMessageDialog(null, "Conta criada com sucesso:\n" + conta1);

        // Menu usando  Switch case para dar opções ao usuariuo escolher a operação
        int opcao = 0;
        while (opcao != 6) {
            String menu = "Escolha uma opção:\n" +
                          "1 - Ver saldo\n" +
                          "2 - Depositar\n" +
                          "3 - Sacar\n" +
                          "4 - Ver dados da conta\n" +
                          "5 - Ver dados do cliente\n" +
                          "6 - Sair";

            String escolha = JOptionPane.showInputDialog(menu);
            if (escolha == null) break;

            try {
                opcao = Integer.parseInt(escolha);

                switch (opcao) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + conta1.getSaldo());
                        break;
                    case 2:
                        String valorDep = JOptionPane.showInputDialog("Valor para depósito:");
                        double deposito = Double.parseDouble(valorDep);
                        conta1.depositar(deposito);
                        break;
                    case 3:
                        String valorSaq = JOptionPane.showInputDialog("Valor para saque:");
                        double saque = Double.parseDouble(valorSaq);
                        conta1.sacar(saque);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Informações da conta:\n" + conta1.toString());
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Dados do cliente:\n" + cliente1.toString());
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Obrigado por usar o DigitalBank!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido.");
            }
        }
    }
}
