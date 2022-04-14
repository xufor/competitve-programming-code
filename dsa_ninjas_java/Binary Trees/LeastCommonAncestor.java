class LCAData {
    boolean nodeAFound;
    boolean nodeBFound;
    int lca;

    public LCAData() {
        this.nodeAFound = false;
        this.nodeAFound = false;
        this.lca = -1;
    }

    public LCAData(boolean nodeAFound, boolean nodeBFound, int lca) {
        this.nodeAFound = nodeAFound;
        this.nodeBFound = nodeBFound;
        this.lca = lca;
    }
}

public class LeastCommonAncestor {
    public static LCAData lca(BinaryTreeNode<Integer> root, int nodeA, int nodeB) {
        if (root == null)
            return new LCAData();

        var leftResult = lca(root.left, nodeA, nodeB);
        var rightResult = lca(root.right, nodeA, nodeB);

        if (leftResult.lca == -1 && rightResult.lca == -1) {
            if ((leftResult.nodeAFound || rightResult.nodeAFound)
                    && (leftResult.nodeBFound || rightResult.nodeBFound)) {
                return new LCAData(true, true, root.data);
            } else if (root.data == nodeA) {
                return new LCAData(true, leftResult.nodeBFound || rightResult.nodeBFound, -1);
            } else if (root.data == nodeB) {
                return new LCAData(leftResult.nodeAFound || rightResult.nodeAFound, true, -1);
            } else {
                return new LCAData(leftResult.nodeAFound || rightResult.nodeAFound,
                        leftResult.nodeBFound || rightResult.nodeBFound, -1);
            }
        } else {
            return new LCAData(true, true, leftResult.lca != -1 ? leftResult.lca : rightResult.lca);
        }
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

        Integer[][] testCases = { { 2, 10 }, { 4, 8 }, { 7, 9 }, { 7, 13 } };
        
        for(var testCase: testCases)
            System.out.println(lca(binaryTree.root, testCase[0], testCase[1]).lca);
    }
}