import java.util.Arrays;
import java.util.*;
public class DVA {

public static void main(String[] args) {
Scanner sc=new Scanner( System.in);

System.out.println("enter no. of routers:");
int ro;
char[] G= {'A','B','C','D','E','F','G','H','I','J'};
ro=sc.nextInt();
int[][] routingTable = new int[ro][ro];
int[][] networkTopology = new int[ro][ro];
System.out.println("enter the Distance matrix:");
for (int i=0;i<ro;i++)
{
for(int j=0;j<ro;j++)
{
networkTopology[i][j]=sc.nextInt();
}}

for (int i = 0; i < ro; i++) {
for (int j = 0; j < ro; j++) {
routingTable[i][j] = networkTopology[i][j];
}
}
boolean updated;
int iteration = 1;
do {
updated = false;
System.out.println("Iteration: " + iteration++);
for (int i = 0; i < ro; i++) {
for (int j = 0; j < ro; j++) {
int minDist = routingTable[i][j];
for (int k = 0; k < ro; k++) {
if (routingTable[i][k] == Integer.MAX_VALUE || networkTopology[k][j] == Integer.MAX_VALUE) {
continue;
}
int newDist = routingTable[i][k] + networkTopology[k][j];
if (newDist < minDist) {
minDist = newDist;
routingTable[i][j] = newDist;
updated = true;
}
}
}}
for (int i = 0; i < ro; i++) {
System.out.printf("Routing table for Node %c:\n", G[i]);
System.out.println("Destination:    Distance:");
for (int j = 0; j < ro; j++) {
if (routingTable[i][j] == Integer.MAX_VALUE) {
System.out.printf("      %c         Infinity\n", G[j]);
}
else
{
System.out.printf("      %c            %d\n", G[j], routingTable[i][j]);
}
}
System.out.println();
}

} while (updated);

}
}

