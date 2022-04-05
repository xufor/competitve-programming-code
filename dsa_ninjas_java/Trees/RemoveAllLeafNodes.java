import java.util.ArrayList;

public class RemoveAllLeafNodes {
    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root.children.size() == 0) {
            return null;
        }
        for (int i = 0; i < root.children.size(); i++) {
            root.children.set(i, removeLeafNodes(root.children.get(i)));
        }
        ArrayList<TreeNode<Integer>> nonLeafChildren = new ArrayList<>();
        for(TreeNode<Integer> childNode: root.children) {
            if(childNode != null) {
                nonLeafChildren.add(childNode);
            }
        }
        root.children = nonLeafChildren;
        // ALTERNATIVE METHOD
        // root.children = root.children.stream().filter(childNode -> !(childNode == null))
        //         .collect(Collectors.toCollection(ArrayList::new));
        return root;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = Tree.construct();
        // 1 2 2 3 3 4 5 6 1 7 0 0 0 1 8 1 9 0
        // 1 0
        // 1 2 2 3 1 4 0 0
        //                 1
        //               /   \
        //              2     3
        //            / | \    \
        //           4  5  6    7
        //                       \
        //                        8
        //                         \
        //                          9
        tree.root = removeLeafNodes(tree.root);
        tree.printLevelOrder();
    }
}