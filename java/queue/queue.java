import java.util.LinkedList;
import java.util.Queue;

public class queue {
  public static void main(String[] args) {
    /* Initialize the queue */
    Queue<Integer> queue = new LinkedList<>();

    /* Enqueue elements */
    queue.offer(1);
    queue.offer(3);
    queue.offer(2);
    queue.offer(5);
    queue.offer(4);

    /* Access the first element */
    int peek = queue.peek();

    /* Dequeue an element */
    int pop = queue.poll();

    /* Get the length of the queue */
    int size = queue.size();

    /* Check if the queue is empty */
    boolean isEmpty = queue.isEmpty();
  }
}
