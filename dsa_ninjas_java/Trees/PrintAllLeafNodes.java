public class PrintAllLeafNodes {
    public static void printAllLeafNodes(TreeNode<Integer> root) {
        if (root.children.size() == 0) {
            System.out.print(root.data + " ");
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printAllLeafNodes(root.children.get(i));
        }
    }

    public static void main(String[] args) {
        Tree tree = Tree.construct();
        // 1 2 2 3 3 4 5 6 1 7 0 0 0 1 8 1 9 0
        //                 1
        //               /   \
        //              2     3
        //            / | \    \
        //           4  5  6    7
        //          (L) (L) (L)  \
        //                        8
        //                         \
        //                          9
        //                          (L)
        printAllLeafNodes(tree.root);
    }
}
