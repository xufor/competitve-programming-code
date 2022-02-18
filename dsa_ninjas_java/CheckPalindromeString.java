import java.util.Arrays;

class CheckPalindromeString {
    public static boolean check(String s, int start, int end) {
        if (start >= end) {
            return true;
        } else if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return check(s, start + 1, end - 1);
    }

    public static boolean check(String s) {
        return check(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        String[] testValues = { "78965", "12321", "1221", "1721", "78488487", "7", ""};
        Arrays.stream(testValues).forEach(s -> System.out.println(check(s)));
    }
}