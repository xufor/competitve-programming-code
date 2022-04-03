public class FindNumberOfNodes {
    public static int count(TreeNode<Integer> root) {
        int totalChildNodes = 1;
        for(int i = 0; i < root.children.size(); i++) {
            totalChildNodes += count(root.children.get(i));
        }
        return totalChildNodes;
    }
    public static void main(String[] args) {
        Tree tree = Tree.construct();
        System.out.println(count(tree.root));
    }
}
