class CheckValidBSTData {
    public int min;
    public int max;
    public boolean isValid;

    public CheckValidBSTData() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.isValid = true;
    }

    public CheckValidBSTData(int min, int max, boolean isValid) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}

public class CheckValidBST {
    public static CheckValidBSTData check(BTNode<Integer> root) {
        if (root == null)
            return new CheckValidBSTData();

        CheckValidBSTData leftResult = check(root.left);
        CheckValidBSTData rightResult = check(root.right);

        int nextMinValue = Math.min(leftResult.min, root.data);
        int nextMaxValue = Math.max(rightResult.max, root.data);

        boolean nextIsValid = leftResult.isValid && rightResult.isValid &&
                root.data > leftResult.max && root.data < rightResult.min;

        return new CheckValidBSTData(nextMinValue, nextMaxValue, nextIsValid);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int data : new Integer[] { 9, 4, 5, 2, 3, 7, 8, 1, 6, 10 })
            binarySearchTree.insert(data);
        System.out.println(check(binarySearchTree.root).isValid);

        var falseBinarySearchTree = new BinarySearchTree();
        falseBinarySearchTree.root = new BTNode<Integer>(6);
        falseBinarySearchTree.root.left = new BTNode<Integer>(9);
        falseBinarySearchTree.root.right = new BTNode<Integer>(10);
        System.out.println(check(falseBinarySearchTree.root).isValid);

        falseBinarySearchTree.root.left = new BTNode<Integer>(3);
        System.out.println(check(falseBinarySearchTree.root).isValid);
    }
}