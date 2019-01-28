import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class DijkstrasAlgorithm {
private static final int NO_PARENT = -1;
// Function that implements Dijkstra's
// single source shortest path
// algorithm for a graph represented
// using adjacency matrix
// representation
private static void dijkstra(int[][] adjacencyMatrix,
int startVertex)
{
int nVertices = adjacencyMatrix[0].length;
// shortestDistances[i] will hold the
// shortest distance from src to i
int[] shortestDistances = new int[nVertices];
// added[i] will true if vertex i is
// included / in shortest path tree
// or shortest distance from src to
// i is finalized
boolean[] added = new boolean[nVertices];
// Initialize all distances as
// INFINITE and added[] as false
for (int vertexIndex = 0; vertexIndex < nVertices;
vertexIndex++)
{
shortestDistances[vertexIndex] = Integer.MAX_VALUE;
added[vertexIndex] = false;
}
// Distance of source vertex from
// itself is always 0
shortestDistances[startVertex] = 0;
// Parent array to store shortest
// path tree
int[] parents = new int[nVertices];
// The starting vertex does not
// have a parent
parents[startVertex] = NO_PARENT;
// Find shortest path for all
// vertices
for (int i = 1; i < nVertices; i++)
{
// Pick the minimum distance vertex
// from the set of vertices not yet
// processed. nearestVertex is
// always equal to startNode in
// first iteration.
int nearestVertex = -1;
int shortestDistance = Integer.MAX_VALUE;
for (int vertexIndex = 0;
vertexIndex < nVertices;
vertexIndex++)
{
if (!added[vertexIndex] &&
shortestDistances[vertexIndex] <
shortestDistance)
{
nearestVertex = vertexIndex;
shortestDistance =
shortestDistances[vertexIndex];
}
}
// Mark the picked vertex as
// processed
added[nearestVertex] = true;
// Update dist value of the
// adjacent vertices of the
// picked vertex.
for (int vertexIndex = 0;
vertexIndex < nVertices;
vertexIndex++)
{
int edgeDistance =
adjacencyMatrix[nearestVertex][vertexIndex];
if (edgeDistance > 0
&& ((shortestDistance + edgeDistance) <
shortestDistances[vertexIndex]))
{
parents[vertexIndex] = nearestVertex;
shortestDistances[vertexIndex] =
shortestDistance + edgeDistance;
}
}
}
printSolution(startVertex, shortestDistances, parents);
}
// A utility function to print
// the constructed distances
// array and shortest paths
private static void printSolution(int startVertex,
int[] distances, int[] parents)
{
int nVertices = distances.length;
System.out.print("Vertex\t\t Distance\tPath");
for (int vertexIndex = 0;
vertexIndex < nVertices;
vertexIndex++)
{
if (vertexIndex != startVertex)
{
System.out.print("\n" + startVertex + " -> ");
System.out.print(vertexIndex + " \t\t ");
System.out.print(distances[vertexIndex] + "\t\t");
printPath(vertexIndex, parents);
}
}
}
// Function to print shortest path
// from source to currentVertex
// using parents array
private static void printPath(int currentVertex,
int[] parents)
{
// Base case : Source node has
// been processed
if (currentVertex == NO_PARENT)
{
return;
}
printPath(parents[currentVertex], parents);
System.out.print(currentVertex + " ");
}
// Driver Code
public static void main(String[] args) throws IOException
{
BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
System.out.println("Enter number of vertex:");
int num= Integer.parseInt(br.readLine());
int row=num;
int col=num;
int[][] adjacencyMatrix = new int[row][col];
Scanner in = new Scanner(System.in);
for(int r = 0; r<row; r++)
{
for(int c = 0 ;c<col; c++)
{
System.out.println("enter the weight from node "+r+"to node "+c);
adjacencyMatrix[r][c] = in.nextInt();
}
}
BufferedReader br1 = new BufferedReader(new
InputStreamReader(System.in));
System.out.println("enter the source node");
int ss=Integer.parseInt(br1.readLine());
dijkstra(adjacencyMatrix,ss);
}
}