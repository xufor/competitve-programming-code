import java.util.Arrays;

public class ParseStringToInteger {
    public static int parse(String source, int currentIndex) {
        // requires 1 less argument to be passed while calling
        if (currentIndex == source.length()) {
            return 0;
        }
        return parse(source, currentIndex + 1)
                + (source.charAt(currentIndex) - '0') * (int) Math.pow(10, source.length() - currentIndex - 1);
    }

    public static int parse(String source, int result, int currentIndex) {
        if (currentIndex == source.length()) {
            return result;
        }
        return parse(source, (result * 10) + source.charAt(currentIndex) - '0', currentIndex + 1);
    }

    public static int parsev1(String source) {
        return parse(source, 0, 0);
    }

    public static int parsev2(String source) {
        return parse(source, 0);
    }

    public static void main(String[] args) {
        String[] testValues = { "78965", "12321", "1221", "1721", "78488487", "7", "" };
        Arrays.stream(testValues).forEach(s -> System.out.println(parsev1(s)));
        Arrays.stream(testValues).forEach(s -> System.out.println(parsev2(s)));
    }
}
