import java.util.Arrays;

class ParseStringToIntegerV1 {
    public static int parse(String source, int currentIndex) {
        if (currentIndex == source.length()) {
            return 0;
        }
        return (source.charAt(currentIndex) - '0') * (int) Math.pow(10, source.length() - currentIndex - 1)
                + parse(source, currentIndex + 1);
    }

    public static int parse(String source) {
        return parse(source, 0);
    }
}

class ParseStringToIntegerV2 {
    public static int parse(String source, int currentIndex) {
        // requires 1 less argument to be passed while calling
        if (currentIndex == source.length()) {
            return 0;
        }
        return parse(source, currentIndex + 1)
                + (source.charAt(currentIndex) - '0') * (int) Math.pow(10, source.length() - currentIndex - 1);
    }

    public static int parse(String source) {
        return parse(source, 0);
    }
}

class ParseStringToIntegerV3 {
    public static int parse(String source, int result, int currentIndex) {
        if (currentIndex == source.length()) {
            return result;
        }
        return parse(source, (result * 10) + source.charAt(currentIndex) - '0', currentIndex + 1);
    }

    public static int parse(String source) {
        return parse(source, 0, 0);
    }
}

class Test {
    public static void main(String[] args) {
        String[] testValues = { "78965", "12321", "1221", "1721", "78488487", "7", "" };
        Arrays.stream(testValues).forEach(s -> System.out.println(ParseStringToIntegerV1.parse(s)));
        Arrays.stream(testValues).forEach(s -> System.out.println(ParseStringToIntegerV2.parse(s)));
        Arrays.stream(testValues).forEach(s -> System.out.println(ParseStringToIntegerV3.parse(s)));
    }
}
