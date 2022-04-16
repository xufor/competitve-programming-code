import java.util.Arrays;
import java.util.LinkedList;

public class RootToNodePath {
    public static LinkedList<Integer> path(BTNode<Integer> root, Integer target) {
        if(root == null) {
            return null;
        }

        var leftResult = path(root.left, target);
        var rightResult = path(root.right, target);

        if(root.data == target) {
            return new LinkedList<>(Arrays.asList(root.data));
        }
        else {
            if(leftResult == null && rightResult == null) {
                return null;
            }
            else if(leftResult != null) {
                leftResult.addFirst(root.data);
                return leftResult;
            }
            else {
                rightResult.addFirst(root.data);
                return rightResult;
            }
        }
    }

    public static void main(String[] args) {
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
        BinaryTree<Integer> binaryTree = BinaryTree.construct();
        System.out.println(path(binaryTree.root, 6));
    }
}