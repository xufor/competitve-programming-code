public class FindLargestData {
    public static Integer findLargest(TreeNode<Integer> root) {
        if(root.children.size() == 0) {
            return root.data;
        }
        Integer largest = root.data;
        for(int i = 0; i < root.children.size(); i++) {
            largest = Math.max(findLargest(root.children.get(i)), largest);
        }
        return largest;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = Tree.construct();
        System.out.println(findLargest(tree.root));
    }
}