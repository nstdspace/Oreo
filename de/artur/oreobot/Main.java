package de.artur.oreobot;

import java.net.URI;
import java.util.ArrayList;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpRequestHandler;


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
		HttpPost httpPost = new HttpPost(uri);

		CloseableHttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		client.execute(httpPost);
		
		ArrayList<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("nameterms_conditions", "????"));
		params.add(new BasicNameValuePair("privacy_policy", "????"));
			
		CloseableHttpResponse response = client.execute(httpPost);
		System.out.println(response.getStatusLine().getStatusCode()); //this should be 200
		
		BasicResponseHandler handler = new BasicResponseHandler();
		String body = handler.handleResponse(response);
		System.out.println(body);
		
		System.out.println(response);
		client.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main();
	}
}
