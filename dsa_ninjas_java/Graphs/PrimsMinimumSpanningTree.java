import java.util.Arrays;
import java.util.Scanner;

public class PrimsMinimumSpanningTree {
    public static void prims(int[][] adjacencyMatrix, int startVertex) {
        int noOfVertices = adjacencyMatrix.length;

        boolean[] visited = new boolean[noOfVertices];
        int[] weightOfVisit = new int[noOfVertices];
        int[] parentOfVisit = new int[noOfVertices];

        Arrays.fill(weightOfVisit, Integer.MAX_VALUE);
        weightOfVisit[startVertex] = 0;
        parentOfVisit[startVertex] = -1;

        for (int i = 0; i < noOfVertices; i++) {
            int minWeightVertexIndex = findMinWeightVertex(weightOfVisit, visited);
            visited[minWeightVertexIndex] = true;

            for (int j = 0; j < noOfVertices; j++) {
                if (adjacencyMatrix[minWeightVertexIndex][j] != 0 && !visited[j] && adjacencyMatrix[minWeightVertexIndex][j] < weightOfVisit[j]) {
                   weightOfVisit[j] = adjacencyMatrix[minWeightVertexIndex][j];
                   parentOfVisit[j] = minWeightVertexIndex;
                }
            }
        }

        for (int i = 0; i < noOfVertices; i++) {
            System.out.println(parentOfVisit[i] + " " + i + " " + weightOfVisit[i]);
        }
    }

    private static int findMinWeightVertex(int[] weightOfVisit, boolean[] visited) {
        int minWeightVertexIndex = -1;
        for (int i = 0; i < weightOfVisit.length; i++) {
            if (!visited[i] && (minWeightVertexIndex == -1 || weightOfVisit[i] < weightOfVisit[minWeightVertexIndex])) {
                minWeightVertexIndex = i;
            }
        }
        return minWeightVertexIndex;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int noOfVertices = scnr.nextInt();
        int noOfEdges = scnr.nextInt();

        int adjacencyMatrix[][] = new int[noOfVertices][noOfVertices];
        for (int i = 0; i < noOfEdges; i++) {
            int fromIndex = scnr.nextInt();
            int toIndex = scnr.nextInt();
            int weight = scnr.nextInt();
            adjacencyMatrix[fromIndex][toIndex] = weight;
            adjacencyMatrix[toIndex][fromIndex] = weight;
        }
        System.out.println();

        prims(adjacencyMatrix, 0);
        scnr.close();
    }
}

/*
5
7
0 1 4
0 2 8
1 2 2
1 3 6
2 3 3
2 4 9
3 4 5
*/
