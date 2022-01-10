package com.github.mrpaulblack.tron;

// TODO write doc
import java.util.TimerTask;

public class SessionTimer extends TimerTask {

    @Override
    public void run() {
        // TODO imple. game or ServerController call to exec tickts for a running game
        // example usage every 1s: new Timer().scheduleAtFixedRate(new ServerTimer(), 0, 1000);
        // can be canceled with this.cancel(); or by calling the timer: time.cancel();
        // this method is going to call broadcastUpdate with a session id;
    }
    
}
