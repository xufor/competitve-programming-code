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
        return insert(s, "", 0);
    }

    public static String insertWithNoResultString(String s) {
        return insert(s, 0);
    }

    public static void main(String[] args) {
        System.out.println(insert(""));
        System.out.println(insert("a"));
        System.out.println(insert("ab"));
        System.out.println(insert("pp"));
        System.out.println(insert("app"));
        System.out.println(insert("apap"));
        System.out.println(insert("llll"));
        System.out.println(insert("appapp"));
        System.out.println(insert("llppappxx"));
        System.out.println(insert("llllxxxx"));
        System.out.println(insertWithNoResultString(""));
        System.out.println(insertWithNoResultString("a"));
        System.out.println(insertWithNoResultString("ab"));
        System.out.println(insertWithNoResultString("pp"));
        System.out.println(insertWithNoResultString("app"));
        System.out.println(insertWithNoResultString("apap"));
        System.out.println(insertWithNoResultString("llll"));
        System.out.println(insertWithNoResultString("appapp"));
        System.out.println(insertWithNoResultString("llppappxx"));
        System.out.println(insertWithNoResultString("llllxxxx"));
    }
}
