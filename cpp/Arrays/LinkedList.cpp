#include <stdio.h>

/* Linked list node structure */
struct ListNode
{
    int val;                                   // Node value
    ListNode *next;                            // Pointer to the next node
    ListNode(int x) : val(x), next(nullptr) {} // Constructor
};

/* Insert node P after node n0 in the linked list */
void insert(ListNode *n0, ListNode *P)
{
    ListNode *n1 = n0->next;
    P->next = n1;
    n0->next = P;
}

/* Remove the first node after node n0 in the linked list */
void remove(ListNode *n0)
{
    if (n0->next == nullptr)
        return;
    // n0 -> P -> n1
    ListNode *P = n0->next;
    ListNode *n1 = P->next;
    n0->next = n1;
    // Free memory
    delete P;
}

/* Access the node at `index` in the linked list */
ListNode *access(ListNode *head, int index)
{
    for (int i = 0; i < index; i++)
    {
        if (head == nullptr)
            return nullptr;
        head = head->next;
    }
    return head;
}

/* Search for the first node with value target in the linked list */
int find(ListNode *head, int target)
{
    int index = 0;
    while (head != nullptr)
    {
        if (head->val == target)
        {
            return index;
        }
        head = head->next;
        index++;
    }

    return -1;
}

int main(int argc, char const *argv[])
{

    /* Initialize linked list: 1 -> 3 -> 2 -> 5 -> 4 */
    // Initialize each node
    ListNode *n0 = new ListNode(1);
    ListNode *n1 = new ListNode(3);
    ListNode *n2 = new ListNode(2);
    ListNode *n3 = new ListNode(5);
    ListNode *n4 = new ListNode(4);
    // Build references between nodes
    n0->next = n1;
    n1->next = n2;
    n2->next = n3;
    n3->next = n4;

    ListNode *n5 = new ListNode(7);
    insert(n2, n5);

    printf("0x%p\n", n5);
    printf("0x%p\n", n2->next);
    remove(n2); // remove the node after n2, replacing with the next node after n2
    printf("0x%p\n", n2->next);

    /* Access */
    ListNode *p = access(n0, 2);
    if (p != nullptr)
    {
        printf("0x%p\n", p);
    }

    /* Find */
    printf("Index of %d is %d\n", 5, find(n0, 5));
    return 0;
}