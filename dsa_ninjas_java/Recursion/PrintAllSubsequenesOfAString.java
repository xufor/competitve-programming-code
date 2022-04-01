public class PrintAllSubsequenesOfAString {
    public static void subsequences(String source, String result) {
        if (source.isEmpty()) {
            System.out.println(result);
            return;
        }
        subsequences(source.substring(1), result);
        subsequences(source.substring(1), result + source.charAt(0));
    }

    public static void subsequences(String targetString) {
        subsequences(targetString, "");
    }

    public static void main(String[] args) {
        subsequences("xyz");
    }
}
