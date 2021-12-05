public class PrintAllSubsequencesOfAString {
    public static void print(String s, String r) {
        if(s.isEmpty()) {
            System.out.println(r);
            return;
        }
        print(s.substring(1), r);
        print(s.substring(1), r + s.charAt(0));
    }

    public static void print(String s) {
        print(s, "");
    }

    public static void main(String args[]) {
        print("xyz");
    }
}