package hhshss;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetValidationDetails {
	
	
	public final static String BASE_URL = "http://devapi.gstsystem.co.in/taxpayerapi/v0.2/authenticate";
	
	
	public static void main(String[] args) {
		try {
			URL url = new URL(BASE_URL);
			System.out.println("BASE URL");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			System.out.println("connected");
			System.out.println("open Connection");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("clientid", "");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("client-secret", "");
			conn.setRequestProperty("ip-usr", "");
			conn.setRequestProperty("state-cd", "");
			conn.setRequestProperty("txn", "");
			conn.setRequestProperty("UserId", "");
			conn.connect();
			
		} catch (Exception e) {
			
		}
		
	}

}
