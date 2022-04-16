public class LeastCommonAncestor {
    public static int lca(BTNode<Integer> root, int nodeA, int nodeB) {
        if (root == null)
            return -1;

        var leftResult = lca(root.left, nodeA, nodeB);
        var rightResult = lca(root.right, nodeA, nodeB);

        if (root.data == nodeA || root.data == nodeB)
            return root.data;
        else if (leftResult == -1 && rightResult == -1)
            return -1;
        else if (leftResult == -1)
            return rightResult;
        else if (rightResult == -1)
            return leftResult;
        else
            return root.data;
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
        BinaryTree.printInOrder(binaryTree.root);
        System.out.println();

        Integer[][] testCases = { { 2, 10 }, { 10, 9 }, { 7, 9 }, { 7, 13 }, {11, 12}};
        
        for(var testCase: testCases)
            System.out.println(lca(binaryTree.root, testCase[0], testCase[1]));
    }
}