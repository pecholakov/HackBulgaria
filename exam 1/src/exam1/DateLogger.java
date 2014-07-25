package exam1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLogger extends Logger {

    public DateLogger() {
        super();
    }

    public DateLogger(int level) {
        super(level);
    }
    
    @Override
    protected void print(final int messageLevel, final String message){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        String date = dateFormat.format(new Date());
        System.out.print(String.format("|%s| ", date));
        super.print(messageLevel, message);
    }
}
