package Caculadora;

import javax.swing.JOptionPane;

public class Divisao extends Operacao {
	
	public Divisao() {
		// Calculo
		this.resultado = this.primeiroNum / this.segundoNum;
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado: " + this.resultado);
	}
	
}