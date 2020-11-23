import java.io.*; 
import java.util.*;

public class Template {
    static PrintStream cn;
    static Scanner sc;

    public static void setup() {
        try {
            File file = new File("input.txt"); 
            sc = new Scanner(file);
            PrintStream o = new PrintStream(new File("output.txt"));
            System.setOut(o);
            cn = System.out;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Template.setup();
    }
}

