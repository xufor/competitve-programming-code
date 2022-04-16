import java.util.Stack;

public class PrintAllPathsToLeafWithSumK {
    public static Stack<Integer> stack = new Stack<>();

    public static void paths(BTNode<Integer> root, int targetSum) {
        if(root == null)
            return;
        if (root.left == null && root.right == null) {
            stack.add(root.data);
            if(targetSum - root.data == 0)
                System.out.println(stack);
            stack.pop();
            return;
        }
        stack.push(root.data);
        paths(root.left, targetSum - root.data);
        paths(root.right, targetSum - root.data);
        stack.pop();
    }

    public static void main(String[] args) {
        // 1 2 4 10 -1 -1 14 7 -1 -1 -4 -1 -1 -1 3 -1 11 4 -1 -2 -1 -1 -1
        //                1
        //               / \
        //              2   3
        //             /     \
        //            4       11  
        //           / \      /
        //         10   14    4
        //              / \    \
        //             7  -4    -2
        BinaryTree<Integer> binaryTree = BinaryTree.construct();
        paths(binaryTree.root, 17);
    }
}