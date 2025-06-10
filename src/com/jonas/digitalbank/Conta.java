package com.jonas.digitalbank;

import javax.swing.JOptionPane;

public class Conta {
	private String numero;
	private double saldo;
	private Cliente cliente;

	public Conta(String numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			JOptionPane.showMessageDialog(null, "Depósito de R$ " + valor + " realizado com sucesso.");
		} else {
			JOptionPane.showMessageDialog(null, "Valor de depósito inválido.");
		}
	}

	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			JOptionPane.showMessageDialog(null, "Saque de R$ " + valor + " realizado com sucesso.");
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente ou valor inválido.");
		}
	}

	@Override
	public String toString() {
		return "Número da Conta: " + numero + "\n" + "Saldo: R$ " + saldo + "\n" + "Titular: " + cliente.getNome();
	}

}
