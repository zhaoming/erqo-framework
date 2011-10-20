package net.erqo.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.erqo.framework.web.BaseAction;

public class XmlOutAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1476647471645404677L;
	
	private InputStream xmlStream;

	public InputStream getXmlStream() {
		return xmlStream;
	}

	public void setXmlStream(InputStream xmlStream) {
		this.xmlStream = xmlStream;
	}
	
	public String execute(){
        StringBuffer excelBuf = new StringBuffer();
        excelBuf.append("BookName").append("\t").append("Year").append("\t").append("author").append("\n");
        excelBuf.append("Thinking in Java").append("\t").append("2001").append("\t").append("Eckel").append("\n");
        excelBuf.append("Spring in action").append("\t").append("2005").append("\t").append("Rod").append("\n");
        String excelString = excelBuf.toString();
        
        xmlStream = new ByteArrayInputStream(excelString.getBytes(),0,excelString.length());
        
		return SUCCESS;
	}
	

}
