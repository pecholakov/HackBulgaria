package exam1;

public class Logger {

    public Logger() {
        this.setLevel(DEFAULT_LEVEL);
    }

    public Logger(int level) {
        this.setLevel(level);
    }

    public int getLevel() {
        return logLevel;
    }

    public void setLevel(int level) {
        validateLevel(level);
        this.logLevel = level;
    }

    public void log(int messageLevel, String message) {
        validateLevel(messageLevel);
        if (this.logLevel >= messageLevel) {
            print(messageLevel, message);
        }
    }

    public void log(String message) {
        if (this.logLevel >= DEFAULT_LEVEL) {
           print(logLevel, message);
        }
    }
    
    protected void print (int messageLevel, String message){
        System.out.println(messageLevel + " => " + message);
    }
    
    private void validateLevel(int messageLevel) {
        if (messageLevel <= 0) {
            throw new InvalidLogLevelException(messageLevel);
        }
    }
    
    protected int logLevel;
    final protected int DEFAULT_LEVEL = 3;

}
