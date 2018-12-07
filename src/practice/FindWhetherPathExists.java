package practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FindWhetherPathExists {

	public static void main(String[] args) {

		int matrix[][] = {{ 0 , 3 , 0 , 1 }, 
		        			{ 3 , 0 , 3 , 3 }, 
		        			{ 2 , 3 , 3 , 3 }, 
		        			{ 0 , 3 , 3 , 3 }
						};
		
		System.out.println(isPathExists(matrix, matrix.length));
		
	}
	
	private static boolean isValid(int row, int col, int matrix[][], int n) {
		
		if(row < 0 || row >= n || col < 0 || col >= n || matrix[row][col] == 0)
			return false;
		
		return true;
	}

	private static boolean isPathExists(int matrix[][], int n) {
		
		int v = n * n + 1;
		
		Graph graph = new Graph(v);
		
		int src = 0;
		
		int dest = 0;
		
		int k = 0;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				if(matrix[i][j] != 0) {
					
					if(isValid(i, j+1, matrix, n))
						graph.addEdge(k, k+1, false);
					
					if(isValid(i, j-1, matrix, n))
						graph.addEdge(k, k-1, false);
					
					if(isValid(i+1, j, matrix, n))
						graph.addEdge(k, k+n, false);
					
					if(isValid(i-1, j, matrix, n))
						graph.addEdge(k, k-n, false);
				}
				
				if(matrix[i][j] == 1)
					src = k;
				
				if(matrix[i][j] == 2)
					dest = k;
				
				k++;
			}
		}
		
		return bfsUtil(graph, src, dest);
	}
	
	private static boolean bfsUtil(Graph graph, int src, int dest) {
		
		if(src == dest)
			return true;
		
		boolean visited[] = new boolean[graph.V];
		
		Arrays.fill(visited, false);
		
		Queue<Integer> qu = new LinkedList<Integer>();
		
		visited[src] = true;
		
		qu.add(src);
		
		while(!qu.isEmpty()) {
			
			int tmp = qu.poll();
			
			Iterator<Integer> it = graph.adjList[tmp].listIterator();
			
			while(it.hasNext()) {
				
				int t = it.next();
				
				if(t == dest)
					return true;
				
				if(!visited[t]) {
					
					visited[t] = true;
					qu.add(t);
				}
				
			}
			
		}
		
		return false;
	}
	
}
