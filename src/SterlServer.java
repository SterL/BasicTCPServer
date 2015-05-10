import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SterlServer implements DataEvent{
    ArrayList<User> users;
    ServerEvent serverEvent;
    int port;
    int numThreads;
    TCPServer server;

    public SterlServer (ServerEvent se, int port, int numberOfThreads) {
        this.serverEvent = se;
        this.port = port;
        this.numThreads = numberOfThreads;
        users = new ArrayList<User>();
        this.server = new TCPServer(this, port, numberOfThreads, users);

    }


    /**
     *
     */
    public void start(){
        Thread serverThread = new Thread(server);
        serverThread.start();
    }

    /**
     *
     */
    public void stop() {

    }

    /**
     *
     */
    @Override
    public void receiveData (User u, String s) {
        serverEvent.receive(u, s);
    }

    /**
     *
     */
    public void send(User user, String message) {
        try{
            PrintWriter output = new PrintWriter(user.connection.getOutputStream(), true);
            output.println(message);
        } catch(IOException ex){
            System.err.println(ex);
        }
    }

}