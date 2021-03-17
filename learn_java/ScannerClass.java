import java.util.*;

public class ScannerClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next(); // reads one word, stops if space encountered
        System.out.println(string);
        String line = sc.nextLine(); // reads multiple words, does ot stop at spaces
        System.out.println(line);
        int number = sc.nextInt(); // nextFloat(), nextDouble()
        System.out.println(number);
        // nextBoolean(), nextByte(), nextLong(), nextShort()
        System.out.println("Enter an integer.");
        boolean result = sc.hasNextInt();
        if(result == true) {
            System.out.println("It is an integer.");
            number = sc.nextInt();
            System.out.println(number);
        }
        else {
            System.out.println("Not an integer.");
        }
        sc.useRadix(2); // now you can only enter values with base 2 for e.g. 1010
        number = sc.nextInt(); // the value that will get store against 1010 will be 10
        System.out.println(number);
        sc.close();
    }
}