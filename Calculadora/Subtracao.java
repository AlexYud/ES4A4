package Calculadora;

import javax.swing.JOptionPane;

public class Subtracao{

	double primeiroNum;
	double segundoNum;
	double resultado;
	
	public Subtracao() {
		// Entradas
		this.primeiroNum = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número: "));
		this.segundoNum = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número: "));
		// Calculo
		this.resultado = this.primeiroNum - this.segundoNum;
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado: " + this.resultado);
	}
	
}