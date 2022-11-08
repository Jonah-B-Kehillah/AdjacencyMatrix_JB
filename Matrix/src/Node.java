public class Node {
	public final int value;
	public final int order;
	
	/**
	 * The constructor for the Node() class
	 * @param _value The value contained in the node
	 * @param _order The location of the Node in a matrix representation
	 */
	public Node(int _value, int _order) {
		value = _value;
		order = _order;
	}
	public String toString(){
		return Integer.toString(value);
	}
	public boolean equals(Node n){
		return this.value == n.value && this.order == n.order;
	}
}
