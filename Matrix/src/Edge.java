public class Edge {
	public final Node start;
	public final Node end;
	public Edge(Node head, Node tail) {
		this.start = head;
		this.end = tail;
	}
	public String toString(){
		return start+"->"+end;
	}
}
