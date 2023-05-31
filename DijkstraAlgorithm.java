import java.util.*;

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE; // Infinity value for unreachable nodes

    public static void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] dist = new int[numNodes]; // Array to store shortest distances
        boolean[] visited = new boolean[numNodes]; // Array to track visited nodes

        // Initialize distance array and visited array
        Arrays.fill(dist, INF);
        dist[startNode] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int Node = findMinDistance(dist, visited);
            visited[Node] = true;

            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[Node][j] != 0 && dist[Node] != INF &&
                        dist[Node] + graph[Node][j] < dist[j]) {
                    dist[j] = dist[Node] + graph[Node][j];
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Shortest distance from node " + startNode + " to node " + i + ": " + dist[i]);
        }
    }

    private static int findMinDistance(int[] dist, boolean[] visited) {
        int minDist = INF;
        int Node = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                Node = i;
            }
        }

        return Node;
    }

    public static void main(String[] args) {
        // Example graph adjacency matrix representation
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int startNode = 0; // Starting node for Dijkstra's algorithm

        dijkstra(graph, startNode);
    }
}
