import java.util.Iterator;
import java.util.LinkedList;


public class ZigZagTraversal {
    public static void zigzag(BTNode<Integer> root) {
        if (root == null)
            return;
        LinkedList<BTNode<Integer>> linkedList = new LinkedList<>(); // this is a doubly linked list
        boolean isLeftToRight = true;
        linkedList.addLast(root);

        while (!linkedList.isEmpty()) {
            Iterator<BTNode<Integer>> iterator = isLeftToRight == true ? linkedList.iterator()
                    : linkedList.descendingIterator();
            
            while (iterator.hasNext()) {
                System.out.print(iterator.next().data + " ");
            }
            System.out.println();

            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                BTNode<Integer> nodeToBeProcessed = linkedList.removeFirst();
                if (nodeToBeProcessed.left != null)
                    linkedList.addLast(nodeToBeProcessed.left);
                if (nodeToBeProcessed.right != null)
                    linkedList.addLast(nodeToBeProcessed.right);
            }

            isLeftToRight = !isLeftToRight;
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
        zigzag(binaryTree.root);
    }
}