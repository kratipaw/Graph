package gfg_mustDoCodingQuestions;

import java.util.Iterator;
import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		
		Graph graph = new Graph(6);
		
		graph.addEdge(0, 1, false);
		graph.addEdge(0, 2, false);
		graph.addEdge(1, 3, false);
		graph.addEdge(1, 4, false);
		graph.addEdge(2, 4, false);
		graph.addEdge(3, 4, false);
		graph.addEdge(3, 5, false);
		graph.addEdge(4, 5, false);
		
		new DFS().dfs(graph, 0);
		
		Graph dGraph = new Graph(6);
		
		dGraph.addEdge(0, 1, true);
		dGraph.addEdge(0, 2, true);
		dGraph.addEdge(1, 4, true);
		dGraph.addEdge(2, 4, true);
		dGraph.addEdge(4, 3, true);
		dGraph.addEdge(3, 5, true);
		
		new DFS().dfs(dGraph, 0);
		
		Graph g = new Graph(4); 
		  
		g.addEdge(0, 1, true); 
		g.addEdge(0, 2, true); 
		g.addEdge(1, 2, true); 
		g.addEdge(2, 0, true); 
		g.addEdge(2, 3, true); 
		g.addEdge(3, 3, true);
        
		new DFS().dfs(g, 2);

	}

	//Iterative - Using stack - starts from the given src
	private void dfs(Graph gfh, int src) {
		
		boolean visited[] = new boolean[gfh.V];
		
		Stack<Integer> st = new Stack<>();
		
		st.push(src);
		
		visited[src] = true;
		
		while(!st.isEmpty()) {
			
			int tmp = st.pop();
			
			if(!visited[tmp]) {
				System.out.print(tmp + "  ");
				visited[tmp] = true;
			}
			
			Iterator<Integer> it = gfh.adjList[tmp].listIterator();
			
			while(it.hasNext()) {
				int next = it.next();
				
				if(!visited[next]) {
					st.push(next);
				}
			}
		}
		
		System.out.println();
	}
	
}
