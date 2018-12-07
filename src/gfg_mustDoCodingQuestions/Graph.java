package gfg_mustDoCodingQuestions;

import java.util.LinkedList;

public class Graph {

	int V;
	
	LinkedList<Integer>[] adjList;
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		
		this.V = v;
		adjList = new LinkedList[V];
		
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public int getV() {
		return V;
	}
	
	public LinkedList<Integer>[] getAdjList() {
		return adjList;
	}
	
	public void addEdge(int src, int dest, boolean directed) {
		
		adjList[src].add(dest);
		
		if(!directed)
			adjList[dest].add(src);
	}
	
	public void printAdjacencyLists() {
		
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
