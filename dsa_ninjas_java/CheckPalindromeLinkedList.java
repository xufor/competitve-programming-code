import java.util.Arrays;

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
        LinkedList<Integer> linkedList = new LinkedList<>();
        Arrays.stream(new Integer[] { 3, 2, 1, 2, 3 }).forEach(i -> linkedList.addLast(i));
        System.out.println(palindrome(linkedList));
    }
}
