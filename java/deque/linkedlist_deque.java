/* Double-linked list node */
class ListNode {
    int val; // Node value
    ListNode next; // Reference to successor node
    ListNode prev; // Reference to predecessor node

    ListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}

/* Double-ended queue class based on double-linked list */
class LinkedListDeque {
    private ListNode front, rear; // Front node front, back node rear
    private int queSize = 0; // Length of the double-ended queue

    public LinkedListDeque() {
        front = rear = null;
    }

    /* Get the length of the double-ended queue */
    public int size() {
        return queSize;
    }

    /* Determine if the double-ended queue is empty */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* Enqueue operation */
    private void push(int num, boolean isFront) {
        ListNode node = new ListNode(num);
        // If the list is empty, make front and rear both point to node
        if (isEmpty())
            front = rear = node;
        // Front enqueue operation
        else if (isFront) {
            // Add node to the head of the list
            front.prev = node;
            node.next = front;
            front = node; // Update head node
        // Rear enqueue operation
        } else {
            // Add node to the tail of the list
            rear.next = node;
            node.prev = rear;
            rear = node; // Update tail node
        }
        queSize++; // Update queue length
    }

    /* Front enqueue */
    public void pushFirst(int num) {
        push(num, true);
    }

    /* Rear enqueue */
    public void pushLast(int num) {
        push(num, false);
    }

    /* Dequeue operation */
    private int pop(boolean isFront) {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        int val;
        // Front dequeue operation
        if (isFront) {
            val = front.val; // Temporarily store the head node value
            // Remove head node
            ListNode fNext = front.next;
            if (fNext != null) {
                fNext.prev = null;
                front.next = null;
            }
            front = fNext; // Update head node
        // Rear dequeue operation
        } else {
            val = rear.val; // Temporarily store the tail node value
            // Remove tail node
            ListNode rPrev = rear.prev;
            if (rPrev != null) {
                rPrev.next = null;
                rear.prev = null;
            }
            rear = rPrev; // Update tail node
        }
        queSize--; // Update queue length
        return val;
    }

    /* Front dequeue */
    public int popFirst() {
        return pop(true);
    }

    /* Rear dequeue */
    public int popLast() {
        return pop(false);
    }

    /* Access front element */
    public int peekFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return front.val;
    }

    /* Access rear element */
    public int peekLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return rear.val;
    }

    /* Return array for printing */
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
