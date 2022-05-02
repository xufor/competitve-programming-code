import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class KrushkalsMinimumSpanningTree {
    public static int findParent(int targetVertex, int[] parentsOfVerticesInMST) {
        if(parentsOfVerticesInMST[targetVertex] == targetVertex) {
            return targetVertex;
        }
        return findParent(parentsOfVerticesInMST[targetVertex], parentsOfVerticesInMST);
    }

    public static void krushkals(Edge[] edgeList, int noOfVertices) {
        Arrays.sort(edgeList, (a, b) -> a.weight - b.weight);

        ArrayList<Edge> mst = new ArrayList<Edge>();
        int[] parentsOfVerticesInMST = IntStream.range(0, noOfVertices).toArray();
        
        for(int edgeUnderFocusIndex = 0; edgeUnderFocusIndex < edgeList.length && mst.size() != noOfVertices - 1; edgeUnderFocusIndex++) {
            Edge edgeUnderFocus = edgeList[edgeUnderFocusIndex];
            int parentOfSourceVertex = findParent(edgeUnderFocus.source, parentsOfVerticesInMST);
            int parentOfDestinationVertex = findParent(edgeUnderFocus.destination, parentsOfVerticesInMST);

            if(parentOfSourceVertex != parentOfDestinationVertex) {
                mst.add(edgeUnderFocus);
                parentsOfVerticesInMST[parentOfSourceVertex] = parentOfDestinationVertex;
            }
        }

        mst.forEach(edge -> System.out.println(edge.source + " " + edge.destination + " " + edge.weight));
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
        krushkals(edgeList, noOfVertices);
        scnr.close();
    }
}

/*
6
11
1 3 1
0 1 2
0 3 3
0 2 4
4 5 5
2 3 6
3 5 7
2 1 8
2 4 9
2 5 10
3 4 11
*/
