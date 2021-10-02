public class TowerOfHanoi {
    public static void tower(int n, String srce, String aux, String dest) {
        if(n == 1) {
            System.out.println(srce + " " + dest);
            return;
        }
        tower(n-1, srce, dest, aux);
        System.out.println(srce + " " + dest);
        tower(n-1, aux, srce, dest);
    }
    // n means number of discs to work upon
    // t1, t2, t3 hold tower names
    public static void main(String args[]) {
        tower(2, "a", "b", "c");
    }
}