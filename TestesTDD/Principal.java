package HTTPRequest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {

	public static void main(String[] args) {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dweet.io/get/latest/dweet/for/coopcalcDarkEclipse")).build();
		var body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.join();
		String[] arr = body.split("\"");
		if (arr.length == 29) { // Apenas 1 parametro
			var op = arr[27];
			System.out.println("op: " + op);
		} else if (arr.length == 34) { // Apenas 2 parametros
			var op = arr[27];
			var n1 = arr[32];
			System.out.println("op: " + op + " | num1: " + n1);
		} else if (arr.length == 39) { // Todos parametros
			var op = arr[27];
			var n1 = arr[32];
			var n2 = arr[37];
			System.out.println("op: " + op + " | num1: " + n1 + " | num2: " + n2);
		} else {
			System.out.println("arr.length wrong");
		}
		
	}

}
