import java.util.Arrays;

public class ReverseString {
    public static String reverse(String target, int currentIndex) {
        if (currentIndex == target.length()) {
            return "";
        }
        return reverse(target, currentIndex + 1) + target.charAt(currentIndex);
    }

    public static String reverse(String target) {
        return reverse(target, 0);
    }

    public static void main(String[] args) {
        String[] testValues = { "abcd", "abcde", "", "a" };
        Arrays.stream(testValues).forEach(s -> System.out.println(reverse(s)));
    }
}
