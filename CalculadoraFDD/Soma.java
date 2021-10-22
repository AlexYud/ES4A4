package Caculadora;

import javax.swing.JOptionPane;

public class Soma extends Operacao {

	public Soma() {
		// Calculo
		this.resultado = this.primeiroNum + this.segundoNum;
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado: " + this.resultado);
	}
	
}
