import java.util.Arrays;
import java.util.LinkedList;

public class GetDepthFirstSearchPath {
    public static LinkedList<Integer> getDFSPath(int[][] adjacencyMatrix, int startVertex, int targetVertex, boolean[] visited) {
        if (startVertex == targetVertex)
            return new LinkedList<Integer>(Arrays.asList(startVertex));
        visited[startVertex] = true;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                var result = getDFSPath(adjacencyMatrix, i, targetVertex, visited);
                if (result != null) {
                    result.addFirst(startVertex);;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph graph = Graph.construct();
        System.out.println(getDFSPath(graph.adjacencyMatrix, 0, 2, new boolean[graph.noOfVertices]));
    }
}
