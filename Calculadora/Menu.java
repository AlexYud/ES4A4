package Calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {

	JButton bSom = new JButton("Soma");
	JButton bSub = new JButton("Subtração");
	JButton bMult = new JButton("Multiplicação");
	JButton bDiv = new JButton("Divisão");
	JButton bSair = new JButton("Sair");
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bSom) {
			// Soma
			try {
				new Soma();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else if (e.getSource() == bSub) {
			// Subtração
			
		} else if (e.getSource() == bMult) {
			// Multiplicação
			try {
				new Multiplicacao();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else if (e.getSource() == bDiv) {
			// Divisão
			
		} else {
			if (JOptionPane.showConfirmDialog(bSair, "Deseja mesmo sair?") == 0) {
				System.exit(0);
			}
		}
	}
	
	public Menu() {
		
		setTitle("Calculadora");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		setLayout(null);
		bSom.setBounds(150, 40, 200, 50);
		bSub.setBounds(150, 120, 200, 50);
		bMult.setBounds(150, 200, 200, 50);
		bDiv.setBounds(150, 280, 200, 50);
		bSair.setBounds(200, 370, 100, 50);
		add(bSom);
		add(bSub);
		add(bMult);
		add(bDiv);
		add(bSair);
		
		bSom.addActionListener(this);
		bSub.addActionListener(this);
		bMult.addActionListener(this);
		bDiv.addActionListener(this);
		bSair.addActionListener(this);
	}
	
}
