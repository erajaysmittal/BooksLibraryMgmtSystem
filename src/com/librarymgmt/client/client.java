package com.librarymgmt.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class client {

	public static void main(String[] args) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/BooksLibrary/BooksLibrary/booksMgmtService/books");
			String input = "{\"book\":[{\"authorMap\":{\"entry\":{\"key\":\"3\",\"value\":{\"id\":\"3\",\"lastName\":\"MITTAL\",\"name\":\"cccc\"}}},\"category\":{\"id\":\"3\",\"name\":\"kuchbhi\"},\"id\":\"3\",\"title\":\"kuchbhi tales\"}]}";
			//{\"book\":[{\"authorMap\":{\"entry\":{\"key\":\"3\",\"value\":{\"id\":\"3\",\"lastName\":\"MITTAL\",\"name\":\"cccc\"}}},\"category\":{\"id\":\"3\",\"name\":\"kuchbhi\"},\"id\":\"3\",\"title\":\"kuchbhi tales\"}]}
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}