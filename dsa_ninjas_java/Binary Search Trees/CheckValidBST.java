class CheckValidBSTData {
    public Integer min;
    public Integer max;
    public Boolean isValid;

    public CheckValidBSTData() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.isValid = true;
    }

    public CheckValidBSTData(Integer min, Integer max, Boolean isValid) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}

public class CheckValidBST {
    public static CheckValidBSTData check(BSTNode<Integer> root) {
        if (root == null)
            return new CheckValidBSTData();
        CheckValidBSTData leftResult = check(root.left);
        CheckValidBSTData rightResult = check(root.right);
        Integer nextMinValue = Math.min(leftResult.min, root.data);
        Integer nextMaxValue = Math.max(rightResult.max, root.data);
        Boolean nextIsValid = leftResult.isValid && rightResult.isValid &&
                root.data > leftResult.max && root.data < rightResult.min;
        return new CheckValidBSTData(nextMinValue, nextMaxValue, nextIsValid);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int data : new Integer[] { 9, 4, 5, 2, 3, 7, 8, 1, 6, 10 })
            binarySearchTree.insert(data);
        System.out.println(check(binarySearchTree.root).isValid);

        var falseBinarySearchTree = new BinarySearchTree();
        falseBinarySearchTree.root = new BSTNode<Integer>(6);
        falseBinarySearchTree.root.left = new BSTNode<Integer>(9);
        falseBinarySearchTree.root.right = new BSTNode<Integer>(10);
        System.out.println(check(falseBinarySearchTree.root).isValid);

        falseBinarySearchTree.root.left = new BSTNode<Integer>(3);
        System.out.println(check(falseBinarySearchTree.root).isValid);
    }
}