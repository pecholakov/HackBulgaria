package exam1;

public class Logger {

    public Logger() {
        this.setLevel(DEFAULT_LEVEL);
    }

    public Logger(int level) {
        this.setLevel(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws NumberFormatException {
        if (level < 1) {
            throw new NumberFormatException();
        } else {
            this.level = level;
        }
    }

    public void log(int level, String message) throws NumberFormatException {
        if (level < 1) {
            throw new NumberFormatException();
        } else {
            if (this.level >= level) {
                System.out.println(message);
            }
        }
    }

    public void log(String message) {
        if (this.level >= DEFAULT_LEVEL) {
            System.out.println(message);
        }
    }

    protected int level;
    final protected int DEFAULT_LEVEL = 3;

}
