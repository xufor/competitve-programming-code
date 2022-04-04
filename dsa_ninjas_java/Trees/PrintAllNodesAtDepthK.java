public class PrintAllNodesAtDepthK {
    public static void printAllAtDepthK(TreeNode<Integer> root, int targetDepth) {
        if (targetDepth == 0) {
            System.out.print(root.data + " ");
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printAllAtDepthK(root.children.get(i), targetDepth - 1);
        }
    }

    public static void main(String[] args) {
        Tree tree = Tree.construct();
        // 1 2 2 3 3 4 5 6 1 7 0 0 0 1 8 1 9 0
        //                 1            DEPTH = 0
        //               /   \      
        //              2     3         DEPTH = 1
        //            / | \    \
        //           4  5  6    7       DEPTH = 2
        //                       \
        //                        8     DEPTH = 3
        //                         \
        //                          9   DEPTH = 4
        for(int i = 0; i < 10; i++) {
            System.out.print("Nodes at depth " + i + ": ");
            printAllAtDepthK(tree.root, i);
            System.out.println();
        }
    }
}