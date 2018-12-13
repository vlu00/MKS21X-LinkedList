public class Node{
  private Integer data;
  private Node next, prev;

  public Node(Integer d) {
    data = d;
    prev = null;
    next = null;
  }
  public Node (Node p, Integer d, Node n) {
    prev = p;
    data = d;
    next = n;
  }

  public void setData(Integer value) {
    data = value;
  }

  public void setNext(Node name) {
    next = name;
  }

  public void setPrev(Node name) {
    prev = name;
  }

  public Integer getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }

  public String toString() {
    String s = "";
    s = s + data;
    return s;
  }
}
