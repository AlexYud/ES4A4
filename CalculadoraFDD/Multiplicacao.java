package Caculadora;

import javax.swing.JOptionPane;

public class Multiplicacao extends Operacao {
	
	public Multiplicacao() {
		// Calculo
		this.resultado = this.primeiroNum * this.segundoNum;
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado final: " + this.resultado);
	}
	
}
