package log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class LoggingExceptionServiceByClient{
    private static Logger logger = Logger.getLogger("Logging exception client");

    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) throws NullPointerException {
        try{
            throw new ExtendedMyException("error", 10);
        }catch(Exception e){
            logException(e);
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
