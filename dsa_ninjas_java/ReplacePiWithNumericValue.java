public class ReplacePiWithNumericValue {
    public static String replacePiWithNumericValue(String s, String r, int current) {
        if(s.length() == current)
            return r;
        if(s.charAt(current) == 'p' && current < s.length() - 1 && s.charAt(current + 1) == 'i')
            return replacePiWithNumericValue(s, r + "3.14", current + 2);
        return replacePiWithNumericValue(s, r + s.charAt(current), current + 1);       
    }

    public static String replacePiWithNumericValue(String s) {
        return replacePiWithNumericValue(s, "", 0);
    }

    public static void main(String[] args) {
        System.out.println(replacePiWithNumericValue("ab"));
        System.out.println(replacePiWithNumericValue("pi"));
        System.out.println(replacePiWithNumericValue("api"));
        System.out.println(replacePiWithNumericValue("abpi"));
        System.out.println(replacePiWithNumericValue("piab"));
        System.out.println(replacePiWithNumericValue("abpiabpi"));
    }
}
