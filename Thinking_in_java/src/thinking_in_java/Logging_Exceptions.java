/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");
    
    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class Logging_Exceptions {
    
    public static void main(String[] args){
        try{
            throw new LoggingException();
        } catch(LoggingException e){
            System.err.println("Перехвачено: " + e);
        }
        try{
            throw new LoggingException();
        } catch(LoggingException e){
            System.err.println("Перехвачено: " + e);
        }
    }
    
}
