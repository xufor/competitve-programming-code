// Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string. 
// Write a program to return the list of all possible codes that can be generated from the given string.
// Sample Input:
//     1123
// Sample Output:
//     aabc
//     kbc
//     alc
//     aaw
//     kw

public class PrintAllCodes {
    public static void codes(String source, String result) {
        if (source.isEmpty()) {
            System.out.println(result);
            return;
        }
        // we can now consume either one or two digits
        if (source.length() >= 2 && Integer.parseInt(source.substring(0, 2)) <= 26) {
            codes(source.substring(2), result + (char) (Integer.parseInt(source.substring(0, 2)) + 96));
        }
        codes(source.substring(1), result + (char) (source.charAt(0) - '0' + 96));
    }

    public static void codes(String targetString) {
        codes(targetString, "");
    }

    public static void main(String[] args) {
        codes("1123");
        codes("");
        codes("1");
    }
}