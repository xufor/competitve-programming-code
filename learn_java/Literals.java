public class Literals {
    public static void main(String args[]) {
        long i1 = 55; // long, short, int, byte can take integer literals
        float f1 = 66F;
        float f2 = 66f;
        // float f3 = 66.89; gives lossy conversion warning
        double d1 = 100.90; // not using D, F, d or f means double literal
        double d2 = 99.06D;
        double d3 = 88.39d;
        char c1 = 'a'; // char will take a single character in ''
        boolean b1 = true;
        System.out.printf("%d %f %f %f %f %f %c %b", i1, f1, f2, d1, d2, d3, c1, b1);
    }
}

