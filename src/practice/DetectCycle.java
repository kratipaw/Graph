package practice;

import java.util.Arrays;
import java.util.Iterator;

public class DetectCycle {

	public static void main(String[] args) {

		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1, true); 
        g.addEdge(0, 2, true); 
        g.addEdge(1, 2, true); 
        g.addEdge(2, 0, true); 
        g.addEdge(2, 3, true); 
        g.addEdge(3, 3, true);
        
        System.out.println(hasCycle(g));
        
        Graph dGraph = new Graph(6);
		
        dGraph.addEdge(0, 1, true);
        dGraph.addEdge(0, 2, true);
        dGraph.addEdge(1, 4, true);
        dGraph.addEdge(2, 4, true);
        dGraph.addEdge(4, 3, true);
        dGraph.addEdge(3, 5, true);
		
        System.out.println(hasCycle(dGraph));
        
	}
	
	private static boolean hasCycle(Graph graph) {
		
		boolean visited[] = new boolean[graph.V];

		Arrays.fill(visited, false);
		
		boolean recurStack[] = new boolean[graph.V];
		
		Arrays.fill(recurStack, false);
		
		for (int i = 0; i < graph.V; i++) {
			
			if(isCyclic(graph, i, visited, recurStack))
				return true;
		}
		
		return false;
	}
	
	private static boolean isCyclic(Graph graph, int start, boolean visited[], boolean recurStack[]) {
		
		if(recurStack[start])
			return true;
		
		/*if (visited[start]) 
            return false;
		*/
		visited[start] = true;
		
		recurStack[start] = true;
		
		Iterator<Integer> it = graph.adjList[start].listIterator();
		
		while(it.hasNext()) {
			
			int num = it.next();
			if(isCyclic(graph, num, visited, recurStack)) {
				return true;
			}
		}
		
		recurStack[start] = false;

		return false;
	}

}
