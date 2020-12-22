import java.util.*;

public class Template {
    static Scanner sc;

    public static void setup() throws Exception {
        File file = new File("input.txt");
        sc = new Scanner(file);
        PrintStream o = new PrintStream(new File("output.txt"));
        System.setOut(o);
    }
    public static void main(String args[]) {
        Template.setup();
        int ntc = sc.nextInt();
        while(ntc--) {
            
        }
    }
}