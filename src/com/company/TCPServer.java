package com.company;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class TCPServer implements Runnable{
    DataEvent dataEvent;
    public static int PORT;
    public static int NUMTHREADS;
    boolean running = true;

    ArrayList<Connection> connections;
    public TCPServer(DataEvent de, int port, int numThreads, ArrayList<Connection> u){
        this.dataEvent = de;
        this.PORT = port;
        this.NUMTHREADS = numThreads;
        connections = u;
    }

    public void run(){
        System.out.println("Server Successfully Started");
        ExecutorService pool = Executors.newFixedThreadPool(NUMTHREADS);
        try (ServerSocket server = new ServerSocket(PORT)){
            while(running){
                try{
                    Socket connection = server.accept();
                    System.out.println("Connection Received");
                    Connection newConnection = new Connection(connection);
                    connections.add(newConnection);
                    Callable<Void> task = new ServerTask(dataEvent, newConnection);
                    pool.submit(task);
                } catch (IOException ex) {}
            }
        }catch(IOException ex){
            System.err.println("Couldn't start server, btw Ivan Says hi");
        }
    }

    public void stop(){
        running = false;
    }
}