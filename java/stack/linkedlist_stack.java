/* Linked list node class */
class ListNode {
  int val; // Node value
  ListNode next; // Reference to next node

  ListNode(int x) { // Constructor
    val = x;
  }
}

/* Stack class based on linked list */
class LinkedListStack {
  private ListNode stackPeek; // Use the head node as the top of the stack
  private int stkSize = 0; // Length of the stack

  public LinkedListStack() {
    stackPeek = null;
  }

  /* Get the length of the stack */
  public int size() {
    return stkSize;
  }

  /* Determine if the stack is empty */
  public boolean isEmpty() {
    return size() == 0;
  }

  /* Push */
  public void push(int num) {
    ListNode node = new ListNode(num);
    node.next = stackPeek;
    stackPeek = node;
    stkSize++;
  }

  /* Pop */
  public int pop() {
    int num = peek();
    stackPeek = stackPeek.next;
    stkSize--;
    return num;
  }

  /* Access stack top element */
  public int peek() {
    if (isEmpty()) throw new IndexOutOfBoundsException();
    return stackPeek.val;
  }

  /* Convert the List to Array and return */
  public int[] toArray() {
    ListNode node = stackPeek;
    int[] res = new int[size()];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = node.val;
      node = node.next;
    }
    return res;
  }
}
