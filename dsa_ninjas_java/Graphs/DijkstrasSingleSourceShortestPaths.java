import java.util.Arrays;
import java.util.Scanner;

public class DijkstrasSingleSourceShortestPaths {
    // this algo does not work for graphs with edges having negative weights
    private static void dijkstras(int[][] adjacencyMatrix, int startVertex) {
        int noOfVertices = adjacencyMatrix.length;

        boolean[] visited = new boolean[noOfVertices];
        int[] totalDistanceOfVisit = new int[noOfVertices];

        Arrays.fill(totalDistanceOfVisit, Integer.MAX_VALUE);
        totalDistanceOfVisit[startVertex] = 0;

        for (int i = 0; i < noOfVertices; i++) {
            int minDistanceVertexIndex = findMinDistanceVertex(totalDistanceOfVisit, visited);
            visited[minDistanceVertexIndex] = true;

            for (int j = 0; j < noOfVertices; j++) {
                int totalDistanceOfVisitFromMinDistanceVertexToNeighbour = totalDistanceOfVisit[minDistanceVertexIndex]
                        + adjacencyMatrix[minDistanceVertexIndex][j];
                if (adjacencyMatrix[minDistanceVertexIndex][j] != 0 && !visited[j]
                        && totalDistanceOfVisitFromMinDistanceVertexToNeighbour < totalDistanceOfVisit[j]) {
                    totalDistanceOfVisit[j] = totalDistanceOfVisitFromMinDistanceVertexToNeighbour;
                }
            }
        }

        for (int i = 0; i < noOfVertices; i++) {
            System.out.println(startVertex + " to " + i + " -> distance: " + totalDistanceOfVisit[i]);
        }
    }

    private static int findMinDistanceVertex(int[] totalDistanceOfVisit, boolean[] visited) {
        int minWeightVertexIndex = -1;
        for (int i = 0; i < totalDistanceOfVisit.length; i++) {
            if (!visited[i] && (minWeightVertexIndex == -1
                    || totalDistanceOfVisit[i] < totalDistanceOfVisit[minWeightVertexIndex])) {
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

        dijkstras(adjacencyMatrix, 0);
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
