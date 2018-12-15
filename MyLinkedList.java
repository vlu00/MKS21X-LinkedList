public class MyLinkedList {
  private int length;
  private Node start, end;

  public MyLinkedList() {
    length = 0;
    start= null;
    end = null;
  }

  public int length() {
    return length;
  }

  public boolean add (Integer value) {
    if (length() == 0) {
      Node A = new Node (null, value, end);
      start = A;
      end = A;
    }
    else {
      Node A = new Node(end, value, null);
      end.setNext(A);
      end = A;
    }
    length++;
    return true;
  }

  private Node getNthNode (int index) {
    Node x = start;
    for (;index > 0; index--) {
      x = x.Next();
    }
    return x;
  }

  public Integer get(int index) {
    if (index < 0 || index > length()-1) {
      throw new IllegalArgumentException("Index is out of range");
    }
    return getNthNode(index).getData();
  }

  public Integer set (int index, Integer value) {
    if (index < 0 || index > length()-1) {
      throw new IllegalArgumentException("Index is out of range");
    }
    Node x = getNthNode(index);
    Integer old = x.getData();
    x.setData(value);
    return old;
  }

  public boolean contains(Integer value) {
    Node current = start;
    for (int i = 0; i < length(); i++) {
      if (current.getData() == value) {
        return true;
      }
      current = current.Next();
    }
    return false;
  }

  public int indexOf(Integer value) {
    Node current = start;
    for (int i = 0; i < length(); i++) {
      if (current.getData() == value) {
        return i;
      }
      current = current.Next();
    }
    return -1; 
  }

  public String toString() {
    String s = "[";
    Node current = start;
    /*
    while (!(current.Next().equals(null))) {
        s = s + current.toString() + ", ";
        current = current.Next();
    }
    s = s + current.toString();
    */
    for (int i = 0; i < length(); i++) {
      if (!(current.equals(null)) && !(current.equals(end))) {
        s = s + current.toString() + ", ";
        current = current.Next();
      }
      else if (!(current.equals(null))) {
        s = s + current.toString();
        current = current.Next();
      }
    }
    return s+"]";
  }
}
