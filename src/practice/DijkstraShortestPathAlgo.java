package practice;

import java.util.Arrays;

public class DijkstraShortestPathAlgo {

	public static void main(String[] args) {

		int matrix[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
		
		dijkstraSPT(matrix, 0);
		
	}
	
	private static void dijkstraSPT(int matrix[][], int src) {
		
		int n = matrix.length;
		
		boolean sptSet[] = new boolean[n];
		
		int dist[] = new int[n];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Arrays.fill(sptSet, false);
		
		dist[src] = 0;
		
		for (int i = 0; i < n-1; i++) {
			
			int u = minDistance(dist, sptSet);
			
			sptSet[u] = true;
			
			for (int v = 0; v < n; v++) {
				
				if(!sptSet[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && 
						dist[u] + matrix[u][v] < dist[v]) 
				{
					dist[v] = dist[u] + matrix[u][v];
				}
			}
		}
		
		printOutput(dist, sptSet);
	}
	
	private static int minDistance(int dist[], boolean sptSet[]) {
		
		int n = dist.length;
		
		int min = Integer.MAX_VALUE;
		
		int minIdx = -1;
		
		for (int i = 0; i < n; i++) {
			
			if(!sptSet[i] && dist[i] <= min) {
				
				min = dist[i];
				minIdx = i;
			}
		}
		
		return minIdx;
	}

	private static void printOutput(int dist[], boolean sptSet[]) {
		
		int n = dist.length;
		
		System.out.println("Vertix" + "\t\t" + "Distance from Source");
		
		for (int i = 0; i < n; i++) {
			
			System.out.println(i + "\t\t" + dist[i]);
			
		}
		
	}
}
