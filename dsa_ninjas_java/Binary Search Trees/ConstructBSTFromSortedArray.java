public class ConstructBSTFromSortedArray extends PrintSearchInsertDeleteBST {
    public static BSTNode<Integer> construct(int[] input, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        var root = new BSTNode<>(input[mid]);
        root.left = construct(input, start, mid - 1);
        root.right = construct(input, mid + 1, end);
        return root;
    }

    public static BSTNode<Integer> construct(int[] input) {
        return construct(input, 0, input.length - 1);
    }

    public static void main(String[] args) {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.root = construct(new int[] { 1, 2, 3, 4, 5, 6 });
        binarySearchTree.printInOrder();
    }
}