package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class ServerTask implements Callable<Void> {

    BufferedReader input;
    Connection connection;
    Boolean running = true;
    DataEvent dataEvent;

    public ServerTask(DataEvent de, Connection c){
        this.connection = c;
        this.dataEvent = de;
    }

    @Override
    public Void call() throws Exception {
        try{
            input = new BufferedReader(new InputStreamReader(connection.connection.getInputStream()));
        while(running){
            String msg = input.readLine();

            if(msg != null){
                dataEvent.receiveData(connection, msg);
            }
        }
        } catch (IOException ex){
            System.err.println(ex);
        }
        return null;
    }
}
