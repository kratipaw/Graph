package practice;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {

	public static void main(String[] args) {

		int maze[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
						{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
						{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
						{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
						{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
						{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
						{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
						{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
						{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
					   };

		Point src = new Point(0, 0, 0);
			
		Point dest = new Point(3, 4, 0);

		System.out.println(shortestPath(maze, maze.length, maze[0].length, src, dest));
		
	}
	
	private static boolean isValid(int row, int col, int maze[][], int rows, int cols) {

        if(row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == 1)
               return true;

        return false;
	}
	
	private static int shortestPath(int maze[][], int rows, int cols, Point src, Point dest) {

     if(!isValid(src.x, src.y, maze, rows, cols) || !isValid(dest.x, dest.y, maze, rows, cols))
            return -1;

     boolean visited[][] = new boolean[rows][cols];

     for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
        	visited[i][j] = false;
        }
     }

     visited[src.x][src.y] = true;

     Queue<Point> qu = new LinkedList<Point>();

     qu.add(src);

     int rowNums[] = {1, -1, 0, 0};

     int colNums[] = {0, 0, -1, 1};

     while(!qu.isEmpty()) {

        Point curr = qu.poll();

        if(curr.x == dest.x && curr.y == dest.y)
              return curr.dist;

        for (int i = 0; i < 4; i++) {

          int row = curr.x + rowNums[i];

          int col = curr.y + colNums[i];

          if (isValid(row, col, maze, rows, cols) && !visited[row][col]) {

                 visited[row][col] = true;

                 qu.add(new Point(row, col, curr.dist + 1));
          }
        }
     }
     
     return -1;
  }

}

class Point{

    int x;
    int y;

    int dist;

    public Point(int x, int y, int dist) {

           this.x = x;
           this.y = y;
           this.dist = dist;
    }

}
