package practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
		
		bfsTraversal(graph, 0);
		
		Graph dGraph = new Graph(6);
		
		addEdge(dGraph, 0, 1, true);
		addEdge(dGraph, 0, 2, true);
		addEdge(dGraph, 1, 4, true);
		addEdge(dGraph, 2, 4, true);
		addEdge(dGraph, 4, 3, true);
		addEdge(dGraph, 3, 5, true);
		
		bfsTraversal(dGraph, 0);
		
	}
	
	private static void addEdge(Graph graph, int src, int dest, boolean directed) {
		
		graph.adjList[src].add(dest);

		if(!directed)
			graph.adjList[dest].add(src);
		
	}

	private static void bfsTraversal(Graph graph, int start) {
		
		System.out.println("BFS Traversal of given graph is : ");
		
		boolean visited[] = new boolean[graph.V];
		
		Arrays.fill(visited, false);
		
		Queue<Integer> qu = new LinkedList<>();
		
		qu.add(start);
		visited[start] = true;
		
		while(!qu.isEmpty()) {
			
			int num = qu.poll();
			
			System.out.print(num + "\t");
			
			Iterator<Integer> it = graph.adjList[num].listIterator();
			
			while(it.hasNext()) {
				
				int tmp = it.next();
				
				if(!visited[tmp]) {
					
					qu.add(tmp);
					visited[tmp] = true;
				}
			}
			
		}
		System.out.println();
	}

}
