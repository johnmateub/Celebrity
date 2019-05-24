package co.mateusbello.exception;

public class ResourceException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3697614696714928189L;
    
    public ResourceException() {
        super();
    }
    
    public ResourceException (String message) {
        super(message);
    }
    
    public ResourceException (String message, Exception e) {
        super(message, e);
    }

}
