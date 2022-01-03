/*
 * Sample echo UPD server (insired by: https://www.codejava.net/java-se/networking/java-udp-client-server-program-example)
 * can be tested with nc -u 127.0.0.1 3000 and sending data by typing in terminal and pressing return
 */
package com.github.mrpaulblack.tron;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	private static Integer port = 3000;
	private DatagramSocket socket;

	public Server(int port) throws SocketException {
		socket = new DatagramSocket(port);
	}

	public static void main(String[] args) {
		try {
			Server server = new Server(port);
			server.recieve();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void recieve() throws IOException {
		while (true) {
			DatagramPacket request = new DatagramPacket(new byte[512], 512);
			socket.receive(request);
			//set timeout for socket; easy to impl on client; but how to deciever between clients on server!?
			//socket.setSoTimeout(1000);

			byte[] buffer = request.getData();

			DatagramPacket response = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
			socket.send(response);
		}
	}
}
