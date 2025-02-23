import java.util.Stack;

public class stack {
  public static void main(String[] args) {
    /* Initialize the stack */
    Stack<Integer> stack = new Stack<>();

    /* Push elements onto the stack */
    stack.push(1);
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(4);

    /* Access the top element of the stack */
    int peek = stack.peek();

    /* Pop an element from the stack */
    int pop = stack.pop();

    /* Get the length of the stack */
    int size = stack.size();

    /* Check if the stack is empty */
    boolean isEmpty = stack.isEmpty();
  }
}
