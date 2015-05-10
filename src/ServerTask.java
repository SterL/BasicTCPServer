import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class ServerTask implements Callable<Void> {

    BufferedReader input;
    User user;
    Boolean running = true;
    DataEvent dataEvent;

    public ServerTask(DataEvent de, User u){
        this.user = u;
        this.dataEvent = de;
    }

    @Override
    public Void call() throws Exception {
        try{
            input = new BufferedReader(new InputStreamReader(user.connection.getInputStream()));
        while(running){
            String msg = input.readLine();

            if(msg != null){
                dataEvent.receiveData(user, msg);
            }
        }
        } catch (IOException ex){
            System.err.println(ex);
        }
        return null;
    }
}
