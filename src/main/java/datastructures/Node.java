package datastructures;

public class Node<E> {
	private E data;
    private Node<E> nextNode;
    private Node<E> previousNode;
    
    public Node() {
    	super();
    	this.data = null;
    	this.nextNode=null;
    	this.previousNode=null;
    }
    public Node(E data) {
    	super();
    	this.data = data;
    	this.nextNode=null;
    	this.previousNode=null;
    }
    public Node(E data, Node<E> nextNode,Node<E> previousNode) {
    	super();
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }
    //Data
    public E getData() {
    	return this.data;
    }
    public void setData(E data) {
    	this.data = data;
    }
    //NextNode
    public Node<E> getNextNode(){
    	return this.nextNode;
    }
    
    public void setNextNode(Node<E> next) {
    	this.nextNode = next;
    }
    //PreviousNode
    public Node<E> getPreviousNode(){
    	return this.previousNode;
    }
    
    public void setPreviousNode(Node<E> previous) {
    	this.previousNode = previous;
    }
    public String toString() {
    	return "["+this.previousNode.getData()+","+this.data+","+this.nextNode.getData()+"]";
    }
}
