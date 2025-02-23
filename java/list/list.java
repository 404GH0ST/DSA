import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class list {
  public static void main(String[] args) {
    /* Initialize list */
    // Without initial values
    List<Integer> nums1 = new ArrayList<>();

    // With initial values (note the element type should be the wrapper class Integer[] for int[])
    Integer[] numbers = new Integer[] {1, 3, 2, 5, 4};
    List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));

    /* Access elements */
    int num = nums.get(1); // Access the element at index 1

    /* Update elements */
    nums.set(1, 0); // Update the element at index 1 to 0

    /* Clear list */
    nums.clear();

    /* Append elements at the end O(1) */
    nums.add(1);
    nums.add(3);
    nums.add(2);
    nums.add(5);
    nums.add(4);

    /* Insert element in the middle O(n) */
    nums.add(3, 6); // Insert number 6 at index 3

    /* Remove elements O(n) */
    nums.remove(3); // Remove the element at index 3

    /* Iterate through the list by index */
    int count = 0;
    for (int i = 0; i < nums.size(); i++) {
      count += nums.get(i);
    }

    /* Iterate directly through list elements */
    for (int num1 : nums) {
      count += num1;
    }

    /* Concatenate two lists */
    List<Integer> nums2 = new ArrayList<>(Arrays.asList(new Integer[] {6, 8, 7, 10, 9}));
    nums.addAll(nums2); // Concatenate nums1 to the end of nums

    /* Sort the list */
    Collections.sort(nums); // After sorting, the list elements are in ascending order
  }
}

/* List class */
class MyList {
    private int[] arr; // Array (stores list elements)
    private int capacity = 10; // List capacity
    private int size = 0; // List length (current number of elements)
    private int extendRatio = 2; // Multiple for each list expansion

    /* Constructor */
    public MyList() {
        arr = new int[capacity];
    }

    /* Get list length (current number of elements) */
    public int size() {
        return size;
    }

    /* Get list capacity */
    public int capacity() {
        return capacity;
    }

    /* Access element */
    public int get(int index) {
        // If the index is out of bounds, throw an exception, as below
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        return arr[index];
    }

    /* Update element */
    public void set(int index, int num) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        arr[index] = num;
    }

    /* Add element at the end */
    public void add(int num) {
        // When the number of elements exceeds capacity, trigger the expansion mechanism
        if (size == capacity())
            extendCapacity();
        arr[size] = num;
        // Update the number of elements
        size++;
    }

    /* Insert element in the middle */
    public void insert(int index, int num) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        // When the number of elements exceeds capacity, trigger the expansion mechanism
        if (size == capacity())
            extendCapacity();
        // Move all elements after `index` one position backward
        for (int j = size - 1; j >= index; j--) {
            arr[j + 1] = arr[j];
        }
        arr[index] = num;
        // Update the number of elements
        size++;
    }

    /* Remove element */
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        int num = arr[index];
        // Move all elements after `index` one position forward
        for (int j = index; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        // Update the number of elements
        size--;
        // Return the removed element
        return num;
    }

    /* Extend list */
    public void extendCapacity() {
        // Create a new array with a length multiple of the original array by extendRatio, and copy the original array to the new array
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        // Update list capacity
        capacity = arr.length;
    }

    /* Convert the list to an array */
    public int[] toArray() {
        int size = size();
        // Only convert elements within valid length range
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }
}
