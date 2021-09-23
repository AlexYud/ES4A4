package Calculadora;

import javax.swing.JOptionPane;

public class Soma {

	double primeiroNum;
	double segundoNum;
	double resultado;
	
	public Soma() {
		// Inputs
		this.primeiroNum = Double.parseDouble(JOptionPane.showInputDialog("Digite um número"));
		this.segundoNum = Double.parseDouble(JOptionPane.showInputDialog("Digite mais um número"));
		// Calculo
		this.resultado = this.primeiroNum + this.segundoNum;
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado: " + this.resultado);
	}
	
}
