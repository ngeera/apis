package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main {
	
	
	private static HttpsURLConnection connection;

	public static void main(String[] args) {
		//  Method 1: java.net.HttpURLConnection
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			connection = (HttpsURLConnection) url.openConnection();
			
			//Request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			System.out.println(status);
			
			if (status > 299)
			{
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				
				while((line=reader.readLine()) !=null)
				{
					responseContent.append(line);
					
				}
				reader.close();
			} else {
				
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((line=reader.readLine()) !=null)
				{
					responseContent.append(line);
					
				}
				reader.close();
				
			}
			
			System.out.println(responseContent.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.disconnect();
			
		}

	}

}
