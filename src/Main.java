import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    nullPointerException();
	indexOutOfBondException();
	whileException();
    }

    private static  void nullPointerException(){
        InheritingSimpleException inheritingSimpleException = null;
        try{
            inheritingSimpleException.f();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    private static void indexOutOfBondException(){
        int[] array= {1,1,1};
        try{
            for(int i =0; i<4; i++) {
                System.out.println(array[i]);
            }
        }catch (ArrayIndexOutOfBoundsException exception){
            exception.printStackTrace(System.out);
        }
    }

    private static void whileException(){
        int[] array= {0,1,2};
        Scanner scanner = new Scanner(System.in);
        int index =0;
        while(true){
            System.out.println("Index: ");
            index = scanner.nextInt();
            try {
                System.out.println(array[index]);
                break;
            }
            catch (IndexOutOfBoundsException e){
               continue;
            }
        }

    }

}
