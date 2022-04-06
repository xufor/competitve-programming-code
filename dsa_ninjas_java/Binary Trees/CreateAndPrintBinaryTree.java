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

    public static <Z> void printInOrder(BinaryTreeNode<Z> root) {
        if(root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    public static <Z> void printPostOrder(BinaryTreeNode<Z> root) {
        if(root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static <Z> void printPreOrder(BinaryTreeNode<Z> root) {
        if(root != null) {
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
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
        BinaryTree.printInOrder(binaryTree.root);
        System.out.println();
        BinaryTree.printPreOrder(binaryTree.root);
        System.out.println();
        BinaryTree.printPostOrder(binaryTree.root);
    }
}