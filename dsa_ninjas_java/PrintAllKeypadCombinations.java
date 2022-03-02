import java.util.HashMap;

class PrintAllKeypadCombinations {
    public static HashMap<Integer, String[]> keyCharacters;

    static {
        keyCharacters = new HashMap<>();
        keyCharacters.put(2, new String[] { "a", "b", "c" });
        keyCharacters.put(3, new String[] { "d", "e", "f" });
        keyCharacters.put(4, new String[] { "g", "h", "i" });
        keyCharacters.put(5, new String[] { "j", "k", "l" });
        keyCharacters.put(6, new String[] { "m", "n", "o" });
        keyCharacters.put(7, new String[] { "p", "q", "r", "s" });
        keyCharacters.put(8, new String[] { "t", "u", "v" });
        keyCharacters.put(9, new String[] { "w", "x", "y", "z" });
    }

    public static void keypadCombinations(String source, String result) {
        if (source.length() == 0) {
            System.out.println(result);
            return;
        }
        for (String character : keyCharacters.get(source.charAt(0) - '0')) {
            keypadCombinations(source.substring(1), result + character);
        }
    }

    public static void keypadCombinations(String targetString) {
        keypadCombinations(targetString, "");
    }

    public static void main(String[] args) {
        keypadCombinations("234");
    }
}
