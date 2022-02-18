import java.util.Arrays;

public class ParseStringToInteger {
    public static int parse(String source, int result, int currentIndex) {
        if (currentIndex == source.length()) {
            return result;
        }
        return parse(source, (result * 10) + source.charAt(currentIndex) - 48, currentIndex + 1);
    }

    public static int parse(String source) {
        return parse(source, 0, 0);
    }

    public static void main(String[] args) {
        String[] testValues = { "78965", "12321", "1221", "1721", "78488487", "7", ""};
        Arrays.stream(testValues).forEach(s -> System.out.println(parse(s)));
    }
}
