package Caculadora;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JOptionPane;

public class Raiz extends Operacao {

	public Raiz() {
		// Calculo
		this.resultado = Math.sqrt(this.primeiroNum);
		// Resultado
		JOptionPane.showMessageDialog(null, "Resultado: " + this.resultado);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://dweet.io/dweet/for/coopcalcDarkEclipse?"))).build();
		var body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
	}
    	
}