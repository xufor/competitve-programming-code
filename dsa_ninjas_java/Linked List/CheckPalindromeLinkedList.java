public class CheckPalindromeLinkedList {
    public static Node<Integer> palindrome(Node<Integer> left, Node<Integer> right) {
        if (right == null)
            return left;
        left = palindrome(left, right.next);
        if (left.data == right.data)
            return left.next;
        else
            return left;
    }

    public static boolean palindrome(LinkedList<Integer> linkedList) {
        return palindrome(linkedList.head, linkedList.head) == null;
    }

    public static void main(String[] args) {
        Integer[][] testCases = {
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 3 },
                { 3, 2, 2 },
                { 2, 2 },
                { 2 },
                {}
        };
        for (Integer[] test : testCases) {
            System.out.println(palindrome(LinkedList.contruct(test)));
        }
    }
}
