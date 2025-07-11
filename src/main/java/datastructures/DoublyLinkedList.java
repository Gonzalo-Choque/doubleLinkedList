package datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@SuppressWarnings("serial")
public class DoublyLinkedList<E> extends LinkedList<E> {

    //TODO Implement `ALL` the methods for a Doubly Linked List
	private Node<E> root;
	private Node<E> last;
	private int count;
    /**
     * Constructs an empty list.
     */
    public DoublyLinkedList() {
        //super();
        this.root = null;
        this.last = null;
        this.count = 0;
    }
    
    
    private boolean empty() {//verificado
    	return this.root == null;
    }
    
    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E getFirst() throws NoSuchElementException{//verificado
        //TODO complete here
    	if(this.count==0) {
    		throw new NoSuchElementException();
    	}
        return this.root.getData();
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E getLast() throws NoSuchElementException{//verificado
        //TODO complete here
    	if(this.empty()==true) {
    		throw new NoSuchElementException();
    	}
        return this.last.getData();
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E removeFirst() throws NoSuchElementException{//verificado
        //TODO complete here
    	if(this.count==0) {
    		throw new NoSuchElementException();
    	}
    	else {
    		E first = this.root.getData();
    		this.root = this.root.getNextNode();
    		this.root.setPreviousNode(null);
    		this.count--;
    		return first;
    	}
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E removeLast() {//verificado
        //TODO complete here
    	if(this.count==0) {
    		throw new NoSuchElementException();
    	}
    	else {
    		E last = this.last.getData();
    		this.last = this.last.getPreviousNode();
    		this.last.setNextNode(null);
    		this.count--;
    		return last;
    	}
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    @Override
    public void addFirst(E e) {//verificado
        //TODO complete here
    	if(this.count==0) {
    		this.root = new Node<E>(e);
    		this.last =new Node<E>(e);
    		this.count++;
    	}
    	else if(this.count==1) {
    		this.root = new Node<E>(e);
    		this.root.setNextNode(this.last);
    		this.last.setPreviousNode(this.root);
    		this.count++;
    	}
    	else {
    		Node <E> iter = this.root;
    		this.root = new Node<E>(e);
    		this.root.setNextNode(iter);
    		iter.setPreviousNode(this.root);
    		this.count++;
    		/*if(this.count>2) {//era para ver si se estaban imprimiendo
    			int top = this.count;
    			Node<E> iterPrint = this.root.getNextNode();
    			while(top>2) {
        			iterPrint=iterPrint.getNextNode();
        			top--;
        		}
    		}*/
    	}
    }

    /**
     * Appends the specified element to the end of this list.
     * <p>
     * This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     */
    @Override
    public void addLast(E e) {//verificado
        //TODO complete here
    	if(this.count==0) {
    		this.root = new Node<E>(e);
    		this.last =new Node<E>(e);
    		this.count++;
    	}
    	else if(this.count==1) {
    		this.last = new Node<E>(e);
    		this.last.setPreviousNode(this.root);
    		this.root.setNextNode(this.last);
    		this.count++;
    	}
    	else {
    		Node <E> iter = this.last;
    		this.last = new Node<E>(e);
    		this.last.setPreviousNode(iter);
    		iter.setNextNode(this.last);
    		this.count++;
    		/*if(this.count>2) {
    			int top = this.count;
    			Node<E> iterPrint = this.root.getNextNode();
    			while(top>2) {
        			iterPrint=iterPrint.getNextNode();
        			top--;
        		}
    		}*/
    	}
    }

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains
     * at least one element 'o'
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * false, otherwise
     */
    @Override
    public boolean contains(Object o) {//verificado
        //TODO complete here
    	if(this.count==0) {
    		return false;
    	}
    	else {
    		Node <E> iter = this.root;
    		for(int i = 0; i<this.count; i++) {
    			if(o.equals(iter.getData())) {
    				return true;
    			}
    			iter=iter.getNextNode();
    		}
    	}
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {//Verificado
        //TODO complete here
        return this.count;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @param e element to be appended to this list
     * @return true if list is modified after perform append the element
     * false if definition of list does not allow duplicated elements
     * Note: for this case always return true
     */
    @Override
    public boolean add(E e) {//Verificado
        //TODO complete here
    	addLast(e);
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index i
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {//Verificado
        //TODO complete here
    	if(contains(o)==true) {
    		Node <E> iter = this.root;
    		int i=0;
    		while(i<this.count) {
    			if(o.equals(this.root.getData())==true) {
    				removeFirst();
    				return true;
    			}
    			else if(o.equals(this.last.getData())==true) {
    				removeLast();
    				return true;
    			}
    			if(o.equals(iter.getData())==true) {
    				Node <E> previous = iter.getPreviousNode();
    				Node <E> next = iter.getNextNode();
    				previous.setNextNode(next);
    				next.setPreviousNode(previous);
    				this.count--;
    				return true;
    			}
    			i++;
    			if(i==this.count) return false;
    			iter=iter.getNextNode();
    		}
    	}
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) throws NullPointerException{
        //TODO complete here
    	
    	if(c.isEmpty()==true) {
    		throw new NullPointerException();
    	}
    	else {
    		if(this.count==0){
    			for(E e: c){
    				add(e);
    			}
    		}
    		else {
    			DoublyLinkedList<E> dll = (DoublyLinkedList<E>) c;
    			this.last.setNextNode(dll.root);
    			dll.root.setPreviousNode(last);
    			this.last=dll.last;
        		this.count = this.count+dll.size();
    			/*
    			Node<E>iter=dll.root;
    			for(int i=0;i<c.size();i++) {
    				add(iter.getData());
    				iter=iter.getNextNode();
    			}
    			*/
    		}
    		return true;
    	}
    }
    

    /**
     * Inserts all of the elements in the specified collection into this
     * list, starting at the specified position.  Shifts the element
     * currently at that position (if any) and any subsequent elements to
     * the right (increases their indices).
     *
     * @param index index at which to insert the first element
     *              from the specified collection
     * @param c     collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if index to be inserted is not found
     * @throws NullPointerException      if the specified collection is null
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {//no implementado
        //TODO complete here
        return false;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {//verificado
        //TODO complete here
    	this.root = null;
    	this.last = null;
    	this.count = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException{//verificado
        //TODO complete here
    	if(index>=this.count) {
    		throw new IndexOutOfBoundsException();
    	}
    	else {
    		Node <E> iter = this.root;
    		for(int i = 0; i<index; i++) {
    			iter=iter.getNextNode();
    		}
    		return iter.getData();
    	}
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException{//verificado
        //TODO complete here
    	if(index>=this.count) {
    		throw new IndexOutOfBoundsException();
    	}
    	else {
    		Node <E> iter = this.root;
    		for(int i = 0; i<index; i++) {
    			iter=iter.getNextNode();
    		}
    		E elementPreviously = iter.getData();
    		iter.setData(element);
    		return elementPreviously;
    	}
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException{//Verificado
        //TODO complete here
    	if(index>=this.count) {
    		throw new IndexOutOfBoundsException();
    	}
    	else {
    		if(index==0) {
    			addFirst(element);
    		}
    		else if(index==this.count) {
    			addLast(element);
    		}
    		else {
    			Node <E> iter = this.root;
        		for(int i = 0; i<index; i++) {
        			iter=iter.getNextNode();
        		}
        		Node<E> nuevo = new Node<E>(element);
        		Node<E> previous=iter.getPreviousNode();
        		nuevo.setNextNode(iter);
        		nuevo.setPreviousNode(previous);
        		iter.setPreviousNode(nuevo);
        		previous.setNextNode(nuevo);
        		this.count++;
    		}
    	}
    }

    /**
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index does not exist
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException{//verificado
        //TODO complete here
    	if(index>this.size()) {
    		throw new IndexOutOfBoundsException();
    	}
    	else {
    		Node <E> iter = this.root;
    		int pos = 0;
    		for(int i = 0; i<index-1; i++) {
    			iter=iter.getNextNode();
    			pos++;
    		}
    		E elementPreviously;
    		if(pos==0) {
    			elementPreviously=removeFirst();
    		}
    		else if(pos==this.size()-1){
    			elementPreviously=removeLast();
    		}
    		else{
    			elementPreviously = iter.getData();
    			iter.getPreviousNode().setNextNode(iter.getNextNode());
        		iter.getNextNode().setPreviousNode(iter.getPreviousNode());
        		this.count--;
    		}
    		return elementPreviously;
    	}
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {//Verificado
        //TODO complete here
    	int num=0;
    	Node <E> iter = this.root;
    	if(this.count==0) return -1;//vacio
    	
    	while(o.equals(iter.getData())!=true && num<this.count) {
    		num++;
    		if(num==this.count) return -1;// no se encontro
    		iter=iter.getNextNode();
    	}
    	return num;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {//Verificado
        //TODO complete here
    	int num=this.count-1;
    	Node <E> iter = this.last;
    	if(num>=0) {
    		while(o.equals(iter.getData())!=true && num>=0) {
    			num--;
    			if(num==-1) return -1;
    			iter=iter.getPreviousNode();
        	}
    		return num;
    	}
    	else return -1;//vacio
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    @Override
    public E peek() {//verificado
        //TODO complete here
    	if(this.count==0) {
    		return null;
    	}
    	else {
    		return this.root.getData();
    	}	
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E element() throws NoSuchElementException{//verificado
        //TODO complete here
    	if(this.root==null) {
    		throw new NoSuchElementException();
    	}
    	else{
    		return this.root.getData();
    	}
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    @Override
    public E poll() {//verificado
        //TODO complete here
    	if(this.root==null) {
    		return null;
    	}
    	else{
    		return removeFirst();
    	}
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E remove() throws NoSuchElementException{//verificado
        //TODO complete here
    	if(this.root==null) {
    		throw new NoSuchElementException();
    	}
    	else{
    		E iter = removeFirst();
    		return iter;
    	}
    }

    /**
     * Adds the specified element as the tail (last element) of this list.
     *
     * @param e the element to add
     * @return true if the element was added to the list
     * false, otherwise
     */
    @Override
    public boolean offer(E e) {//verificado
        //TODO complete here
        addLast(e);
    	return true;
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param e the element to insert
     * @return true if element was inserted
     * false, otherwise
     */
    @Override
    public boolean offerFirst(E e) {//verificado
        //TODO complete here
    	addFirst(e);
        return super.offerFirst(e);
    }

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param e the element to insert
     * @return true if element was inserted
     * false, otherwise
     */
    @Override
    public boolean offerLast(E e) {//verificado
        //TODO complete here
    	addLast(e);
        return super.offerLast(e);
    }

    /**
     * Retrieves, but does not remove, the first element of this list,
     * or returns null if this list is empty.
     *
     * @return the first element of this list, or null
     * if this list is empty
     */
    @Override
    public E peekFirst() {//verificado
        //TODO complete here
    	if(this.count==0) {
    		return null;
    	}
    	else{
    		return this.root.getData();
    	}
    }

    /**
     * Retrieves, but does not remove, the last element of this list,
     * or returns null if this list is empty.
     *
     * @return the last element of this list, or  null
     * if this list is empty
     */
    @Override
    public E peekLast() {//verificado
        //TODO complete here
    	if(this.count==0) {
    		return null;
    	}
    	else{
    		return this.last.getData();
    	}
    }

    /**
     * Retrieves and removes the first element of this list,
     * or returns null if this list is empty.
     *
     * @return the first element of this list, or null if
     * this list is empty
     */
    @Override
    public E pollFirst() {//verificado
        //TODO complete here
    	if(this.count==0) {
    		return null;
    	}
    	else{
    		return removeFirst();
    	}
    }

    /**
     * Retrieves and removes the last element of this list,
     * or returns null if this list is empty.
     *
     * @return the last element of this list, or null if
     * this list is empty
     */
    @Override
    public E pollLast() {//verificado
        //TODO complete here
    	if(this.count==0) {
    		return null;
    	}
    	else{
    		return removeLast();
    	}
    }

    /**
     * Pushes an element onto the stack represented by this list.  In other
     * words, inserts the element at the front of this list.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     */
    @Override
    public void push(E e) {//verificado
        //TODO complete here
    	addFirst(e);
    }

    /**
     * Pops an element from the stack represented by this list.  In other
     * words, removes and returns the first element of this list.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this list (which is the top
     * of the stack represented by this list)
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E pop() throws NoSuchElementException{//verificado
        //TODO complete here
    	if(this.root==null) {
    		throw new NoSuchElementException();
    	}
    	else return removeFirst();
    }

    /**
     * Removes the first occurrence of the specified element in this
     * list (when traversing the list from head to tail).  If the list
     * does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return true if the list contained the specified element
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {//verificado
        //TODO complete here
    	int posicion = indexOf(o);
		if(posicion != -1){
			remove(posicion);
			return true;
		}
		return false;
    }

    /**
     * Removes the last occurrence of the specified element in this
     * list (when traversing the list from head to tail).  If the list
     * does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return true if the list contained the specified element
     */
    @Override
    public boolean removeLastOccurrence(Object o) {//verificado
        //TODO complete here
		int posicion = lastIndexOf(o);
		if(posicion != -1) {
			remove(posicion+1);
			return true;
		}
		return false;
    }
}
