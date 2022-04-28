import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

class VerticalTraversalData {
    public int level;
    public int data;

    public VerticalTraversalData(int level, int data) {
        this.level = level;
        this.data = data;
    }
}

public class VerticalTraversalOfBinaryTree {
    public static void verticalTraversal(BTNode<Integer> root, int coordinate, int level,
            TreeMap<Integer, TreeSet<VerticalTraversalData>> map) {
        if (root == null)
            return;
        if (map.containsKey(coordinate)) {
            map.get(coordinate).add(new VerticalTraversalData(level, root.data));
        } else {
            TreeSet<VerticalTraversalData> treeSet = new TreeSet<>(
                    (a, b) -> a.level != b.level ? (a.level - b.level) : (a.data <= b.data ? -1 : 1));
            treeSet.add(new VerticalTraversalData(level, root.data));
            map.put(coordinate, treeSet);
        }
        verticalTraversal(root.left, coordinate - 1, level + 1, map);
        verticalTraversal(root.right, coordinate + 1, level + 1, map);
    }

    public static ArrayList<ArrayList<Integer>> verticalTraversal(BTNode<Integer> root) {
        var map = new TreeMap<Integer, TreeSet<VerticalTraversalData>>();
        verticalTraversal(root, 0, 0, map);
        var result = new ArrayList<ArrayList<Integer>>();
        for (var set : map.values()) {
            var list = new ArrayList<Integer>();
            for (var traversalData : set) {
                list.add(traversalData.data);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
        // 1 2 4 10 -1 -1 6 7 -1 -1 9 -1 -1 5 -1 -1 3 8 -1 -1 11 12 -1 13 -1 -1 14 -1 -1
        //                1
        //               / \
        //              2   3
        //             / \ / \
        //            4   58  11  
        //           / \     /  \
        //         10   6   12   14
        //             / \    \
        //            7   9    13
        var binaryTree = BinaryTree.construct();
        System.out.println(verticalTraversal(binaryTree.root));
    }
}
