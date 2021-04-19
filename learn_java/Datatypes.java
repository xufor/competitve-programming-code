public class Datatypes {
    public static void main(String args[]) {
        int v1 = 15;
        // byte-1, short-2, int-4, long-8
        // all have default value zero
        float v2 = 15.55f; // by default 15.55 means double
        // float-4, double-8
        // default values are 0.0f and 0.0d respectively
        char v3 = 'a';
        // default value of char-2 is \u0000
        boolean v4 = true;
        // default value of boolean is false, exact size taken depends on jvm
        // note that in java boolean can only take true or false, 0 and 1 are invalid
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        // Integer class has data data members BYTES, MAX_VALUE, MIN_VALUE 
        System.out.println(Integer.BYTES);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // predefined functions in Integer class to change base of an integer number
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(-31));
        System.out.println(Integer.toOctalString(31));
        System.out.println(Integer.toHexString(31));
    }
}
