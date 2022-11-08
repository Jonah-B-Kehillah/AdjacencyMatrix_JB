public class Main {
	
	private static int passes = 0;
	private static int fails  = 0;
	
	@SuppressWarnings("ThrowablePrintedToSystemOut")
	public static void main(String[] args) {
		
		Node[] nodes = new Node[10];
		Edge[] edges = new Edge[10*10];
		for(int i = 0; i<10; i++) nodes[i] = new Node(i, i);
		for(int i = 0; i<10; i++)for(int j = 0; j<10; j++) edges[i*10+j] = new Edge(new Node(i, i), new Node(j, j));
		Graph g1 = new Graph(nodes, edges);
		
		// testing matrix representation for filled graph
		try {
			String all = "X X X X X X X X X X \n".repeat(10);
			String str = g1.matrixString() + "";
			if (str.equals(all)) passes++;
			else {
				fails++;
				System.out.println("Filled graph representation failed");
			}
		} catch (Exception err) {
			System.out.println("Filled graph representation failed with error");
			System.err.println(err);
		}
		
		// testing get adjacent for filled graph
		try {
			int a = 0;
			for (Node n : g1.getNodesN()) {
				if (g1.getAdjacent(n).equals("0 1 2 3 4 5 6 7 8 9")) a++;
			}
			if (a == 10) passes++;
			else {
				fails++;
				System.out.println("Filled graph adjacency failed");
			}
		} catch (Exception err) {
			System.out.println("Filled graph adjacency failed with error");
			System.err.println(err);
		}
		
		// testing bipartite graph
		try {
			if (testBipartiteGraph()) passes++;
			else {
				fails++;
				System.out.println("Bipartite graph failed");
			}
		} catch (Exception err) {
			System.out.println("Bipartite graph failed with error");
			System.out.println(err);
		}
		
		// testing graph where only some nodes are connected
		try {
			if (testExampleGraph()) passes++;
			else {
				fails++;
				System.out.println("Partial graph failed");
			}
		} catch(Exception err){
			System.out.println("Partial graph failed with error");
			System.out.println(err);
		}
		
		// testing graph where no nodes are connected
		try {
			if (testEmptyGraph()) passes++;
			else {
				fails++;
				System.out.println("Empty graph failed");
			}
		} catch(Exception err) {
			System.out.println("Empty graph failed with error");
			System.out.println(err);
		}
		
		
		System.out.printf("%s tests passed, %s tests failed; %s total tests%n",
				passes, fails, passes+fails);
	}
	
	private static boolean testBipartiteGraph(){
		
		Node u1 = new Node(1, 0);
		Node u2 = new Node(2, 1);
		Node u3 = new Node(3, 2);
		Node u4 = new Node(4, 3);
		Node v1 = new Node(21, 4);
		Node v2 = new Node(22, 5);
		Node v3 = new Node(23, 6);
		Node v4 = new Node(24, 7);
		
		Edge e1 = new Edge(u1, v1);
		Edge e2 = new Edge(u1, v2);
		Edge e3 = new Edge(u1, v4);
		Edge e4 = new Edge(u2, v2);
		Edge e5 = new Edge(u2, v3);
		Edge e6 = new Edge(u3, v1);
		Edge e7 = new Edge(u3, v2);
		Edge e8 = new Edge(u3, v3);
		Edge e9 = new Edge(u3, v4);
		Edge e10= new Edge(u4, v3);
		Edge e11= new Edge(u4, v4);
		
		Node[] n = {u1, u2, u3, u4, v1, v2, v3, v4};
		Edge[] e = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11};
		Graph g = new Graph(n, e);
		
		return g.getAdjacent(u1).equals("21 22 24") &&
				g.getAdjacent(u2).equals("22 23")  &&
				g.getAdjacent(u3).equals("21 22 23 24") &&
				g.getAdjacent(u4).equals("23 24");
	}
	private static boolean testExampleGraph() {
		Node[] nodes = {new Node(1, 0), new Node(2, 1), new Node(3, 2)};
		Edge[] edges = {new Edge(nodes[1], nodes[0]), new Edge(nodes[0], nodes[2]), // 2->1 and 1->3
						new Edge(nodes[0], nodes[1]), new Edge(nodes[1], nodes[2])};// 1->2 and 2->3
		Graph g = new Graph(nodes, edges);
		return g.getAdjacent(new Node(1, 0)).equals("2 3") &&
				g.getAdjacent(new Node(2, 1)).equals("1 3") &&
				g.getAdjacent(new Node(3,2)).equals("");
	}
	private static boolean testEmptyGraph() {
		Node[] nodes = {new Node(1, 0), new Node(2, 1), new Node(3, 2)};
		Edge[] edges = {};
		Graph g = new Graph(nodes, edges);
		return g.getAdjacent(new Node(1, 0)).equals("") &&
				g.getAdjacent(new Node(2, 1)).equals("") &&
				g.getAdjacent(new Node(3,2)).equals("");
	}
	
}
