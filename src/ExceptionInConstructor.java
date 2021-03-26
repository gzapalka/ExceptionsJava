import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionInConstructor {
    private BufferedReader in;
    public ExceptionInConstructor(String fileName) throws Exception{
        try {
            in = new BufferedReader(new FileReader(fileName));
        }catch(FileNotFoundException e){
            System.out.println("Cannot open file: "+fileName);
            throw e;
        }catch(Exception e){
            try{
                in.close();
            }catch(IOException ioException){
                System.out.println("Cannot close file: "+fileName);
            }
            throw e;
        }finally {
            System.out.println(in);
        }
    }

    public String getLine(){
        String s;
        try{
            s=in.readLine();
        }catch (IOException e){
            throw new RuntimeException("Cannot read line");
        }
        return s;
    }

    public void dispose(){
        try{
            in.close();
        }catch(IOException e){
            System.out.println("Cannot dispose");
            throw new RuntimeException("Cannot close file");
        }
    }

    public static void main(String[] args) {
        try {
            ExceptionInConstructor exception = new ExceptionInConstructor("./file.txt");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
