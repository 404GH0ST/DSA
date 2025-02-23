import java.util.ArrayList;

/* Stack class based on array */
class ArrayStack {
  private ArrayList<Integer> stack;

  public ArrayStack() {
    // Initialize the list (dynamic array)
    stack = new ArrayList<>();
  }

  /* Get the length of the stack */
  public int size() {
    return stack.size();
  }

  /* Determine if the stack is empty */
  public boolean isEmpty() {
    return size() == 0;
  }

  /* Push */
  public void push(int num) {
    stack.add(num);
  }

  /* Pop */
  public int pop() {
    if (isEmpty()) throw new IndexOutOfBoundsException();
    return stack.remove(size() - 1);
  }

  /* Access stack top element */
  public int peek() {
    if (isEmpty()) throw new IndexOutOfBoundsException();
    return stack.get(size() - 1);
  }

  /* Convert the List to Array and return */
  public Object[] toArray() {
    return stack.toArray();
  }
}
