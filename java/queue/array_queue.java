/* Queue class based on circular array */
class ArrayQueue {
  private int[] nums; // Array for storing queue elements
  private int front; // Front pointer, pointing to the front element
  private int queSize; // Queue length

  public ArrayQueue(int capacity) {
    nums = new int[capacity];
    front = queSize = 0;
  }

  /* Get the capacity of the queue */
  public int capacity() {
    return nums.length;
  }

  /* Get the length of the queue */
  public int size() {
    return queSize;
  }

  /* Determine if the queue is empty */
  public boolean isEmpty() {
    return queSize == 0;
  }

  /* Enqueue */
  public void push(int num) {
    if (queSize == capacity()) {
      System.out.println("Queue is full");
      return;
    }
    // Calculate rear pointer, pointing to rear index + 1
    // Use modulo operation to wrap the rear pointer from the end of the array back to the start
    int rear = (front + queSize) % capacity();
    // Add num to the rear
    nums[rear] = num;
    queSize++;
  }

  /* Dequeue */
  public int pop() {
    int num = peek();
    // Move front pointer one position backward, returning to the head of the array if it exceeds
    // the tail
    front = (front + 1) % capacity();
    queSize--;
    return num;
  }

  /* Access front element */
  public int peek() {
    if (isEmpty()) throw new IndexOutOfBoundsException();
    return nums[front];
  }

  /* Return array */
  public int[] toArray() {
    // Only convert elements within valid length range
    int[] res = new int[queSize];
    for (int i = 0, j = front; i < queSize; i++, j++) {
      res[i] = nums[j % capacity()];
    }
    return res;
  }
}
