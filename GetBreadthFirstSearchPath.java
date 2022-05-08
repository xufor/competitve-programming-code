import java.util.HashMap;
import java.util.LinkedList;

public class GetBreadthFirstSearchPath {
    public static LinkedList<Integer> getBFSPath(int[][] adjacencyMatrix, int startVertex, int targetVertex, boolean[] visited) {
        var queue = new LinkedList<Integer>();
        var map = new HashMap<Integer, Integer>();

        visited[startVertex] = true;
        queue.addLast(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            if (vertex == targetVertex)
                break;
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    queue.addLast(i);
                    visited[i] = true;
                    map.put(i, vertex); // (toVertex, fromVertex)
                }
            }
        }

        int currentVertex = targetVertex;
        var result = new LinkedList<Integer>();
        while (true) {
            if (map.containsKey(currentVertex)) {
                result.addFirst(currentVertex);
                currentVertex = map.get(currentVertex);
            } else if (currentVertex == startVertex) {
                result.addFirst(currentVertex);
                break;
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Graph graph = Graph.construct();
        System.out.println(getBFSPath(graph.adjacencyMatrix, 0, 2, new boolean[graph.noOfVertices]));
        System.out.println(getBFSPath(graph.adjacencyMatrix, 0, 5, new boolean[graph.noOfVertices]));
    }
}
