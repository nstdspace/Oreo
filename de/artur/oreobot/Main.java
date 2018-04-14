package de.artur.oreobot;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class Main {
	
	public String prefix,code;
	
	public Main() {
		prefix = "7mmjl";
		generateCodes(60);
	}
	
	public void generateCodes(int amount) {
		String alphabet = new String("abcdefghijklmopqrstuvwxyz1234567890");
		Random r = new Random();
		for(int i=0;i<amount;i++) {
			code = prefix;
			for(int j=0;j<3;j++) {
				code = code + alphabet.charAt(r.nextInt(alphabet.length()));
			}
			System.out.println(code);
		}
		System.out.println("art.schmunk@yandex.ru");
	}
	
	public void sendReq(String url,String email,String fname){
	    HttpClient httpClient = HttpClients.createDefault();
	    PostMethod postMethod = new PostMethod(url);
	    postMethod.addParameter("Email", email);
	    postMethod.addParameter("fname", fname);
	    try {
	        httpClient.executeMethod(postMethod);
	    } catch (HttpException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
	        String resp = postMethod.getResponseBodyAsString();
	    } else {
	         //...postMethod.getStatusLine();
	    }
	  }
	
	public static void main(String[] args) {
		new Main();
	}
}
