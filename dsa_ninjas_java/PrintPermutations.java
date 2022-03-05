public class PrintPermutations {
    public static void permutations(String source, String result) {
        if (source.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < source.length(); i++) {
            permutations(source.substring(0, i) + source.substring(i + 1), result + source.charAt(i));
        }
    }

    public static void permutations(String targetString) {
        permutations(targetString, "");
    }

    public static void main(String[] args) {
        permutations("abc");
    }
}
