/* Stack class based on array */
class ArrayStack
{
private:
    vector<int> stack;

public:
    /* Get the length of the stack */
    int size()
    {
        return stack.size();
    }

    /* Determine if the stack is empty */
    bool isEmpty()
    {
        return stack.size() == 0;
    }

    /* Push */
    void push(int num)
    {
        stack.push_back(num);
    }

    /* Pop */
    int pop()
    {
        int num = top();
        stack.pop_back();
        return num;
    }

    /* Access stack top element */
    int top()
    {
        if (isEmpty())
            throw out_of_range("Stack is empty");
        return stack.back();
    }

    /* Return Vector */
    vector<int> toVector()
    {
        return stack;
    }
};