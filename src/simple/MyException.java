package simple;

public class MyException extends Exception{
    public MyException(){ }
    public MyException(String errorMessage){
        super(errorMessage);
    }
}
