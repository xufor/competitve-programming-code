import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    public int noOfVertices;
    public int noOfEdges;
    public int[][] adjacencyMatrix;
    public static Scanner scnr = new Scanner(System.in);

    public Graph(int noOfVertices, int noOfEdges) {
        this.noOfVertices = noOfVertices;
        this.noOfEdges = noOfEdges;
        this.adjacencyMatrix = new int[noOfVertices][noOfVertices];
    }

    public static Graph construct() {
        int noOfVertices = scnr.nextInt();
        int noOfEdges = scnr.nextInt();
        Graph graph = new Graph(noOfVertices, noOfEdges);
        for (int i = 0; i < noOfEdges; i++) {
            int fromVertex = scnr.nextInt();
            int toVertex = scnr.nextInt();
            graph.adjacencyMatrix[fromVertex][toVertex] = 1;
            graph.adjacencyMatrix[toVertex][fromVertex] = 1;
        }
        return graph;
    }

    public void depthFirstSearch(int startVertex, boolean[] visited) {
        System.out.print(startVertex + " ");
        visited[startVertex] = true;
        for (int i = 0; i < noOfVertices; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                depthFirstSearch(i, visited);
            }
        }
    }

    public void depthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[noOfVertices];
        depthFirstSearch(startVertex, visited);
        System.out.println();
    }

    public void depthFirstSearchDisconnected() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                depthFirstSearch(i, visited);
            }
        }
        System.out.println();
    }

    public void breathFirstSearch(int startVertex, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.addLast(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            System.out.print(vertex + " ");
            for (int i = 0; i < noOfVertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    queue.addLast(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void breathFirstSearch(int startVertex) {
        boolean[] visited = new boolean[noOfVertices];
        breathFirstSearch(0, visited);
        System.out.println();
    }

    public void breathFirstSearchDisconnected() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                breathFirstSearch(i, visited);
            }
        }
        System.out.println();
    }
}

public class AdjacencyMatrixImplementation {
    /*
        7
        8
        0 1
        1 3
        0 3
        0 2
        2 3
        2 4
        3 4
        5 6

        7 8 0 1 1 3 0 3 0 2 2 3 2 4 3 4 5 6
    */
    public static void main(String[] args) {
        Graph graph = Graph.construct();
        graph.depthFirstSearch(0);
        graph.depthFirstSearchDisconnected();
        graph.breathFirstSearch(0);
        graph.breathFirstSearchDisconnected();
    }
}