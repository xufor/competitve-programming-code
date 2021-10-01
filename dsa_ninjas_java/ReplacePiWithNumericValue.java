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
        return replace(s, "", 0);
    }

    public static String replaceWithNoResultString(String s) {
        return replace(s, 0);
    }

    public static void main(String[] args) {
        System.out.println(replace("ab"));
        System.out.println(replace("pi"));
        System.out.println(replace("api"));
        System.out.println(replace("abpi"));
        System.out.println(replace("piab"));
        System.out.println(replace("abpiabpi"));
        System.out.println(replaceWithNoResultString("ab"));
        System.out.println(replaceWithNoResultString("pi"));
        System.out.println(replaceWithNoResultString("api"));
        System.out.println(replaceWithNoResultString("abpi"));
        System.out.println(replaceWithNoResultString("piab"));
        System.out.println(replaceWithNoResultString("abpiabpi"));
    }
}
