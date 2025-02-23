/* Queue class based on linked list */
class LinkedListQueue {
  private ListNode front, rear; // Front node front, back node rear
  private int queSize = 0;

  public LinkedListQueue() {
    front = null;
    rear = null;
  }

  /* Get the length of the queue */
  public int size() {
    return queSize;
  }

  /* Determine if the queue is empty */
  public boolean isEmpty() {
    return size() == 0;
  }

  /* Enqueue */
  public void push(int num) {
    // Add num behind the tail node
    ListNode node = new ListNode(num);
    // If the queue is empty, make the head and tail nodes both point to that node
    if (front == null) {
      front = node;
      rear = node;
      // If the queue is not empty, add that node behind the tail node
    } else {
      rear.next = node;
      rear = node;
    }
    queSize++;
  }

  /* Dequeue */
  public int pop() {
    int num = peek();
    // Remove head node
    front = front.next;
    queSize--;
    return num;
  }

  /* Access front element */
  public int peek() {
    if (isEmpty()) throw new IndexOutOfBoundsException();
    return front.val;
  }

  /* Convert the linked list to Array and return */
  public int[] toArray() {
    ListNode node = front;
    int[] res = new int[size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = node.val;
      node = node.next;
    }
    return res;
  }
}
