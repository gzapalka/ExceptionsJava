package simple;
public class InheritingSimpleException {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingSimpleException sed = new InheritingSimpleException();
        try {
            sed.f();
        } catch (SimpleException simpleException) {
            System.out.println("Caught!");
        }
    }
}
