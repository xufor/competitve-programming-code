public class FindNumberOfNodes {
    public static int count(TreeNode<Integer> root) {
        int totalChildNodes = 1;
        // no base case here, as the for loop will act as base case
        // it won't loop and thus no calls are made any further
        for(int i = 0; i < root.children.size(); i++) {
            totalChildNodes += count(root.children.get(i));
        }
        return totalChildNodes;
    }
    public static void main(String[] args) {
        Tree<Integer> tree = Tree.construct();
        System.out.println(count(tree.root));
    }
}
