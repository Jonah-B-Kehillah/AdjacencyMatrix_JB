public class Edge {
	public final Node start;
	public final Node end;
	public Edge(Node _head, Node _tail) {
		this.start = _head;
		this.end = _tail;
	}
	public String toString(){
		return start+"->"+end;
	}
}
