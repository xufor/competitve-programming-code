import java.util.ArrayList;
import java.util.Arrays;

public class ConstructTreeFromPreorderAndInorder {
    public static BinaryTreeNode<Integer> construct(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        if(inorder.size() == 0 || preorder.size() == 0)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder.get(0));
        int rootIndexInInorder = inorder.indexOf(preorder.get(0));
        ArrayList<Integer> preorderLeft = new ArrayList<>(preorder.subList(1, rootIndexInInorder + 1));
        ArrayList<Integer> preorderRight = new ArrayList<>(preorder.subList(rootIndexInInorder + 1, preorder.size()));

        ArrayList<Integer> inorderLeft = new ArrayList<>(inorder.subList(0, rootIndexInInorder));
        ArrayList<Integer> inorderRight = new ArrayList<>(inorder.subList(rootIndexInInorder + 1, inorder.size()));

        root.left = construct(inorderLeft, preorderLeft);
        root.right = construct(inorderRight, preorderRight);
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        inorder.addAll(Arrays.asList(new Integer[] { 10, 4, 7, 6, 9, 2, 1, 3, 12, 13, 11 }));
        preorder.addAll(Arrays.asList(new Integer[] { 1, 2, 4, 10, 6, 7, 9, 3, 11, 12, 13 }));
        BinaryTreeNode<Integer> root = construct(inorder, preorder);
        BinaryTree.printInOrder(root);
        System.out.println();
        BinaryTree.printPreOrder(root);
        System.out.println();
        BinaryTree.printPostOrder(root);
    }
}