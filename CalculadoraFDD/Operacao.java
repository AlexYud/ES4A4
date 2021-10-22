package Caculadora;

import javax.swing.JOptionPane;

public abstract class Operacao {
	double primeiroNum;
	double segundoNum;
	double resultado;
	int reply = JOptionPane.NO_OPTION;
	
	public Operacao() {
		// Inputs
		while(reply != JOptionPane.YES_OPTION) {
			this.primeiroNum = Double.parseDouble(JOptionPane.showInputDialog("Digite um n�mero"));
			this.segundoNum = Double.parseDouble(JOptionPane.showInputDialog("Digite mais um n�mero"));
			reply = JOptionPane.showConfirmDialog(null, "Confirmar valores? (" + primeiroNum + " | " + segundoNum + ")", "Confirmação", JOptionPane.YES_NO_OPTION);
		}
	}
}
