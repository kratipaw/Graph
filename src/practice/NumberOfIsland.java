package practice;

public class NumberOfIsland {

	public static void main(String[] args) {

		int matrix[][] = {{1, 1, 0, 0, 0}, 
                {0, 1, 0, 0, 1}, 
                {1, 0, 0, 1, 1}, 
                {0, 0, 0, 0, 0}, 
                {1, 0, 1, 0, 1}};
		
		int n = matrix.length;
		
		System.out.println(countIsland(matrix, n));
		
	}

	private static int countIsland(int matrix[][], int n) {
		
		boolean visited[][] = new boolean[n][n];
		
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(matrix[i][j] == 1 && (!visited[i][j])) {
					
					count++;
					
					DFSUtil(matrix, i, j, n, visited);
				}
			}
		}
		
		return count;
	}
	
	private static void DFSUtil(int matrix[][], int row, int col, int n, boolean visited[][]) {
		
		visited[row][col] = true;
		
		int rows[] = {1, 1, 1, 0, 0, -1, -1, -1};
		int cols[] = {0, -1, 1, 1, -1, -1, 0, 1};
		
		for (int i = 0; i < 8; i++) {
			
			if(isValid(matrix, row + rows[i], col + cols[i], n, visited))
				DFSUtil(matrix, row + rows[i], col + cols[i], n, visited);
		}
	}
	
	private static boolean isValid(int matrix[][], int row, int col, int n, boolean visited[][]) {
		
		if(row >= 0 && row < n && col >= 0 && col < n && matrix[row][col] == 1 && (!visited[row][col]))
			return true;
		
		return false;
		
	}
}
