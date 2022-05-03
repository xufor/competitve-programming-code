import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class VertexInfo {
    int current;
    int previous;

    public VertexInfo(int current, int previous) {
        this.current = current;
        this.previous = previous;
    }
}

public class CycleDetectionInUndirectedGraphUsingBFS {
    public static void detectCycle(ArrayList<ArrayList<Integer>> adjacencyList, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        LinkedList<VertexInfo> queue = new LinkedList<>();

        queue.addLast(new VertexInfo(0, -1));
        visited[0] = true;

        while(!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.removeFirst();
            ArrayList<Integer> neighbourVertices = adjacencyList.get(vertexInfo.current);
            for(int i = 0; i < neighbourVertices.size(); i++) {
                int neighbourVertex = neighbourVertices.get(i);
                if(visited[neighbourVertex]) {
                    if(neighbourVertex != vertexInfo.previous) {
                        System.out.println("Cycle Detected");
                        return;
                    }
                } else {
                    queue.add(new VertexInfo(neighbourVertex, vertexInfo.current));
                    visited[neighbourVertex] = true;
                }
            }
        }

        System.out.println("No Cycle Detected");
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int noOfVertices = scnr.nextInt();

        var adjacencyList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < noOfVertices; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int noOfNeighbours = scnr.nextInt(); 
            for(int j = 0; j < noOfNeighbours; j++) {
                arrayList.add(scnr.nextInt());
            }
            adjacencyList.add(arrayList);
        }
        System.out.println();
        detectCycle(adjacencyList, noOfVertices);
        scnr.close();
    }
}

/*
8
1 1
3 0 4 5
2 4 6
2 5 6
2 1 2
2 1 3
3 2 3 7
1 6

8
1 1
3 0 4 5
1 4
2 5 6
2 1 2
2 1 3
2 3 7
1 6
*/