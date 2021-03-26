import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LogginException");

    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
