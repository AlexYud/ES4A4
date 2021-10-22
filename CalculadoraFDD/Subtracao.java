package Caculadora;

import javax.swing.JOptionPane;

public class Subtracao extends Operacao {
	
	public Subtracao() {
		// Calculo
		this.resultado = this.primeiroNum - this.segundoNum;
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado: " + this.resultado);
	}
	
}