package practice;

import java.util.Arrays;
import java.util.Iterator;

public class DFS {

	public static void main(String[] args) {

		Graph graph = new Graph(6);
		
		addEdge(graph, 0, 1, false);
		addEdge(graph, 0, 2, false);
		addEdge(graph, 1, 3, false);
		addEdge(graph, 1, 4, false);
		addEdge(graph, 2, 4, false);
		addEdge(graph, 3, 4, false);
		addEdge(graph, 3, 5, false);
		addEdge(graph, 4, 5, false);
		
		//graph.printGraph();
		
		dfsTraversal(graph, 0);
		
		System.out.println();
		
		Graph dGraph = new Graph(6);
		
		addEdge(dGraph, 0, 1, true);
		addEdge(dGraph, 0, 2, true);
		addEdge(dGraph, 1, 4, true);
		addEdge(dGraph, 2, 4, true);
		addEdge(dGraph, 4, 3, true);
		addEdge(dGraph, 3, 5, true);
		
		dfsTraversal(dGraph, 0);
		
		System.out.println();
		
		Graph g = new Graph(4); 
		  
        addEdge(g, 0, 1, true); 
        addEdge(g, 0, 2, true); 
        addEdge(g, 1, 2, true); 
        addEdge(g, 2, 0, true); 
        addEdge(g, 2, 3, true); 
        addEdge(g, 3, 3, true);
        
        dfsTraversal(g, 2);

        System.out.println();
        
	}

	private static void addEdge(Graph graph, int src, int dest, boolean directed) {
		
		graph.adjList[src].add(dest);

		if(!directed)
			graph.adjList[dest].add(src);
		
	}
	
	private static void dfsTraversal(Graph graph, int start) {
		
		boolean visited[] = new boolean[graph.V];
		
		Arrays.fill(visited, false);
		
		dfsUtil(graph, visited, start);
		
	}
	
	private static void dfsUtil(Graph graph, boolean visited[], int start) {
		
		visited[start] = true;
		
		System.out.print(start + "\t");
		
		Iterator<Integer> it = graph.adjList[start].listIterator();
		
		while(it.hasNext()) {
			
			int num = it.next();
			if(!visited[num]) {
				dfsUtil(graph, visited, num);
			}
			
		}
		
	}
	
}
