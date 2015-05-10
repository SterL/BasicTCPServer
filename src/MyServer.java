/**
 * Created by drew on 5/10/15.
 */
public class MyServer implements ServerEvent{
    SterlServer server;
    public MyServer(){
        server = new SterlServer(this, 3000, 50);
        server.start();
    }

    @Override
    public void receive(User u, String s) {
        server.send(u, s);
    }

}
