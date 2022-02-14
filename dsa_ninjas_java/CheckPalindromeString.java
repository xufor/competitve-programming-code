class CheckPalindromeString {
    public static boolean check(String s, int start, int end) {
        if (start >= end) {
            return true;
        } else if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return check(s, start + 1, end - 1);
    }

    public static boolean check(String s) {
        return check(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(check("78965"));
        System.out.println(check("12321"));
        System.out.println(check("1221"));
        System.out.println(check("1721"));
        System.out.println(check("78488487"));
        System.out.println(check("7"));
        System.out.println(check(""));
    }
}