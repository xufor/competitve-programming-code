public class DiameterOfABinaryTree {
    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        return Math.max(Math.max(height(root.left) + height(root.left), diameter(root.left)), diameter(root.right));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
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
        System.out.println(diameter(binaryTree.root));
    }
}
