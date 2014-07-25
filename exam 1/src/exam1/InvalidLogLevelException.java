package exam1;

public class InvalidLogLevelException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public InvalidLogLevelException(int level){
        super("Invalid level given! Level should be higher than 0, given " + level);
    }
}
