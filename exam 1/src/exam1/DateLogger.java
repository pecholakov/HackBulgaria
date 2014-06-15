package exam1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLogger extends Logger {

    public DateLogger() {
        super();
    }

    public DateLogger(int level) {
        super(level);
    }
    

    @Override
    public void log(int level, String message) {

        if (this.level >= level) {
            System.out.println(formatedOutput(level, message));
        }
    }
    
    @Override
    public void log(String message){
        if (this.level >= DEFAULT_LEVEL) {
            System.out.println(formatedOutput(DEFAULT_LEVEL, message));
        }
    }
    
    private StringBuilder formatedOutput(final int level, final String message){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();
        StringBuilder output = new StringBuilder();
        output.append(String.format("|%s|", dateFormat.format(cal.getTime())));
        output.append(String.format("%s => %s", level, message));
        
        return output;
    }
}
