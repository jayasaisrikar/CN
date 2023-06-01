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
            int minDistNode = findMinDistance(dist, visited);
            visited[minDistNode] = true;

            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[minDistNode][j] != 0 && dist[minDistNode] != INF &&
                        dist[minDistNode] + graph[minDistNode][j] < dist[j]) {
                    dist[j] = dist[minDistNode] + graph[minDistNode][j];
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
        int minDistNode = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of nodes
        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create the graph adjacency matrix
        int[][] graph = new int[numNodes][numNodes];

        // Get the adjacency matrix from the user
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                graph[i][j] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the newline character
        }

        // Get the starting node
        System.out.print("Enter the starting node: ");
        int startNode = scanner.nextInt();

        // Run Dijkstra's algorithm
        dijkstra(graph, startNode);
    }
}
