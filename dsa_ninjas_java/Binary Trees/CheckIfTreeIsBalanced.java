class Data {
    public int height;
    public boolean balanced;

    Data(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

public class CheckIfTreeIsBalanced {
    public static Data isBalanced(BTNode<Integer> root) {
        if (root == null) {
            return new Data(0, true);
        }
        Data leftResult = isBalanced(root.left);
        Data rightResult = isBalanced(root.right);
        return new Data(1 + Math.max(rightResult.height, leftResult.height),
                leftResult.balanced && rightResult.balanced && Math.abs(leftResult.height - rightResult.height) < 2);
    }

    public static void main(String[] args) {
        // 1 2 4 10 -1 -1 6 7 -1 -1 9 -1 -1 -1 3 -1 11 12 -1 13 -1 -1 -1
        // 1 2 -1 -1 3 -1 -1
        BinaryTree<Integer> binaryTree = BinaryTree.construct();
        System.out.println(isBalanced(binaryTree.root).balanced);
    }
}
