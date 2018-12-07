package gfg_mustDoCodingQuestions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
		
		new BFS().bfs(graph, 0);
		
		Graph dGraph = new Graph(6);
		
		dGraph.addEdge(0, 1, true);
		dGraph.addEdge(0, 2, true);
		dGraph.addEdge(1, 4, true);
		dGraph.addEdge(2, 4, true);
		dGraph.addEdge(4, 3, true);
		dGraph.addEdge(3, 5, true);
		
		new BFS().bfs(dGraph, 0);
	}
	
	//Iterative BFS - Using Queue 
	//Starting from given node
	private void bfs(Graph gfh, int src) {
		
		Queue<Integer> qu = new LinkedList<>();
		
		boolean visited[] = new boolean[gfh.V];
	
		qu.add(src);
		visited[src] = true;
		
		while(!qu.isEmpty()) {
			
			int tmp = qu.poll();
			System.out.print(tmp + "  ");
			
			Iterator<Integer> it = gfh.adjList[tmp].listIterator();
			
			while(it.hasNext()) {
				
				int next = it.next();
				
				if(!visited[next]) {
					qu.add(next);
					visited[next] = true;
				}
			}
		}
		
		System.out.println();
	}
}
