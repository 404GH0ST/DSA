/* Linked list node class */
class ListNode {
  int val; // Node value
  ListNode next; // Reference to next node

  ListNode(int x) { // Constructor
    val = x;
  }
}

public class linked_list {
  /* Insert node P after node n0 in the linked list */
  static void insert(ListNode n0, ListNode P) {
    ListNode n1 = n0.next;
    P.next = n1;
    n0.next = P;
  }

  /* Remove the first node after node n0 in the linked list */
  static void remove(ListNode n0) {
    if (n0.next == null) {
      return;
    }
    // n0 -> P -> n1
    ListNode P = n0.next;
    ListNode n1 = P.next;
    n0.next = n1;
  }

  /* Access the node at `index` in the linked list */
  static ListNode access(ListNode head, int index) {
    for (int i = 0; i < index; i++) {
      if (head == null) {
        return null;
      }

      head = head.next;
    }

    return head;
  }

  /* Search for the first node with value target in the linked list */
  static int find(ListNode head, int key) {
    int index = 0;
    while (head != null) {
      if (head.val == key) {
        return index;
      }
      head = head.next;
      index++;
    }
    return -1;
  }

  public static void main(String[] args) {
    /* Initialize linked list: 1 -> 3 -> 2 -> 5 -> 4 */
    // Initialize each node
    ListNode n0 = new ListNode(0);
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    // Build references between nodes
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    insert(n2, new ListNode(10));
    remove(n3);

    // Print the linked list
    ListNode head = n0;
    while (head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
    System.out.print("null");
    System.out.println();
  }
}
