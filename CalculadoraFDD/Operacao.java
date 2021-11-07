package Caculadora;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import javax.swing.JOptionPane;


public abstract class Operacao {
	double primeiroNum;
	double segundoNum;
	double resultado;
	int reply = JOptionPane.NO_OPTION;
	
	public Operacao() {
		// Inputs	
		while(reply != JOptionPane.YES_OPTION) {
			Update();
			this.primeiroNum = Double.parseDouble(JOptionPane.showInputDialog("Digite um número", this.primeiroNum));
			Update2();
			this.segundoNum = Double.parseDouble(JOptionPane.showInputDialog("Digite mais um número", this.segundoNum));
			reply = JOptionPane.showConfirmDialog(null, "Confirmar valores? (" + primeiroNum + " | " + segundoNum + ")", "Confirmação", JOptionPane.YES_NO_OPTION);
		}
	}
	
	public void Update() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body.split("\"");
		
		if (arr.length > 29) {
			var op = arr[32];
			this.primeiroNum = Double.parseDouble(op);
		} 
	}
	
	public void Update2() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body.split("\"");
		
		if (arr.length > 34) {
			var op = arr[37];
			this.segundoNum = Double.parseDouble(op);
		} 
	}

}
