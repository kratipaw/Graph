package practice;

public class Main {

	public static void main(String[] args) {

		int v = 5;
		
		Graph gph = new Graph(v);
		
		gph.addEdge(0, 1, false);
		gph.addEdge(0, 4, false);
		gph.addEdge(1, 2, false);
		gph.addEdge(1, 3, false);
		gph.addEdge(1, 4, false);
		gph.addEdge(2, 3, false);
		gph.addEdge(3, 4, false);
		
		gph.printGraph();
	}

}
