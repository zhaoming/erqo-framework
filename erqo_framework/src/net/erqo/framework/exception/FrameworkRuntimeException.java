package net.erqo.framework.exception;

public class FrameworkRuntimeException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4643527836201066025L;
	/**
	 * 
	 */
	private Exception exception;
	
	public FrameworkRuntimeException(String errorCode){
		this(errorCode , null);
	}
	
	public FrameworkRuntimeException(String errorCode,Exception exception){
		super(errorCode,exception);
		this.exception = exception;
	}
	
    public Exception getRootCause() {
        if (exception instanceof FrameworkRuntimeException) {
            return ((FrameworkRuntimeException) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    public String toString() {
        if (exception instanceof FrameworkRuntimeException) {
            return ((FrameworkRuntimeException) exception).toString();
        }
        if (exception == null) {
            return super.toString();
        } else {
            return exception.toString();
        }
    }
    
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return this.getMessage();
	}
}
