import java.util.Scanner;

public class FloydWarshallAllPairsShortestPath {
    public static void floydWarshall(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 0 && i != j) {
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < adjacencyMatrix.length; k++) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    if(i == k || j == k || adjacencyMatrix[i][k] == Integer.MAX_VALUE || adjacencyMatrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j],
                            adjacencyMatrix[i][k] + adjacencyMatrix[k][j]);
                }
            }
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.println(i + " to " + j + " ->  distance: " + adjacencyMatrix[i][j]);
            }
        }
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
        }
        System.out.println();

        floydWarshall(adjacencyMatrix);
        scnr.close();
    }
}

/*
4
7
3 0 2
0 3 7
2 3 1
2 0 5
0 1 3
1 0 8
1 2 2
*/
