package com.github.mrpaulblack.tron;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URI;
import java.nio.charset.Charset;



/**
* <h1>Server</h1>
* <p>Server class that creates a UDP socket and sends and recieves Datagram packages to and from clients.
* insired by: https://www.codejava.net/java-se/networking/java-udp-client-server-program-example</p>
* @author: swt_lerngruppe_tron
* @version 1.0
* @since   2021-12-29
*/
public class Server {
	private DatagramSocket socket;
	private ServerController controller;



	/**
	 *	<h1><i>Server</i></h1>
	 * <p>This contructor creates the server with socket as well as the ServerController
	 * to decode paylods and send data as part of the API spec.</p>
	 * @param port - int of the port where the 
	 * @param ip - InetAddress of the interface where the server is going to listen on
	 */
	public Server(int port, InetAddress ip) throws SocketException {
		socket = new DatagramSocket(port, ip);
		controller = new ServerController(this);
	}



	/**
	 *	<h1><i>main</i></h1>
	 * <p>Entry point for exec of server. Creates server object and calls the recieve function
	 * to start recieving packages in an endless loop.</p>
	 * @param args - String[] array of the params ith which the prgr got called
	 */
	public static void main(String[] args) {
		try {
			//enable trace for debug
			LogController.setGlobalLogLvl(Log.TRACE);
			Server server = new Server(3000, InetAddress.getByName("127.0.0.1"));
			server.recieve();
		} catch (Exception e) {
			LogController.log(Log.ERROR, e.toString());
		}
	}



	/**
	 *	<h1><i>recieve</i></h1>
	 * <p>Recieves a Datagram package in server socket. Parses
	 * client as URI and hands of payload as a String as well
	 * as the client URI to ServerController decoder get the data
	 * parsed based on API spec.</p>
	 */
	private void recieve() throws Exception {
		LogController.log(Log.INFO, "Server started: " + socket.getLocalSocketAddress());
		while (true) {
			DatagramPacket request = new DatagramPacket(new byte[512], 512);
			socket.receive(request);
			URI client = new URI("udp:/" + request.getAddress().toString() + ":" + Integer.toString(request.getPort()));
			String payload = new String(request.getData(), Charset.forName("utf-8"));
			LogController.log(Log.TRACE,"{" + client + "} RX: " + payload);
			controller.decode(client, payload);
		}
	}



	/**
	 *	<h1><i>send</i></h1>
	 * <p>This method can be called by the ServerController to send a payload to a client.
	 * It parses the client URI back into port and InetAddress and sends the payload as
	 * a Datagram package to the client.</p>
	 * @param client - URI of the client which the packet gets send to; syntax: `udp://[client ip]:[client port]`
	 * @param payload - String of the payload that gets send to the client
	 */
	protected void send(URI client, String payload) throws Exception {
		LogController.log(Log.TRACE,"{" + client + "} TX: " + payload);
		payload += "\n";
		socket.send(new DatagramPacket(payload.getBytes(), payload.getBytes().length, InetAddress.getByName(client.getHost()), client.getPort()));
	}
}
