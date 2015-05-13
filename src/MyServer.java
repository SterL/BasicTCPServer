import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by drew on 5/10/15.
 */
public class MyServer implements ServerEvent{
    BasicTCPServer s;

    public MyServer(){
        s = new BasicTCPServer(this, 3000, 50);
        s.start();
    }
    @Override
    public void receive(Connection u, String string) {
        if(string.contains("PrintDate")){
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("en", "EN"));
            s.send(u, df.format (new Date ()));
        }
    }
}
