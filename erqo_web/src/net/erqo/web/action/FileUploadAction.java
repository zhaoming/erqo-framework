package net.erqo.web.action;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletContext;

import net.erqo.framework.web.BaseAction;

import org.apache.commons.io.FileUtils;
public class FileUploadAction extends BaseAction {   
    
    private static final long serialVersionUID = -5016873153441103539L;   
       
    private File doc;   
    private String fileName;   
    private String contentType;   
       
    private ServletContext context;   
           
    public void setDoc(File file) {   
        this.doc = file;   
    }   
       
    public void setDocFileName(String fileName) {   
        this.fileName = fileName;   
    }   
       
    public void setDocContentType(String contentType) {   
        this.contentType = contentType;   
    }   
       
    public void setServletContext(ServletContext context) {   
        this.context = context;   
    }   
       
    public String execute() throws Exception {   
        String targetDirectory = context.getRealPath("/upload");   
        logger.error(targetDirectory);
        logger.error(contentType);
        String targetFileName = generateFileName(fileName);   
        File target = new File(targetDirectory, targetFileName);   
        FileUtils.copyFile(doc, target);   
        return SUCCESS;   
    }   
       
    private String generateFileName(String fileName) {   
        DateFormat format = new SimpleDateFormat("yyMMddHHmmss");   
        String formatDate = format.format(new Date());   
        int random = new Random().nextInt(10000);   
        int position = fileName.lastIndexOf(".");   
        String extension = fileName.substring(position);   
        return formatDate + random + extension;   
    }
   
}   
