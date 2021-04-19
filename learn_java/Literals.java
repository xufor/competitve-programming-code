public class Literals {
    public static void main(String args[]) {
        int i1 = 10; // long, short, int, byte can take integer literals
        int i2 = 0b1010;
        int i3 = 012;
        int i4 = 0xA;
        // int i5 = 250l; gives lossy conversion warning
        long l1 = 999_999_999; // to improve readability, we can use underscore
        // can't use underscore at the end of the value
        // for eg. 999_999_999_ is not valid
        float f1 = 66F;
        float f2 = 66f;
        float f3 = 145_897.6F;
        // can't use underscore before and after decimal
        // for eg. 145_897_._6F is not valid
        // float f3 = 66.89; gives lossy conversion warning
        double d1 = 100.90; // not using D, F, d or f means double literal
        double d2 = 99.06D;
        double d3 = 88.39d;
        char c1 = 'a'; // char will take a single character in ''
        boolean b1 = true;
        System.out.printf("%d %d %d %d %d\n", i1, i2, i3, i4, l1);
        System.out.printf("%o %x \n", i1, i1); 
        // printing octal and hexadecimal equivalents using format specifiers
        System.out.printf("%f %f %f %f\n", f1, f2, f3, d1);
        System.out.printf("%f %f %c %b \n", d2, d3, c1, b1);
    }
}

