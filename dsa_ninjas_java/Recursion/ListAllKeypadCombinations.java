import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

class ListAllKeypadCombinations {
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

    public static LinkedList<String> keypadCombinations(String targetString) {
        if (targetString.length() == 0) {
            return new LinkedList<String>(Arrays.asList(new String[] { "" }));
        }
        LinkedList<String> oldResult = keypadCombinations(targetString.substring(1));
        LinkedList<String> newResult = new LinkedList<String>();
        for (String character : keyCharacters.get(targetString.charAt(0) - '0')) {
            newResult.addAll(oldResult.stream().map(oldResultString -> character + oldResultString).collect(Collectors.toList()));
        }
        return newResult;
    }

    public static void main(String[] args) {
        System.out.println(keypadCombinations("2"));
    }
}