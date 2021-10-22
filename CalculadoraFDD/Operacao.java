package Caculadora;

import javax.swing.JOptionPane;

public abstract class Operacao {
	double primeiroNum;
	double segundoNum;
	double resultado;
	
	public Operacao() {
		// Inputs
		this.primeiroNum = Double.parseDouble(JOptionPane.showInputDialog("Digite um número"));
		this.segundoNum = Double.parseDouble(JOptionPane.showInputDialog("Digite mais um número"));
	}
}
