import java.util.Deque;
import java.util.LinkedList;

public class deque {
  public static void main(String[] args) {
    /* Initialize the deque */
    Deque<Integer> deque = new LinkedList<>();

    /* Enqueue elements */
    deque.offerLast(2); // Add to the tail
    deque.offerLast(5);
    deque.offerLast(4);
    deque.offerFirst(3); // Add to the head
    deque.offerFirst(1);

    /* Access elements */
    int peekFirst = deque.peekFirst(); // The first element
    int peekLast = deque.peekLast(); // The last element

    /* Dequeue elements */
    int popFirst = deque.pollFirst(); // The first element dequeued
    int popLast = deque.pollLast(); // The last element dequeued

    /* Get the length of the deque */
    int size = deque.size();

    /* Check if the deque is empty */
    boolean isEmpty = deque.isEmpty();
  }
}
