package com.company;

import java.net.Socket;

/**
 * Created by drew on 5/10/15.
 */
public class Connection {
    Socket connection;
    public Connection(Socket connection){
        this.connection = connection;
    }
}
