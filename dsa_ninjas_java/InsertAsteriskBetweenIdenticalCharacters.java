public class InsertAsteriskBetweenIdenticalCharacters {
    public static String insert(String s, String r, int current) {
        if(current == s.length())
            return r;
        if(current < s.length() - 1 && s.charAt(current) == s.charAt(current + 1))
            return insert(s, r + s.charAt(current) + "*", current + 1);
        return insert(s, r + s.charAt(current), current + 1);       
    }

    public static String insert(String s, int current) {
        if(current == s.length())
            return "";
        if(current < s.length() - 1 && s.charAt(current) == s.charAt(current + 1))
            return s.charAt(current) + "*" + insert(s, current + 1);
        return s.charAt(current) + insert(s, current + 1);       
    }

    public static String insert(String s) {
        if(s.isEmpty())
            return ""; // can also return s here
        if(s.length() > 1 && s.charAt(0) == s.charAt(1))
            return s.charAt(0) + "*" + insert(s.substring(1));
        return s.charAt(0) + insert(s.substring(1));       
    }

    public static String insertWithCurrentAndResultString(String s) {
        return insert(s, "", 0);
    }

    public static String insertWithCurrentButNoResultString(String s) {
        return insert(s, 0);
    }

    public static String insertWithNoCurrentAndResultString(String s) {
        return insert(s);
    }

    public static void main(String[] args) {
        String[] testStrings = { "", "a", "ab", "pp", "app", "llll", "appapp", "llppappxx", "llllxxxx" };
        for(String x: testStrings) {
            System.out.println(insertWithCurrentAndResultString(x));
            System.out.println(insertWithCurrentButNoResultString(x));
            System.out.println(insertWithNoCurrentAndResultString(x));
        }
    }
}
