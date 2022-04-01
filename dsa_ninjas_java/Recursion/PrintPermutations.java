class PrintPermutationsV1 {
    public static void permutations(String source, String result) {
        if (source.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < source.length(); i++) {
            permutations(source.substring(0, i) + source.substring(i + 1), result + source.charAt(i));
        }
    }

    public static void permutations(String targetString) {
        permutations(targetString, "");
    }
}

class PrintPermutationsV2 {
    public static void swap(StringBuilder targetString, int index1, int index2) {
        char temp = targetString.charAt(index1);
        targetString.setCharAt(index1, targetString.charAt(index2));
        targetString.setCharAt(index2, temp);
    }

    public static void permutations(StringBuilder source, int currentIndex) {
        if (source.length() == currentIndex) {
            System.out.println(source);
            return;
        }
        for (int i = currentIndex; i < source.length(); i++) {
            swap(source, currentIndex, i);
            permutations(source, currentIndex + 1);
            swap(source, currentIndex, i);
        }
    }

    public static void permutations(String targetString) {
        permutations(new StringBuilder(targetString), 0);
    }
}

class Main {
    public static void main(String[] args) {
        PrintPermutationsV1.permutations("abc");
        System.out.println();
        PrintPermutationsV2.permutations("abc");
    }
}
