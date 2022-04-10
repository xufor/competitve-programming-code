class BSTNode<T> {
    T data;
    BSTNode<T> left;
    BSTNode<T> right;

    BSTNode(T data) {
        this.data = data;
    }
}

class BinarySearchTree {
    public BSTNode<Integer> root;

    private BSTNode<Integer> search(BSTNode<Integer> root, int data) {
        if (root == null)
            return null;
        else if (data > root.data)
            return search(root.right, data);
        else if (data < root.data)
            return search(root.left, data);
        else
            return root;
    }

    public boolean search(int data) {
        return search(this.root, data) != null;
    }

    private BSTNode<Integer> insert(BSTNode<Integer> root, int data) {
        if (root == null)
            return new BSTNode<Integer>(data);
        else if (data > root.data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);
        return root;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private BSTNode<Integer> delete(BSTNode<Integer> root, int data) {
        if (root == null)
            return null;
        else if (data > root.data) {
            root.right = delete(root.right, data);
            return root;
        }
        else if (data < root.data) {
            root.left = delete(root.left, data);
            return root;
        }
        else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else {
                BSTNode<Integer> inorderSuccessor = root.right;
                while(inorderSuccessor.left != null)
                    inorderSuccessor = inorderSuccessor.left;
                root.data = inorderSuccessor.data;
                root.right = delete(root.right, inorderSuccessor.data);
                return root;
            }
        }
    }

    public void delete(int data) {
        this.root = delete(this.root, data);
    }

    private void printInOrder(BSTNode<Integer> root) {
        if(root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    private void printPostOrder(BSTNode<Integer> root) {
        if(root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void printPreOrder(BSTNode<Integer> root) {
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

public class SearchInsertAndDeleteFromBST {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int data : new Integer[] { 9, 4, 5, 2, 3, 7, 8, 1, 6, 10 }) {
            binarySearchTree.insert(data);
            binarySearchTree.printInOrder();
            System.out.println();
        }
        System.out.println(binarySearchTree.search(0));
        System.out.println(binarySearchTree.search(3));
        for (int data : new Integer[] { 9, 4, 5, 2, 3 }) {
            binarySearchTree.delete(data);
            binarySearchTree.printInOrder();
            System.out.println();
        }
    }
}