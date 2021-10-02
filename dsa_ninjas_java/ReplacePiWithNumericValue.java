public class ReplacePiWithNumericValue {
    public static String replace(String s, String r, int current) {
        if(s.length() == current)
            return r;
        if(s.charAt(current) == 'p' && current < s.length() - 1 && s.charAt(current + 1) == 'i')
            return replace(s, r + "3.14", current + 2);
        return replace(s, r + s.charAt(current), current + 1);       
    }

    public static String replace(String s, int current) {
        if(s.length() == current)
            return "";
        if(s.charAt(current) == 'p' && current < s.length() - 1 && s.charAt(current + 1) == 'i')
            return "3.14" + replace(s, current + 2);
        return s.charAt(current) + replace(s, current + 1);       
    }

    public static String replace(String s) {
        if(s.isEmpty())
            return ""; // can also return s here
        if(s.length() > 1 && s.startsWith("pi"))
            return "3.14" + replace(s.substring(2));
        return s.charAt(0) + replace(s.substring(1));       
    }

    public static String replaceWithCurrentAndResultString(String s) {
        return replace(s, "", 0);
    }

    public static String replaceWithCurrentButNoResultString(String s) {
        return replace(s, 0);
    }

    public static String replaceWithNoCurrentAndResultString(String s) {
        return replace(s);
    }

    public static void main(String[] args) {
        String testStrings[] = { "", "a", "ab", "pi", "abpi", "piab", "abpiabpi" };
        for(String s: testStrings) {
            System.out.println(replaceWithCurrentAndResultString(s));
            System.out.println(replaceWithCurrentButNoResultString(s));
            System.out.println(replaceWithNoCurrentAndResultString(s));
        }
    }
}
