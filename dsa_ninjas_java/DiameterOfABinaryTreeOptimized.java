public class DiameterOfABinaryTreeOptimized {
    public static int[] diameter(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new int[] { 0, 0 }; // { height, diameter }
        int[] leftResult = diameter(root.left);
        int[] rightResult = diameter(root.right);
        int currentHeight = 1 + Math.max(leftResult[0], rightResult[0]);
        int currentDiameter = Math.max(Math.max(leftResult[0] + rightResult[0], leftResult[1]), rightResult[1]);
        return new int[] { currentHeight, currentDiameter };
    }

    public static void main(String[] args) {
        // 1 2 4 10 -1 -1 6 7 -1 -1 9 -1 -1 -1 3 -1 11 12 -1 13 -1 -1 -1
        //                1
        //               / \
        //              2   3
        //             /     \
        //            4       11  
        //           / \     /
        //         10   6   12
        //             / \    \
        //            7   9    13
        BinaryTree<Integer> binaryTree = BinaryTree.construct();
        System.out.println(diameter(binaryTree.root)[1]);
    }
}
