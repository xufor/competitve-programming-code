import java.util.HashMap;
import java.util.LinkedList;

public class PrintAllNodesAtDistanceK {
    public static HashMap<BTNode<Integer>, BTNode<Integer>> getParents(BTNode<Integer> root) {
        var hashMap = new HashMap<BTNode<Integer>, BTNode<Integer>>();
        var queue = new LinkedList<BTNode<Integer>>();

        queue.addLast(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                var node = queue.removeFirst();
                if (node.left != null) {
                    hashMap.put(node.left, node);
                    queue.push(node.left);
                }
                if (node.right != null) {
                    hashMap.put(node.right, node);
                    queue.push(node.right);
                }
            }
        }

        return hashMap;
    }

    public static BTNode<Integer> find(BTNode<Integer> root, int targetData) {
        if(root == null)            
            return null;

        var leftResult = find(root.left, targetData);
        var rightResult = find(root.right, targetData);

        if(targetData == root.data)
            return root;
        else if(leftResult == null && rightResult == null) 
            return null;
        else if(leftResult == null)
            return rightResult;
        else
            return leftResult;
    }

    public static void printAllAtDistanceK(BTNode<Integer> root, int targetData, int targetDistance) {
        if (root == null)
            return;

        var parents = getParents(root);
        var targetNode = find(root, targetData);

        if(targetNode == null)
            return;

        var queue = new LinkedList<BTNode<Integer>>();
        queue.addLast(targetNode);

        int currentDistance = 0;
        var visited = new HashMap<BTNode<Integer>, Boolean>();
        visited.put(targetNode, true);

        while(!queue.isEmpty()) {
            if(currentDistance == targetDistance) {
                queue.stream().forEach(node -> System.out.print(node.data + " "));
                System.out.println();
                return;
            }

            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++) {
                var node = queue.removeFirst();

                if(node.left != null && !visited.getOrDefault(node.left, false)) {
                    visited.put(node.left, true);
                    queue.addLast(node.left);
                }

                if(node.right != null && !visited.getOrDefault(node.right, false)) {
                    visited.put(node.right, true);
                    queue.addLast(node.right);
                }

                var parent = parents.getOrDefault(node, null);

                if(parent != null && !visited.getOrDefault(parent, false)) {
                    visited.put(parent, true);
                    queue.addLast(parent);
                }
            }

            currentDistance++;
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
        var binaryTree = BinaryTree.construct();
        // printAllAtDistanceK(binaryTree.root, 2, 1);
        printAllAtDistanceK(binaryTree.root, 2, 2);
        // printAllAtDistanceK(binaryTree.root, 2, 3);
    }
}