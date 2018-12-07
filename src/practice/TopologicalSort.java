package practice;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {

		Graph graph = new Graph(6);
		
		graph.addEdge(2, 3, true);
		//graph.addEdge(2, 5, true);
		graph.addEdge(3, 1, true);
		graph.addEdge(4, 0, true);
		graph.addEdge(4, 1, true);
		graph.addEdge(5, 0, true);
		graph.addEdge(5, 2, true);
		
		topoSort(graph);
		
	}

	private static void topoSort(Graph graph) {
		
		int v = graph.V;
		
		boolean visited[] = new boolean[v];
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < v; i++) {
			
			if(!visited[i])
				topoSortUtil(graph, i, visited, st);
			
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + "\t");
		}
		
		System.out.println();
	}
	
	private static void topoSortUtil(Graph graph, int start, boolean visited[], Stack<Integer> st) {
		
		visited[start] = true;
		
		Iterator<Integer> it = graph.adjList[start].listIterator();
		
		while(it.hasNext()) {
			
			int vertix = it.next(); 
			
			if(!visited[vertix])
				topoSortUtil(graph, vertix, visited, st);
		}
		
		st.push(start);
	}
}
