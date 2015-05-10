import java.net.Socket;

/**
 * Created by drew on 5/10/15.
 */
public class User {
    Socket connection;
    public User(Socket connection){
        this.connection = connection;
    }
}
