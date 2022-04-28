import java.util.LinkedList;

public class LeftAndRightViewOfBinaryTree {
    public static void leftView(BTNode<Integer> root, int level, LinkedList<Integer> result) {
        if(root == null)
            return;
        if(level == result.size())
            result.addLast(root.data);
        leftView(root.left, level + 1, result);
        leftView(root.right, level + 1, result);
    }

    public static void leftView(BTNode<Integer> root) {
        var result = new LinkedList<Integer>();
        leftView(root, 0, result);
        System.out.println(result);
    }
    
    public static void rightView(BTNode<Integer> root, int level, LinkedList<Integer> result) {
        if(root == null)
            return;
        if(level == result.size())
            result.addLast(root.data);
        rightView(root.right, level + 1, result);
        rightView(root.left, level + 1, result);
    }
    
    public static void rightView(BTNode<Integer> root) {
        var result = new LinkedList<Integer>();
        rightView(root, 0, result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/binary-tree-right-side-view
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
        var binaryTree = BinaryTree.construct();
        leftView(binaryTree.root);
        rightView(binaryTree.root);
    }
}
