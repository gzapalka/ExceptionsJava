public class InheritingMyException {
    public static void f() throws MyException{
        System.out.println("Throw MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throw MyException from g()");
        throw new MyException("inside g()");
    }


    public static void main(String[] args){
        try{
            f();
        }catch(MyException myException){
            myException.printStackTrace();
        }

        try{
            g();
        }catch(MyException myException){
            myException.printStackTrace();
        }finally {
            System.out.println("g() finally block");
        }
    }
}
