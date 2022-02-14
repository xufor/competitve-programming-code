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
        System.out.println(parse("78965"));
        System.out.println(parse("12321"));
        System.out.println(parse("1221"));
        System.out.println(parse("1721"));
        System.out.println(parse("78488487"));
        System.out.println(parse("7"));
        System.out.println(parse(""));
    }
}
