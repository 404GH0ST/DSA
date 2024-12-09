#include <vector>

using namespace std;
/* List class */
class MyList
{
private:
    int *arr;             // Array (stores list elements)
    int arrCapacity = 10; // List capacity
    int arrSize = 0;      // List length (current number of elements)
    int extendRatio = 2;  // Multiple for each list expansion

public:
    /* Constructor */
    MyList()
    {
        arr = new int[arrCapacity];
    }

    /* Destructor */
    ~MyList()
    {
        delete[] arr;
    }

    /* Get list length (current number of elements)*/
    int size()
    {
        return arrSize;
    }

    /* Get list capacity */
    int capacity()
    {
        return arrCapacity;
    }

    /* Access element */
    int get(int index)
    {
        // If the index is out of bounds, throw an exception, as below
        if (index < 0 || index >= size())
            throw out_of_range("Index out of bounds");
        return arr[index];
    }

    /* Update element */
    void set(int index, int num)
    {
        if (index < 0 || index >= size())
            throw out_of_range("Index out of bounds");
        arr[index] = num;
    }

    /* Add element at the end */
    void add(int num)
    {
        // When the number of elements exceeds capacity, trigger the expansion mechanism
        if (size() == capacity())
            extendCapacity();
        arr[size()] = num;
        // Update the number of elements
        arrSize++;
    }

    /* Insert element in the middle */
    void insert(int index, int num)
    {
        if (index < 0 || index >= size())
            throw out_of_range("Index out of bounds");
        // When the number of elements exceeds capacity, trigger the expansion mechanism
        if (size() == capacity())
            extendCapacity();
        // Move all elements after `index` one position backward
        for (int j = size() - 1; j >= index; j--)
        {
            arr[j + 1] = arr[j];
        }
        arr[index] = num;
        // Update the number of elements
        arrSize++;
    }

    /* Remove element */
    int remove(int index)
    {
        if (index < 0 || index >= size())
            throw out_of_range("Index out of bounds");
        int num = arr[index];
        // Move all elements after `index` one position forward
        for (int j = index; j < size() - 1; j++)
        {
            arr[j] = arr[j + 1];
        }
        // Update the number of elements
        arrSize--;
        // Return the removed element
        return num;
    }

    /* Extend list */
    void extendCapacity()
    {
        // Create a new array with a length multiple of the original array by extendRatio
        int newCapacity = capacity() * extendRatio;
        int *tmp = arr;
        arr = new int[newCapacity];
        // Copy all elements from the original array to the new array
        for (int i = 0; i < size(); i++)
        {
            arr[i] = tmp[i];
        }
        // Free memory
        delete[] tmp;
        arrCapacity = newCapacity;
    }

    /* Convert the list to a Vector for printing */
    vector<int> toVector()
    {
        // Only convert elements within valid length range
        vector<int> vec(size());
        for (int i = 0; i < size(); i++)
        {
            vec[i] = arr[i];
        }
        return vec;
    }
};