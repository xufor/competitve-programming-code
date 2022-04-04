public class TreeTraversals {
    public static void printPreOrder(TreeNode<Integer> root) {
        System.out.print(root.data + " ");
        for(int i = 0; i < root.children.size(); i++) {
            printPreOrder(root.children.get(i));
        }
    }

    public static void printPostOrder(TreeNode<Integer> root) {
        for(int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Tree tree = Tree.construct();
        // 1 2 2 3 3 4 5 6 1 7 0 0 0 1 8 1 9 0
        //                 1
        //               /   \
        //              2     3
        //            / | \    \
        //           4  5  6    7
        //                       \
        //                        8
        //                         \
        //                          9
        printPreOrder(tree.root);
        System.out.println();
        printPostOrder(tree.root);
    }
}
