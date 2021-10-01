public class CheckPalindrome {
    public static String reverse(String s, String r, int current) {
        if(current == s.length()) 
            return r;
        return reverse(s, r + s.charAt(current), current + 1);
    }
    
    public static boolean checkPalindrome(String s) {
        return s.equals(reverse(s, "", 0));
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abccba"));
    }
}
