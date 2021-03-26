package rethrowing;

public class ReThrowing {
    public static void f() throws Exception{
        System.out.println("Exception in f()");
        throw new Exception("At f()");
    }

    public static void g() throws Exception{
        try{
            f();
        }catch(Exception e){
            System.out.println("At g() ");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception{
        try{
            f();
        }catch(Exception e){
            System.out.println("At h() ");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace(); //new place of exception origin
        }
    }

    public static void main(String[] args) {
        try{
            g();
        }catch(Exception e){
            System.out.println("At main: ");
            e.printStackTrace();
        }

        try{
            h();
        }catch(Exception e){
            System.out.println("At main: ");
            e.printStackTrace();
        }
        }

}
