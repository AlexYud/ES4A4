package Caculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {

	JButton bSom = new JButton("Soma");
	JButton bSub = new JButton("Subtra��o");
	JButton bMult = new JButton("Multiplica��o");
	JButton bDiv = new JButton("Divis�o");
	JButton bRaiz = new JButton("Raiz");
	JButton bSair = new JButton("Sair");
	
	private boolean upd;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bSom) {
			// Soma
			try {
				this.upd = false;
				TimeUnit.SECONDS.sleep(1);
				new Soma();	
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else if (e.getSource() == bSub) {
			// Subtra��o
			try {
				this.upd = false;
				TimeUnit.SECONDS.sleep(1);
				new Subtracao();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else if (e.getSource() == bMult) {
			// Multiplica��o
			try {
				this.upd = false;
				TimeUnit.SECONDS.sleep(1);
				new Multiplicacao();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else if (e.getSource() == bDiv) {
			// Divis�o
			try {
				this.upd = false;
				TimeUnit.SECONDS.sleep(1);
				new Divisao();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else if (e.getSource() == bRaiz) {
			// Ra�z
			try {
				this.upd = false;
				TimeUnit.SECONDS.sleep(1);
				new Raiz();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		} else {
			if (JOptionPane.showConfirmDialog(bSair, "Deseja mesmo sair?") == 0) {
				System.exit(0);
			}
		}
	}
	
	public Menu() throws InterruptedException {
		setTitle("Calculadora");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		setLayout(null);
		bSom.setBounds(150, 40, 200, 50);
		bSub.setBounds(150, 120, 200, 50);
		bMult.setBounds(150, 200, 200, 50);
		bDiv.setBounds(150, 280, 200, 50);
		bRaiz.setBounds(150, 360, 200, 50);
		bSair.setBounds(200, 450, 100, 50);
		add(bSom);
		add(bSub);
		add(bMult);
		add(bDiv);
		add(bRaiz);
		add(bSair);
		
		bSom.addActionListener(this);
		bSub.addActionListener(this);
		bMult.addActionListener(this);
		bDiv.addActionListener(this);
		bRaiz.addActionListener(this);
		bSair.addActionListener(this);
		
		this.upd = true;
		while (this.upd) {
			Update();
			TimeUnit.SECONDS.sleep(1);
		}
	}
	
	public void Update() throws InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body.split("\"");
		
		if (arr.length > 27) {
			var op = arr[27];
			
			if (op.equals("adicao")) {
				TimeUnit.SECONDS.sleep(1);
				new Soma();
			} else if (op.equals("subtracao")) {
				TimeUnit.SECONDS.sleep(1);
				new Subtracao();
			} else if (op.equals("multiplicacao")) {
				TimeUnit.SECONDS.sleep(1);
				new Multiplicacao();
			} else if (op.equals("divisao")) {
				TimeUnit.SECONDS.sleep(1);
				new Divisao();
			} else if (op.equals("raiz")) {
				TimeUnit.SECONDS.sleep(1);
				new Raiz();
			} 
		} else {
			System.out.println("Sem intera��es");
		}
		
		
	}
	
}
