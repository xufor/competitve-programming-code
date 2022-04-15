import java.util.Stack;

class ForwardBSTIterator {
    Stack<BSTNode<Integer>> stack;

    public ForwardBSTIterator(BSTNode<Integer> root) {
        this.stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public BSTNode<Integer> next() {
        var top = stack.pop();
        if (top.right != null) {
            var rightOfTop = top.right;
            while (rightOfTop != null) {
                stack.push(rightOfTop);
                rightOfTop = rightOfTop.left;
            }
        }
        return top;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class ReverseBSTIterator {
    Stack<BSTNode<Integer>> stack;

    public ReverseBSTIterator(BSTNode<Integer> root) {
        this.stack = new Stack<>();
        while (root != null) {
            this.stack.add(root);
            root = root.right;
        }
    }

    public BSTNode<Integer> next() {
        var top = stack.pop();
        if (top.left != null) {
            var leftOfTop = top.left;
            while (leftOfTop != null) {
                stack.push(leftOfTop);
                leftOfTop = leftOfTop.right;
            }
        }
        return top;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class BSTPairSum {
    public static void pairSum(int targetSum, BinarySearchTree binarySearchTree) {
        var fwdIterator = new ForwardBSTIterator(binarySearchTree.root);
        var revIterator = new ReverseBSTIterator(binarySearchTree.root);

        if (fwdIterator.hasNext()) { // ensuring atleast one element is present
            var leftElement = fwdIterator.next();
            var rightElement = revIterator.next();

            while (fwdIterator.hasNext() && revIterator.hasNext()) {
                int currentSum = leftElement.data + rightElement.data;
                if (currentSum == targetSum) {
                    System.out.println(leftElement.data + " " + rightElement.data);
                    if (fwdIterator.hasNext() && revIterator.hasNext()) {
                        leftElement = fwdIterator.next();
                        rightElement = revIterator.next();
                    }
                } else if (currentSum > targetSum) {
                    rightElement = revIterator.next();
                } else {
                    leftElement = fwdIterator.next();
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int data : new Integer[] { 9, 4, 5, 2, 3, 7, 8, 1, 6, 10 })
            binarySearchTree.insert(data);
        pairSum(8, binarySearchTree);
    }
}