@SuppressWarnings("ALL")
public class Graph {

	private final Node[] nodes;
	private final Edge[] edges;
	private final boolean[][] adj;
	
	/**
	 * An adjacency matrix representation of a graph. This graph assumes that edges are one-way
	 * (i.e.) a -> b is not the same as b -> a
	 * @param _nodes
	 * @param _edges
	 */
	public Graph(Node[] _nodes, Edge[] _edges){
		this.nodes = _nodes;
		this.edges = _edges;
		adj = new boolean[nodes.length][nodes.length];
		for (Edge edge : edges) {
			adj[edge.start.order][edge.end.order] = true;
		}
	}
	
	/**
	 * Finds the nodes adjacent to node N
	 * @param n The node the search shall be performed on
	 * @return A string containing the values of the nodes adjacent to node `n`
	 */
	public String getAdjacent(Node n) throws IllegalArgumentException {
		for(Node node : nodes) {
			if(node.equals(n)) {
				return getAdjacentInternal(node);
			}
		}
		throw new IllegalArgumentException("The given node is not present in this graph");
	}
	
	/**
	 * Implemented to increase legibillity of getAdjacent()
	 * @param n The node the search shall eb performed on
	 * @return A string containing the values of the nodes adjacent to node `n`
	 */
	private String getAdjacentInternal(Node n){
		String out = "";
		for(int i = 0; i < adj.length; i++){
			if(adj[n.order][i]) out += nodes[i].value + " ";
		}
		return out.strip();
	}
	
	/**
	 * @return Returns an array of nodes present in this graph
	 */
	public Node[] getNodesN() {return this.nodes;}
	
	/**
	 * @return Returns a list of nodes present in this graph as a string
	 */
	public String getNodes() {
		String out = "";
		for(Node n : nodes) {
			out += n.order + ": " + n.value + ", ";
		}
		out = out.substring(0, out.length()-2);
		return out;
	}
	
	/**
	 * @return An array of edges present in this graph
	 */
	public Edge[] getEdgesE(){return this.edges;}
	
	/**
	 * @return A list of edges present in this graph as a string
	 */
	public String getEdges() {
		String out = "";
		for(Edge e : edges) {
			out += e + " ";
		}
		return out.strip();
	}
	
	/**
	 * @return The graph visualized as a matrix in the form a string
	 */
	public String matrixString() {
		String out = "";
		for(boolean[] i : adj) {
			for(boolean j : i) {
				out += (j ? "X" : "-") + " ";
			}
			out += "\n";
		}
		return out;
	}
	
}
