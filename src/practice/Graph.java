package practice;

import java.util.LinkedList;

/**
 * Adjacency List : 
 * Pros: Saves space O(|V|+|E|) . In the worst case, there can be C(V, 2) number of edges 
 * in a graph thus consuming O(V^2) space. Adding a vertex is easier.
 *
 * Cons: Queries like whether there is an edge from vertex u to vertex v are not efficient and
 * can be done O(V).
 * 
 */


public class Graph {

	int V;
	
	LinkedList<Integer> adjList[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {

		V = v;
		
		adjList = new LinkedList[V];
		
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int src, int dest, boolean directed) {
		
		adjList[src].add(dest);

		if(!directed)
			adjList[dest].add(src);
	}
	
	public void printGraph() {
		
		for (int i = 0; i < V; i++) {
			
			System.out.print(i + "\t");
			
			for (int j = 0; j < adjList[i].size(); j++) {
				int n = adjList[i].get(j);
				System.out.print(n + "\t");
			}
			
			System.out.println();
		}
	}
}
