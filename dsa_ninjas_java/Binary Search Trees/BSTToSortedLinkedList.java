import java.util.LinkedList;

public class BSTToSortedLinkedList {
    public static LinkedList<Integer> convert(BTNode<Integer> root) {
        if(root == null) {
            return new LinkedList<>();
        }

        var leftResult = convert(root.left);
        var rightResult = convert(root.right);
        var nextResult = new LinkedList<Integer>();

        nextResult.addAll(leftResult);
        nextResult.add(root.data);
        nextResult.addAll(rightResult);
        return nextResult;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int data : new Integer[] { 9, 4, 5, 2, 3, 7, 8, 1, 6, 10 })
            binarySearchTree.insert(data);
        System.out.println(convert(binarySearchTree.root));
    }
}
