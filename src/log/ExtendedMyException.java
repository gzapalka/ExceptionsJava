package log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ExtendedMyException extends Exception{
    private int x;
    public ExtendedMyException(){}
    public ExtendedMyException(String errorMessage){
        super(errorMessage);
    }
    public ExtendedMyException(String errorMessage, int x){
        super(errorMessage);
        this.x = x;
    }

    @Override
    public String getMessage(){
        return "Error Message: "+x+" "+super.getMessage();
    }

    public static void main(String[] args) throws ExtendedMyException {
        try{
            throw new ExtendedMyException("Message", 47);
        }catch(ExtendedMyException e){
            Logger logger = Logger.getLogger("ExtendedMyException");
            StringWriter trace = new StringWriter();
            e.printStackTrace(new PrintWriter(trace));
            logger.severe(trace.toString());
        }
    }

}
