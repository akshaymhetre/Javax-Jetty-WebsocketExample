package com.akshay.poc.ws;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;

import com.akshay.poc.ws.client.ToUpperWSClient;

public class ToUpperWSMain {
	public static void main(String[] args) {
		
		try {

			String dest = "ws://localhost:8080/toUpper";
			ToUpperWSClient socket = new ToUpperWSClient();
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(socket, new URI(dest));

			socket.getLatch().await();
			socket.sendMessage("echo356");
			socket.sendMessage("test356");
			Thread.sleep(10000l);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
