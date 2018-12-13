public class MyDriver{
  public static void main (String[] args) {
    Node A = new Node (1);
    Node B = new Node (2);
    Node C = new Node (3);
    System.out.println(A);
    System.out.println(B);
    System.out.println(C);
    MyLinkedList a = new MyLinkedList();
    System.out.println(a.size());
    Integer b = new Integer(5);
    a.add(b); 
  }
}
