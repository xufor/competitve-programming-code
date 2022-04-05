import java.util.Scanner;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
    }
}

class BinaryTree<T> {
    public BinaryTreeNode<T> root;
    public static Scanner scnr = new Scanner(System.in);

    public static BinaryTreeNode<Integer> contructBinaryTreeRecursively() {
        Integer data = scnr.nextInt();
        if (data == -1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        root.left = contructBinaryTreeRecursively();
        root.right = contructBinaryTreeRecursively();
        return root;
    }

    public static BinaryTree<Integer> construct() {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.root = contructBinaryTreeRecursively();
        return binaryTree;
    }

    private void printInOrder(BinaryTreeNode<T> root) {
        if(root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    private void printPostOrder(BinaryTreeNode<T> root) {
        if(root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void printPreOrder(BinaryTreeNode<T> root) {
        if(root != null) {
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    public void printPostOrder() {
        printPostOrder(this.root);
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }
}

public class CreateAndPrintBinaryTree {
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
        binaryTree.printInOrder();
        System.out.println();
        binaryTree.printPostOrder();
        System.out.println();
        binaryTree.printPreOrder();
    }
}