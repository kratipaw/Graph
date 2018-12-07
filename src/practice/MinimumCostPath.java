package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class MinimumCostPath {

	public static void main(String[] args) {

	}

	private static boolean isValid(int row, int col,int rows, int cols) {
		
		if(row >= 0 && row < rows && col >=0 && col < cols)
			return true;
		
		return false;
	}
	
	private static int minCostOfPath(int matrix[][], int rows, int cols) {
		
		int dist[][] = new int[rows][cols];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int rowNums[] = {1, -1, 0, 0};
		
		int colNums[] = {0, 0, 1, -1};
		
		TreeSet<Cell> set = new TreeSet<>();
		
		set.add(new Cell(0, 0, 0));
		
		dist[0][0] = matrix[0][0];
		
		while(!set.isEmpty()) {
			
			Cell curr = set.first();
			
			set.remove(curr);
			
			for (int i = 0; i < 4; i++) {
				
				int x = curr.x + rowNums[i];
				int y = curr.y + colNums[i];
				
				if(!isValid(x, y, rows, cols))
					continue;
				
				if(dist[curr.x][curr.y] + matrix[x][y] < dist[x][y]) {
					
					Cell cell;
					
					if(dist[x][y] != Integer.MAX_VALUE)
					{
						for (int j = 0; j < set.size(); j++) {
							
							if(curr.x == x && curr.y == y)
								//set.remove((curr.x == x))
						}
					}
					
					dist[x][y] = dist[curr.x][curr.y] + matrix[x][y];
					
					set.add(new Cell(x, y, dist[x][y]));
				}
				
			}
			
		}
	}
}

class Cell implements Comparable<Cell>{
	
	int x;
	int y;
	
	int dist;
	
	public Cell(int x, int y, int dist) {

		this.x = x;
		this.y = y;
		this.dist = dist;
	}


	@Override
	public int hashCode() {
		return this.x + this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
			return true;
		
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		
		Cell cell = (Cell) obj;
		
		return (cell.x == this.x && cell.y == this.y);
	}
	
	@Override
	public String toString() {
		return "{" + x + ", " + y + "}";
	}

	@Override
	public int compareTo(Cell o) {
		
		if(this.dist == o.dist) 
		{
			if(this.x != o.x) {
				if(this.x < o.x)
					return -1;
				else
					return 1;
			}
			else {
				if(this.y < o.y)
					return -1;
				else
					return 1;
			}
		}
		else if(this.dist < o.dist)
			return -1;
		else
			return 1;
	}
	
}
