#include <stdio.h>
#include <deque>

using namespace std;

int main(int argc, char const *argv[])
{
    /* Initialize the deque */
    deque<int> deque;

    /* Enqueue elements */
    deque.push_back(2); // Add to the tail
    deque.push_back(5);
    deque.push_back(4);
    deque.push_front(3); // Add to the head
    deque.push_front(1);

    /* Access elements */
    int front = deque.front(); // The first element
    int back = deque.back();   // The last element

    /* Dequeue elements */
    deque.pop_front(); // The first element dequeued
    deque.pop_back();  // The last element dequeued

    /* Get the length of the deque */
    int size = deque.size();

    /* Check if the deque is empty */
    bool empty = deque.empty();
    return 0;
}
