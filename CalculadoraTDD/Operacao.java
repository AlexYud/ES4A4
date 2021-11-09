package Caculadora;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;
import java.net.URI;

import javax.swing.JOptionPane;


public abstract class Operacao {
	double primeiroNum;
	double segundoNum;
	double resultado;
	String operacao;
	int reply = JOptionPane.NO_OPTION;
	
	public Operacao() {
		
		if (this.getClass().toString().equals("class Caculadora.Soma")) {
			this.operacao = "adicao";
		} else if (this.getClass().toString().equals("class Caculadora.Subtracao")) {
			this.operacao = "subtracao";
		} else if (this.getClass().toString().equals("class Caculadora.Multiplicacao")) {
			this.operacao = "multiplicacao";
		} else if (this.getClass().toString().equals("class Caculadora.Divisao")) {
			this.operacao = "divisao";
		} else if (this.getClass().toString().equals("class Caculadora.Raiz")) {
			this.operacao = "raiz";
		}
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request5 = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body5 = client.sendAsync(request5, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body5.split("\"");
		if (arr.length < 29) {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://dweet.io/dweet/for/coopcalcDarkEclipse?op=%s", this.operacao))).build();
			var body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.join();
		}
		
		
		while(reply != JOptionPane.YES_OPTION) {
			try {
				TimeUnit.SECONDS.sleep(1);
				Update();
				this.primeiroNum = Double.parseDouble(JOptionPane.showInputDialog("Digite um número", this.primeiroNum));
				if (arr.length < 33) {
					HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(String.format("https://dweet.io/dweet/for/coopcalcDarkEclipse?op=%s&num1=\'%s", this.operacao, (int)this.primeiroNum))).build();
					var body2 = client.sendAsync(request2, HttpResponse.BodyHandlers.ofString())
							.thenApply(HttpResponse::body)
							.join();
				}
				if (this.getClass().toString().equals("class Caculadora.Raiz")) {
					reply = JOptionPane.showConfirmDialog(null, "Confirmar valor? (" + primeiroNum + ")", "Confirmação", JOptionPane.YES_NO_OPTION);
					break;
				}
				Update2();
				this.segundoNum = Double.parseDouble(JOptionPane.showInputDialog("Digite mais um número", this.segundoNum));
				HttpRequest request6 = HttpRequest.newBuilder().uri(URI.create(String.format("https://dweet.io/dweet/for/coopcalcDarkEclipse?op=%s&num1=\'%s&num2=\'%s", this.operacao, (int)this.primeiroNum, (int)this.segundoNum))).build();
				var body6 = client.sendAsync(request6, HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.join();
				reply = JOptionPane.showConfirmDialog(null, "Confirmar valores? (" + primeiroNum + " | " + segundoNum + ")", "Confirmação", JOptionPane.YES_NO_OPTION);
			} catch(Exception er) {
				System.out.println(er);
			}
			
		}
	}
	
	public void Update() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request3 = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body3 = client.sendAsync(request3, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body3.split("\"");
		
		if (arr.length > 29) {
			var op = arr[31];
			op = op.replace("'", "");
			this.primeiroNum = Double.parseDouble(op);
		} 
	}
	
	public void Update2() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request4 = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body4 = client.sendAsync(request4, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body4.split("\"");
		
		if (arr.length > 35) {
			var op = arr[35];
			op = op.replace("'", "");
			this.segundoNum = Double.parseDouble(op);
		} 
	}
}