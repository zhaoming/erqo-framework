package net.erqo.framework.exception;

public class FrameworkException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2853396857102677208L;
	private Exception exception;
	
	public FrameworkException(String errorCode){
		this(errorCode,null);
	}
	
	public FrameworkException(String errorCode,Exception exception){
		super(errorCode, exception);
		this.exception = exception ;
	}
	
    public Exception getRootCause() {
        if (exception instanceof FrameworkException) {
            return ((FrameworkException) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    public String toString() {
        if (exception instanceof FrameworkException) {
            return ((FrameworkException) exception).toString();
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
