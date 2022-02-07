/** 
* TITLE: LinkedList.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 
* PROJECT: Lab 15
* LAST MODIFIED: 11/19/2020
* DESCRIPTION: defins public class LinkedList<E>
*
* ALGORITHM:
* 
*/
public class LinkedList<E> {
    private class Node<E>{
        private E data; //stores only one data element
        private Node<E> next; //next node
        /**
         * No arguments constructor
         */
        public Node()
        {
            data = null;
            next = null;
        }
        /**
         * Two arguments constructor
         * @param newData data to be stored, generic type
         * @param nextNode next Node
         */
        public Node(E newData, Node nextNode)
        {
            data = newData;
            next = nextNode;

        }

    }//End of Node class

    private Node<E> head; //first Node in a list
    private Node<E> tail; //last Node in a list

    /**
     * No arguments constructor
     */
    public LinkedList()
    {
        head = null;
        tail = null;
    }
    /**
     * Adds Node to the beginning of the List
     * @param data data to be stored in the Node
     */
    public void addToStart(E element)
    {
        head = new Node<E>(element, head);
    }
    /**
     * Edds Node to the end of the List
     * @param E element element to be added
     */
    public void addToEnd(E element)
    {
        //Node temp  = header;
        //Creating the fisrt Node if the List is empty
        System.out.println(head);
        if(head == null)
        {
            head = new Node(element, head);
        }
        //Looking for the last Node if the List is not empty
        while(head.next != null){
             System.out.println("lena " + head.next);
            head = head.next;
          
        }
        //Inserting the Node at the end
        System.out.println("head after loop run " + head.next);
        head.next = new Node(element, null);
        //head = head.next;
        System.out.println("psina" + head);
        return;
        
        
    }
    /**
     * Adds the Node in particular index
     * Throws IndexOutOfBoundsException if the index < 0 || > List size 
     * @param index index where the element needs to be inserted
     * @param string Node data needs to be inserted
     * @return true if the element was inserted sucessfully 
     */
    public boolean add(int index, E element)
    {
        Node<E> newNode = new Node(element, head);
        
        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if(index  == size())
        {
            add(index, element);
            return true;
        }
        if(head == null && index > 0) return false;
        if(head == null && index == 0)
        {
            head = new Node(element, head);
            return true;
        }
        if(head != null && index == 0)
        {
            newNode.next = head;
            head = newNode;
            return true;
        }
        //Traversing the List looking for an index to insert a new Node
        //Moving from one Node to another with previouse node and current node
        Node<E> prev = null;
        Node<E> current = head;
        int i = 0;
        while(current != null && i < index)
        {
            current = prev;
            current = current.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return true;
    }
    /**
     * Adds the specified element to the end of this list.
     * Same as addToEnd()
     * @param E element element to be added
     */
    public boolean add(E element){
        //Create a new Node
        Node<E> newNode = new Node(element, null);
        //If the List is empty, create head  Node
        if (head == null)
            head = newNode;
        //Otherwise insert a new Node at the end
        else
            tail.next = newNode;
            //Moving the last Node from the tail to the newNode we just inserted
            tail = newNode;
            return true;
    }
    /**
     * Gets the Node form particular index in a List
     * Throws IndexOutOfBoundsException if the index > List size 
     * @param index index of Node need to get
     * @return returns the Node need to get
     */
    public E get(int index)
    {
        if(index > size()) throw new IndexOutOfBoundsException();
        if(index == 0){
            return (E) head;
        }
        Node<E> current = goTo(index);
        return (E) current.data; 
	}
    
    private Node<E> goTo(int index) {
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
    /**
     * Returns the number of elements in the List
     */
	public int size(){
        int count = 0;
        Node<E> position  = head;
        while(position != null){
            count++;
            position = position.next;
        }
        return count;

    }
    /**
     * Checks if the List contains the needed element
     * @param item element need to check
     * @return the element needed
     */
    public boolean contains(E element)
    {
        return (find(element) != null);
    }
    private Object find(E item) {
		return null;
    }
    /**
     * Replaces the element at the specified position in the List with the specified element.
     * @param index index of the element to be replaced
     * @param value new value to be inserted
     */
    public void set(int index, E value) {
        if(index > size()) throw new IndexOutOfBoundsException();
		Node<E> current = goTo(index);
		current.data = value;
    }
    /**
     * Returns the index of the first occurrence of the specified element in the List, 
     * or -1 if the List does not contain the element.
     * @param value value to look for
     * @return returns the index, returns -1 if the element is not in a List
     */
    public int indexOf(E value) {
		int index = 0;
		Node<E> current = head;
		while (current != null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
    }
    /**
     * Removes the element at the specified position in the List.
     * @param index index of the element to be removed
     */
    public void remove(int index) {
        if(index > size() || index < 0) throw new IndexOutOfBoundsException();
		if (index == 0) {
			// removing from the front
			head = head.next;
		} else {
			Node<E> current = goTo(index - 1);
			current.next = current.next.next;   // deletes the node
		}
    }
    /**
     * Removes the first occurrence of the specified element from the List, if it is present.
     * If this list does not contain the element, it is unchanged.
     * @param E element element to be removed
     * @return true if the List contains the specified element, false otherwise.
     */
    public boolean remove(E element)
    {
        remove(indexOf(element));
        return true;
    }
    /**
     * Prints out the List data
     */
	public String toString() {
		if (head == null) {
			return "[]";
		} else {
			String result = "[" + head.data;
			Node<E> current = head.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
    }
    /**
     * Removes all the elements from the List.
     */
    public void clear(){
        head = null;
    }
    
}
