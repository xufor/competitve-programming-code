import java.util.Stack;

class BTIterator {
    Stack<BTNode<Integer>> stack;
    boolean isReverse;

    public BTIterator(BTNode<Integer> root, boolean isReverse) {
        this.isReverse = isReverse;
        this.stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = (isReverse ? root.right : root.left);
        }
    }

    public BTNode<Integer> next() {
        var top = stack.pop();
        var next = (isReverse ? top.left: top.right);
        while (next != null) {
            stack.push(next);
            next = (isReverse ? next.right : next.left);
        }
        return top;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class BSTPairSum {
    public static void pairSum(int targetSum, BinarySearchTree binarySearchTree) {
        var fwdIterator = new BTIterator(binarySearchTree.root, false);
        var revIterator = new BTIterator(binarySearchTree.root, true);

        if (fwdIterator.hasNext()) { // ensuring atleast one element is present
            var leftElement = fwdIterator.next();
            var rightElement = revIterator.next();

            while (leftElement.data < rightElement.data) {
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
        System.out.println();
        pairSum(3, binarySearchTree);
    }
}