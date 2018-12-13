public class Node{
  private int data;
  private Node next, prev;

  public Node(int d) {
    data = d;
    prev = null;
    next = null;
  }
  public Node (Node p, int d, Node n) {
    prev = p;
    data = d;
    next = n;
  }

  public void setData(int value) {
    data = value;
  }

  public void setNext(Node name) {
    next = name;
  }

  public void setPrev(Node name) {
    prev = name;
  }

  public int getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }
}
