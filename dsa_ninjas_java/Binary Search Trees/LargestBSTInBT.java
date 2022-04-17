import java.util.Scanner;

class BinaryTree<T> {
    public BTNode<T> root;
    public static Scanner scnr = new Scanner(System.in);

    public static BTNode<Integer> contructBinaryTreeRecursively() {
        Integer data = scnr.nextInt();
        if (data == -1)
            return null;
        BTNode<Integer> root = new BTNode<Integer>(data);
        root.left = contructBinaryTreeRecursively();
        root.right = contructBinaryTreeRecursively();
        return root;
    }

    public static BinaryTree<Integer> construct() {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.root = contructBinaryTreeRecursively();
        return binaryTree;
    }
}

class LargestBSTInBTData {
    public int min;
    public int max;
    public Boolean isValid;
    public int largestBSTHeight;

    public LargestBSTInBTData() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.isValid = true;
        this.largestBSTHeight = -1;
    }

    public LargestBSTInBTData(int min, int max, boolean isValid, int largestBSTHeight) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
        this.largestBSTHeight = largestBSTHeight;
    }
}

public class LargestBSTInBT {
    public static LargestBSTInBTData find(BTNode<Integer> root) {
        if (root == null)
            return new LargestBSTInBTData();
        
        LargestBSTInBTData leftResult = find(root.left);
        LargestBSTInBTData rightResult = find(root.right);

        int nextMinValue = Math.min(root.data, Math.min(leftResult.min, rightResult.min));
        int nextMaxValue = Math.max(root.data, Math.max(leftResult.max, rightResult.max));

        boolean nextIsValid = leftResult.isValid && rightResult.isValid &&
                root.data > leftResult.max && root.data < rightResult.min;

        
        int nextLargestBSTHeight = (nextIsValid ? 1 : 0) + Math.max(leftResult.largestBSTHeight, rightResult.largestBSTHeight);
            
        return new LargestBSTInBTData(nextMinValue, nextMaxValue, nextIsValid, nextLargestBSTHeight);
    }

    public static void main(String[] args) {
        // 1 2 4 3 -1 -1 8 7 -1 -1 9 -1 -1 -1 3 -1 11 12 -1 13 -1 -1 -1
        //                1
        //               / \
        //              2   3
        //             /     \
        //            4       11  
        //           / \     /
        //          3   8   12
        //             / \    \
        //            7   9    13
        BinaryTree<Integer> binaryTree = BinaryTree.construct();
        System.out.println(find(binaryTree.root).largestBSTHeight);
    }
}
