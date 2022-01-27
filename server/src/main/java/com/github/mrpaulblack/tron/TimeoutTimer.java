package com.github.mrpaulblack.tron;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimerTask;
import java.util.Map.Entry;



/**
 * <p>TimeoutTimer class is to remove inactive clients from the game. The run method gets called
 * in a regular interval (60s by default) and checks every client, if they exceted the timeout value.
 * If so the timer calls the disconnect method and removes the client from the server.</p>
 * @version 1.0
 * @since   2021-12-29
 */
public class TimeoutTimer extends TimerTask {
    private ServerController controller;
    private long timeout;



    /**
	 * <p>This constructor saves the timeout as well as the ServerController as attributes.</p>
	 * @param controller - ServerController is the controller where the client timeouts are stored
	 * @param timeout - long is the timeout in seconds for each client
	 */
    public TimeoutTimer(ServerController controller, long timeout) {
        this.controller = controller;
        this.timeout = timeout;
    }



    /**
	 * <p>This method gets called in a regular time interval. It interates over every client and checks 
     * if the timeout is longer inactive as the timeout value. If so it removes the client from the server,
     * by calling the disconnect function and passing the client as argument.</p>
	 */
    @Override
    public void run() {
        LogController.log(Log.DEBUG, "Executing client timeout task");
        for (Entry<URI, LocalDateTime> entry : controller.getClientTimeout().entrySet()) {
            if (entry.getValue().isBefore(LocalDateTime.now().minus(timeout, ChronoUnit.SECONDS))) {
                LogController.log(Log.DEBUG, "Client reached timeout; Removing");
                controller.remove(entry.getKey());
            }
        }
    }
}
