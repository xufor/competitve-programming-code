public class Operators {
    public static void main(String args[]) {
        String sp = " ";
        int a = 14, b = 5;
        int c = a / b;
        float d = a / b;
        // int e = (float)a / b; gives type mismatch error
        float e = (float)a / b;
        // float f = 4.9; gives type mismatch error
        float f = 5.96f;
        double g = f / b;
        // float h = g / f; gives type mismatch error
        byte h = 6, i = 8; // byte takes integer literal
        // byte j = h + i; gives type mismatch error
        byte j = (byte)(h + i); // works
        int k = h + i; // works
        // float l = 7.67 + 9.66; gives type mismatch error
        double l = 7.67f + 9.66f;
        float m = (float)7.67d + (float)9.66d; // works
        float n = (float)(7.67d + 9.66d); // works
        double o = 4.48545616516; // if nothing specified, then double literal assumed
        // float p = 2.5f + 9.5d; gives type mismatch error
        double p = 2.558f + 9.601d; // works
        int q = (int)(8.6766d); // works
        byte r = (byte)(7); // works
        byte s = 6; // byte takes integer literal
        // float t = 6.6d; // float does not take dounle literal
        float t = 2.22f;
        long u = 900l;
        // long v = t + u; gives type mismatch error
        float v = t + u; // works
        char z = 'a';
        z++; // increment/decrement does not work on boolean
        t++; // works on float
        System.out.println(a + sp + b + sp + c + sp + d + sp + e);
        System.out.println(f + sp + g + sp + j + sp + k + sp + l);
        System.out.println(m + sp + n + sp + (float)o + sp + o);
        System.out.println(p + sp + q + sp + r + sp + s + sp + v + sp + t);
        System.out.println(z + sp);
    }
}