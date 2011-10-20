package net.erqo.framework.model;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5901306840727698575L;
	
	protected final Log logger = LogFactory.getLog(getClass());

    public abstract String toString();

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}

