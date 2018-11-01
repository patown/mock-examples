package demo.org.powermock.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo  {

    private static final Logger logger = LoggerFactory.getLogger(LoggerDemo.class);


    public int toInt(String string) {
    	int result=0; 
    	logger.info("String::"+string);
       try {
    	 result =Integer.parseInt(string);
    	   if(logger.isDebugEnabled()) {
    	  logger.debug(string +" parsed to " + result);
      }   	
       } catch(NumberFormatException e) {
    	   logger.error("pareInt failed");
       }
       return result;
    }
}