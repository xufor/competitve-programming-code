import java.util.Arrays;
import java.util.Scanner;

public class BellmanFordSingleSourceShortestPaths {
    // this algo works with negative weights but fails when negative edge cycle is present
    // it can be used to detect the presence of negtive cycle
    private static void bellmanFord(Edge[] edgeList, int noOfVertices) {
        int[] totalDistanceOfVisit = new int[noOfVertices];

        Arrays.fill(totalDistanceOfVisit, Integer.MAX_VALUE);
        totalDistanceOfVisit[0] = 0;

        for (int i = 1; i <= noOfVertices - 1; i++) {
            for (int j = 0; j < edgeList.length; j++) {
                if(totalDistanceOfVisit[edgeList[j].source] == Integer.MAX_VALUE)
                    continue;

                int totalDistanceOfVisitToNeighbour = totalDistanceOfVisit[edgeList[j].source] + edgeList[j].weight;
                
                if(totalDistanceOfVisitToNeighbour < totalDistanceOfVisit[edgeList[j].destination]) {
                    totalDistanceOfVisit[edgeList[j].destination] = totalDistanceOfVisitToNeighbour;
                }
            }
        }

        for (int j = 0; j < edgeList.length; j++) {
            int totalDistanceOfVisitToNeighbour = totalDistanceOfVisit[edgeList[j].source] + edgeList[j].weight;
            if(totalDistanceOfVisitToNeighbour < totalDistanceOfVisit[edgeList[j].destination]) {
                System.out.println("Negative cycle detected.");
                return;
            }
        }

        for (int i = 0; i < noOfVertices; i++) {
            System.out.println(0 + " to " + i + " -> distance: " + totalDistanceOfVisit[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int noOfVertices = scnr.nextInt();
        int noOfEdges = scnr.nextInt();

        Edge[] edgeList = new Edge[noOfEdges];
        for(int i = 0; i < noOfEdges; i++) {
            edgeList[i] = new Edge(scnr.nextInt(), scnr.nextInt(), scnr.nextInt());
        }
        System.out.println();

        bellmanFord(edgeList, noOfVertices);
        scnr.close();
    }
}


/*
7
10
5 6 3
4 6 3
2 4 1
3 2 -2
2 1 -2
3 5 -1
1 4 -1
0 3 5
0 1 6
0 2 5



7
10
0 1 6
0 2 5
0 3 5
1 4 -1
4 2 1
3 2 -2
2 1 -2
3 5 -1
5 6 3
4 6 3
*/