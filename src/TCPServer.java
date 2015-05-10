import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class TCPServer implements Runnable{
    DataEvent dataEvent;
    public static int PORT;
    public static int NUMTHREADS;
    ArrayList<User> users;
    public TCPServer(DataEvent de, int port, int numThreads, ArrayList<User> u){
        this.dataEvent = de;
        this.PORT = port;
        this.NUMTHREADS = numThreads;
        users = u;
    }

    public void run(){
        System.out.println("Server Successfully Started");
        ExecutorService pool = Executors.newFixedThreadPool(NUMTHREADS);
        try (ServerSocket server = new ServerSocket(PORT)){
            while(true){
                try{
                    Socket connection = server.accept();
                    System.out.println("Connection Received");
                    User newUser = new User(connection);
                    users.add(newUser);
                    Callable<Void> task = new ServerTask(dataEvent, newUser);
                    pool.submit(task);
                } catch (IOException ex) {}
            }
        }catch(IOException ex){
            System.err.println("Couldn't start server");
        }
    }
}