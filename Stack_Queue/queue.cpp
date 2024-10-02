#include <stdio.h>
#include <queue>

using namespace std;

int main(int argc, char const *argv[])
{
    /* Initialize the queue */
    queue<int> queue;

    /* Enqueue elements into the queue */
    queue.push(1);
    queue.push(3);
    queue.push(2);
    queue.push(5);
    queue.push(4);

    /* Access the front element of the queue */
    int front = queue.front();
    printf("Front element is %d\n", front);

    /* Dequeue an element from the queue */
    queue.pop(); // No return value
    printf("Front element is %d\n", queue.front());

    /* Get the length of the queue */
    int size = queue.size();

    /* Check if the queue is empty */
    bool empty = queue.empty();
    return 0;
}