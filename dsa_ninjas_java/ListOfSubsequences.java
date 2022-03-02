import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ListOfSubsequences {
    public static LinkedList<String> subsequences(String targetString) {
        if (targetString.isEmpty()) {
            return new LinkedList<String>(Arrays.asList(new String[] { "" }));
        }
        LinkedList<String> result = subsequences(targetString.substring(1));
        result.addAll(result.stream().map(s -> targetString.charAt(0) + s).collect(Collectors.toList()));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsequences("xyz"));
    }
}