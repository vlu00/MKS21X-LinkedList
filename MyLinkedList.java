public class MyLinkedList {
  private int length;
  private Node start, end;

  public MyLinkedList() {
    length = 0;
    start= null;
    end = null;
  }

  public int size() {
    return length;
  }
  /**Adds a new element to the end of the list.
    *@param value  the element that will be added.
    */
  public boolean add (Integer value) {
    if (size() == 0) {
      Node A = new Node (null, value, end);
      start = A; //the start and end are the same
      end = A;
    }
    else {
      Node A = new Node(end, value, null);
      end.setNext(A); //the end changes
      end = A;
    }
    length++;
    return true;
  }
  /**Finds the Node at a particular index.
    *@param index  the index of the node you're trying to find.
    */
  private Node getNthNode (int index) {
    Node x = start; //starting with the first node
    for (;index > 0; index--) { //until index is reached
      x = x.next(); //move onto the next node
    }
    return x;
  }
  /**Returns Integer at particular index.
    *@param index index that you would like to check.
    */
  public Integer get(int index) {
    if (index < 0 || index > size()-1) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }
    return getNthNode(index).getData(); //return the Integer at the nth Node
  }
  /**Replaces Integer at index with new value.
    *@param index the index of the element you're replacing
    *@param value the new value with which you are replacing
    */
  public Integer set (int index, Integer value) {
    if (index < 0 || index > size()-1) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }
    Node x = getNthNode(index);
    Integer old = x.getData(); //save old Integer
    x.setData(value); //replace Integer
    return old; //return old Integer
  }
  /**Checks if list has a value.
    *@param value  the element you're checking if the list has
    */
  public boolean contains(Integer value) {
    Node current = start; //start with first node
    for (int i = 0; i < size(); i++) {
      if (current.getData().equals(value)) { //if the node is equal to the value
        return true; //the list contains the value
      }
      current = current.next(); //move onto next node
    }
    return false; //otherwise list does not contain value
  }
  /**Finds index of value in a list.
    *Returns index if value is in list. Otherwise returns -1.
    *@param value  the element that you're finding the index of.
    */
  public int indexOf(Integer value) {
    if (contains(value)) { //if the list has the value. find index
      Node current = start; //start with first node
      for (int i = 0; i < size(); i++) {
        if (current.getData().equals(value)) { //if the node is equal to the value
          return i; //return the node's index
        }
        current = current.next(); //check next node
      }
    }
    return -1; //if false return -1
  }
  /**Adds a value to a list at a specific index and shifts everything after the index to the right.
    *@param index index of where new value will be placed
    *@param value value of new element
    */
  public void add (int index, Integer value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }
    if (index == size()) {
      add(value);
    }
    else if (index == 0) {
      Node x = getNthNode(index); //current first node
      Node A = new Node(null, value, x);
      x.setPrev(A); //make the current first node's previous the new node
      start = A; //change the start to the new element
      length++;
    }
    else {
      Node x = getNthNode(index); //node before new node
      //Node y = getNthNode(index-1); //node after new node
      Node A = new Node(x.prev(), value, x);
      x.prev().setNext(A); //link the node after new node and new node
      x.setPrev(A); //link the node before new node and new node
      length++;
    }
  }
  /**Removes element at particular index.
    *@param index  index of element you're removing
    */
  private void baseRemove (Node x, int index) { //both removes will have this
    if (size() == 1) { //if list only has 1 element (one you're removing)
      start = null;//no start
      end = null;//no end
    }
    else { //if list is longer than 1
      if (index == 0) { //if removing the start
        Node y = x.prev();//second node in current list
        y.setPrev(null); //disconnect the first node from the second node
        x.setNext(null);
        start = y; //make the second node the start
      }
      else if (index == size()-1) { //if removing the end
        Node y = x.prev(); //second to last node
        x.setPrev(null); //disconnect the last node from the second to last node
        y.setNext(null);
        end = y; //the end the second to last node
      }
      else {
        Node y = x.prev(); //node before
        Node z = x.next(); //node after
        x.setPrev(null); //connect the node before and node after node bing removed
        x.setNext(null);
        y.setNext(z);
        z.setPrev(y);
      }
    }
    length--;
  }
  /**Removes an element based on index and returns the removed value.
    *@param index index of element you're removing
    */
  public Integer remove (int index) {
    if (index < 0 || index > size()-1) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }
    Node x = getNthNode(index); //node being removed
    Integer old = x.getData(); //save value being removed
    baseRemove(x, index); //remove node
    return old; //return removed value
  }
  /**Removes first instance of given value.
    *Returns false if the value is not in list.
    *@param value value of element you're removing
    */
  public boolean remove(Integer value) {
    if (!(contains(value))) { //if the list does not have the value
      return false;
    }
    else {
      int index = indexOf(value); //find index of value
      Node x = getNthNode(index);
      baseRemove(x, index); //remove the node at the index
    }
    return true;
  }
  /**Returns list of nodes as a string.
    */
  public String toString() {
    String s = "[";
    Node current = start;
    for (int i = 0; i < size(); i++) {
      if (!(current.equals(null)) && !(current.equals(end))) { //for any node that is not the end
        s = s + current.toString() + ", "; //include a comma afterwards
        current = current.next(); //move onto next node
      }
      else { //for the last node
        s = s + current.toString(); //do not include a comma
        current = current.next();
      }
    }
    return s+"]";
  }
}
