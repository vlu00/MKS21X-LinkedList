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
    return getNthNode(index).getData();
  }

  public String toString() {
    String s = "[";
    Node current = start;
    /*while (!(current.equals(null))) {
      if (!(current.equals(end))) {
        s = s + current.toString() + ", ";
      }
      else {
        s = s + current.toString();
      }
      current = current.Next();
    }*/

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
