public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
    start= null;
    end = null;
  }

  public int size() {
    return size;
  }

  public boolean add (Integer value) {
    if (size() == 0) {
      Node A = new Node (null, value, end);
      start = A;
      end = A;
    }
    else {
      Node A = new Node(end, value, null);
      end.setNext(A);
      end = A;
    }
    size++;
    return true;
  }

  public String toString() {
    String s = "";
    Node current = start;
    for (int i = 0; i < size(); i++) {
      if (!(current.getNext().equals(null))) {
        s = s + current.getData();
        current = current.getNext();
      }
      else {
        s = s + current.getData();
      }
    }
    return s;
  }
}
