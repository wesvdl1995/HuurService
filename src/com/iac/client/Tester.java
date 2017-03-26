package com.iac.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Tester {

	// http://localhost:8080/IAC2/rest/getKamers
	public static void main(String[] args) {
		System.out.println("Tester has started.");
		while (true){
			try {
				BufferedReader brlink = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("\n\nEnter REST GET url (default: http://localhost:8080/IAC2/rest/getKamers)\n");
		        String in = brlink.readLine();
		        if (in.toLowerCase().equals("stop") || in.toLowerCase().equals("quit")  || in.toLowerCase().equals("exit")  || in.toLowerCase().equals("shutdown") ){
		        	System.out.println("Tester has shutdown.");
		        	break;
		        }
		        if (in.isEmpty() || !in.toLowerCase().contains("http://localhost:8080/")){
		        	in = "http://localhost:8080/IAC2/rest/getKamers";
		        }
		        
				HttpURLConnection conn = (HttpURLConnection) new URL(in).openConnection();
								  conn.setRequestMethod("GET");
								  conn.setRequestProperty("Accept", "application/json");
	
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
	
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	
				String out;
				System.out.print("URL        : "+in+"\nJSON Output: ");
				while ((out = br.readLine()) != null) {
					System.out.println(out.toString());
				}
				
				conn.disconnect();
	
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException, (meestal 404 not found error)");
				//e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException");
				//e.printStackTrace();
			}
		}

	}

}