package de.artur.oreobot;

import java.net.URI;
import java.util.Random;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;


public class Main {
	
	public String prefix,code;
	
	public Main() throws Exception {
		prefix = "7mmjl";
//		generateCodes(60);
		sendReq("", "", "");
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
	
	public void sendReq(String url,String email,String fname) throws Exception {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("www.greatoreosearch.com")
				.setPath("/de/code")
				.build();
		HttpPost httppost = new HttpPost(uri);
		System.out.println(httppost.getURI());
		
//		HttpClient httpClient = HttpClients.createDefault();
//	    PostMethod postMethod = new PostMethod(url);
//	    postMethod.addParameter("Email", email);
//	    postMethod.addParameter("fname", fname);
//	    try {
//	        httpClient.executeMethod(postMethod);
//	    } catch (HttpException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//
//	    if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
//	        String resp = postMethod.getResponseBodyAsString();
//	    } else {
//	         //...postMethod.getStatusLine();
//	    }
	  }
	
	public static void main(String[] args) throws Exception {
		new Main();
	}
}
