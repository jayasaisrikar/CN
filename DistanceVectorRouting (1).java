import java.util.Scanner;

public class DistanceVectorRouting {
 
  private static int INF = 99999; 
 
  public static void main(String[] args) {
   
    Scanner scanner = new Scanner(System.in);
   
  
    System.out.print("Enter number of nodes: ");
    int n = scanner.nextInt();
  
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = INF;
      }
    }
   
 
    System.out.println("Enter distance matrix:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = scanner.nextInt();
      }
    }
   
  
    int[][] route = new int[n][n];
    char[] G={'a','b','c','d','e','f','g','h'};
    char[][] nextHop = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          route[i][j] = 0;
          nextHop[i][j] = '-';
        } else {  
          route[i][j] = dist[i][j];
          nextHop[i][j] = G[j];
        }
      }
    }
    
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (route[i][k] + route[k][j] < route[i][j]) {
            route[i][j] = route[i][k] + route[k][j];
            nextHop[i][j] = nextHop[i][k];
          }
        }
      }
    }
  
 
    System.out.println("Final Routing Tables:");
    for (int i = 0; i < n; i++) {
      System.out.println("Node " + G[i] + ":");
      System.out.println("Destination\tDistance\tNext Hop\t");
      for (int j = 0; j < n; j++) {
        System.out.println(G[j] + "\t\t" +route[i][j]+
         "\t\t" + nextHop[i][j] );
      }
      System.out.println();
    }
   
  }
 
}
