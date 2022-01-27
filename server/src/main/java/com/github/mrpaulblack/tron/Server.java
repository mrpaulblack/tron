package com.github.mrpaulblack.tron;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URI;
import java.nio.charset.Charset;



/**
 * <p>Server class that creates a UDP socket and sends and recieves Datagram packages to and from clients.
 * inspired by: https://www.codejava.net/java-se/networking/java-udp-client-server-program-example</p>
 * @version 1.0
 * @since   2021-12-29
 */
public class Server {
	private DatagramSocket socket;
	private ServerController controller;
	private static int port = 3000;
	private static long timeout = 300;



	/**
	 * <p>This contructor creates the server with socket as well as the ServerController
	 * to decode paylods and send data as part of the API spec.</p>
	 * @param port - int of the port where the 
	 * @param ip - InetAddress of the interface where the server is going to listen on
	 * @param timeout - long is the timeout of clients in seconds
	 * @throws SocketException - if the current socket fails
	 */
	public Server(int port, InetAddress ip, long timeout) throws SocketException {
		socket = new DatagramSocket(port, ip);
		controller = new ServerController(this, timeout, 60000);
	}



	/**
	 * <p>Entry point for exec of server. Creates server object and calls the recieve function
	 * to start recieving packages in an endless loop.</p>
	 * @param args - String[] array of the params with which the prgr got called
	 */
	public static void main(String[] args) {
		for (Integer i = 0; i < args.length; i++) {
			if (args[i].toLowerCase().equals("-h") || args[i].toLowerCase().equals("--help")) {
				System.out.println("Tron UDP server supporting the tron API spec.");
				System.out.println("The server is listening on 0.0.0.0:3000 by default.\n");
				System.out.println("The following arguments are supported:");
				System.out.println("Print this help screen: -h or --help");
				System.out.println("Set Log Level: -l or --log [error] [info] [debug] [trace]");
				System.out.println("Set a server port: -p or --port [port]");
				System.out.println("Set the default timeout per client: -t --timeout [timeout in seconds]");
				System.exit(0);
			}
			else if ((args[i].toLowerCase().equals("-l") || args[i].toLowerCase().equals("--log")) && i +1 < args.length) {
				if (args[i +1].toLowerCase().equals("error")) {
					LogController.setGlobalLogLvl(Log.ERROR);
				}
				else if (args[i +1].toLowerCase().equals("info")) {
					LogController.setGlobalLogLvl(Log.INFO);
				}
				else if (args[i +1].toLowerCase().equals("debug")) {
					LogController.setGlobalLogLvl(Log.DEBUG);
				}
				else if (args[i +1].toLowerCase().equals("trace")) {
					LogController.setGlobalLogLvl(Log.TRACE);
				}
				i++;
			}
			else if ((args[i].toLowerCase().equals("-p") || args[i].toLowerCase().equals("--port")) && i +1 < args.length) {
				port = Integer.parseInt(args[i+1]);
				i++;
			}
			else if ((args[i].toLowerCase().equals("-t") || args[i].toLowerCase().equals("--timeout")) && i +1 < args.length) {
				timeout = Integer.parseInt(args[i+1]);
				i++;
			}
		}

		try {
			Server server = new Server(port, InetAddress.getByName("0.0.0.0"), timeout);
			server.recieve();
		} catch (Exception e) {
			LogController.log(Log.ERROR, e.toString());
			System.exit(1);
		}
	}



	/**
	 * <p>Recieves a Datagram package in server socket. Parses
	 * client as URI and hands of payload as a String as well
	 * as the client URI to ServerController decoder get the data
	 * parsed based on API spec.</p>
	 * @throws Exception - generic Exception
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
	 * <p>This method can be called by the ServerController to send a payload to a client.
	 * It parses the client URI back into port and InetAddress and sends the payload as
	 * a Datagram package to the client.</p>
	 * @param client - URI of the client which the packet gets send to; syntax: `udp://[client ip]:[client port]`
	 * @param payload - String of the payload that gets send to the client
	 * @throws Exception - generic Exception
	 */
	protected void send(URI client, String payload) throws Exception {
		LogController.log(Log.TRACE,"{" + client + "} TX: " + payload);
		payload += "\n";
		socket.send(new DatagramPacket(payload.getBytes(), payload.getBytes().length, InetAddress.getByName(client.getHost()), client.getPort()));
	}
}
