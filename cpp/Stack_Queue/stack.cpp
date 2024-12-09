#include <stdio.h>
#include <stack>

using namespace std;

int main(int argc, char const *argv[])
{
    /* Initialize the stack */
    stack<int> stack;

    /* Push elements onto the stack */
    stack.push(1);
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(4);

    /* Access the top element of the stack */
    int top = stack.top();
    printf("Top element is %d\n", top);

    /* Pop an element from the stack */
    stack.pop(); // No return value
    printf("Top element is %d\n", stack.top());

    /* Get the length of the stack */
    int size = stack.size();

    /* Check if the stack is empty */
    bool empty = stack.empty();
    return 0;
}