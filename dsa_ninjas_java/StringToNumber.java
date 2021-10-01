public class StringToNumber {
    public static int stringToNumber(String s, int depth) {
        if (s.equals(""))
            return 0;
        return Integer.parseInt(s.substring(s.length() - 1)) * (int) Math.pow(10, depth)
                + stringToNumber(s.substring(0, s.length() - 1), depth + 1);
    }

    public static int stringToNumber(String s) {
        return stringToNumber(s, 0);
    }

    public static void main(String[] args) {
        System.out.println(stringToNumber("1234") + 1);
    }
}
