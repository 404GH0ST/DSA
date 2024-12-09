#include <stdio.h>
#include <vector>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int val) : val(val), next(nullptr) {}
}

/* Stack class based on linked list */
class LinkedListStack
{
private:
    ListNode *stackTop; // Use the head node as the top of the stack
    int stkSize;        // Length of the stack

public:
    LinkedListStack()
    {
        stackTop = nullptr;
        stkSize = 0;
    }

    ~LinkedListStack()
    {
        // Traverse the linked list, remove nodes, free memory
        freeMemoryLinkedList(stackTop);
    }

    /* Get the length of the stack */
    int size()
    {
        return stkSize;
    }

    /* Determine if the stack is empty */
    bool isEmpty()
    {
        return size() == 0;
    }

    /* Push */
    void push(int num)
    {
        ListNode *node = new ListNode(num);
        node->next = stackTop;
        stackTop = node;
        stkSize++;
    }

    /* Pop */
    int pop()
    {
        int num = top();
        ListNode *tmp = stackTop;
        stackTop = stackTop->next;
        // Free memory
        delete tmp;
        stkSize--;
        return num;
    }

    /* Access stack top element */
    int top()
    {
        if (isEmpty())
            throw out_of_range("Stack is empty");
        return stackTop->val;
    }

    /* Convert the List to Array and return */
    vector<int> toVector()
    {
        ListNode *node = stackTop;
        vector<int> res(size());
        for (int i = res.size() - 1; i >= 0; i--)
        {
            res[i] = node->val;
            node = node->next;
        }
        return res;
    }
};

int main(int argc, char const *argv[])
{
    LinkedListStack stack;
    stack.push(1);
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(4);

    vector<int> res = stack.toVector();
    for (int i = 0; i < res.size(); i++)
    {
        printf("%d ", res[i]);
    }

    return 0;
}