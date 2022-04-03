public class FindHeight {
    public static Integer findHeight(TreeNode<Integer> root) {
        if(root.children.size() == 0) {
            return 0;
        }
        Integer height = 0;
        for(int i = 0; i < root.children.size(); i++) {
            height = Math.max(findHeight(root.children.get(i)) + 1, height);
        }
        return height;
    }

    public static void main(String[] args) {
        Tree tree = Tree.construct();
        // 1 2 2 3 3 4 5 6 1 7 0 0 0 1 8 1 9 0
        System.out.println(findHeight(tree.root));
    }
}
