package rethrowing;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class StackTrace {
    static Logger logger = Logger.getLogger("Stack Trace");

    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    static void f() throws NullPointerException{
        try{
            throw new NullPointerException();
        }catch (Exception e){
            logException(e);
            for(StackTraceElement ste: e.getStackTrace()){
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g(){
        f();
    }

    static void h(){
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("_________________");
        g();
        System.out.println("_________________");
        h();
        System.out.println("_________________");
    }

}
