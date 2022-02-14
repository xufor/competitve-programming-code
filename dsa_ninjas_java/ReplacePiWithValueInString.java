public class ReplacePiWithValueInString {
    public static String replace(String source, String result, int currentIndex) {
        if (currentIndex >= source.length()) {
            return result;
        } else if (source.charAt(currentIndex) == 'p' && currentIndex != source.length() - 1
                && source.charAt(currentIndex + 1) == 'i') {
            return replace(source, result + "3.14", currentIndex + 2);
        }
        return replace(source, result + source.charAt(currentIndex), currentIndex + 1);
    }

    public static String replace(String source) {
        return replace(source, "", 0);
    }

    public static void main(String[] args) {
        System.out.println(replace("The value of PI is pi"));
        System.out.println(replace("Hellopi!!!"));
        System.out.println(replace("Thelifeof pi"));
        System.out.println(replace("Thelifeof pi "));
        System.out.println(replace("pi rocks"));
        System.out.println(replace("pi"));
        System.out.println(replace("    pi"));
        System.out.println(replace(""));
        System.out.println(replace("popipopipi"));
        System.out.println(replace("ipipipipip"));
    }
}
