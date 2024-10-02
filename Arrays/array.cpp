#include <stdio.h>
#include <stdlib.h>

int randomAccess(int *nums, int size)
{
    int randomIndex = rand() % size;
    return nums[randomIndex];
}

void insertAt(int *nums, int size, int num, int index)
{
    for (int i = size - 1; i < index; i--)
    {
        nums[i] = nums[i - 1];
    }
    nums[index] = num;
}

void removeAt(int *nums, int size, int index)
{
    for (int i = index; i < size - 1; i++)
    {
        nums[i] = nums[i + 1];
    }
}

void traverse(int *nums, int size)
{
    int count = 0;
    for (int i = count; i < size; i++)
    {
        printf("%d ", nums[i]);
    }
    printf("\n");
}

int find(int *nums, int size, int target)
{
    for (int i = 0; i < size; i++)
    {
        if (nums[i] == target)
        {
            return i;
        }
    }
    return -1;
}

/* Extend array length */
int *extend(int *nums, int size, int enlarge)
{
    // Initialize an extended length array
    int *res = new int[size + enlarge];
    // Copy all elements from the original array to the new array
    for (int i = 0; i < size; i++)
    {
        res[i] = nums[i];
    }
    for (int i = size - 1; i < enlarge; i++)
    {
        res[i] = 0;
    }
    // Free memory
    // delete[] nums;
    // Return the new array after expansion
    return res;
}

int main(int argc, char *argv[])
{
    /* Initialize array */
    int arr[5] = {0}; // { 0, 0, 0, 0, 0 }
    int nums[5] = {1, 3, 2, 5, 4};

    /* Random access */
    printf("Random access: %d\n", randomAccess(nums, 5));

    /* Insert */
    insertAt(nums, 5, 10, 3);
    traverse(nums, 5);

    /* Remove */
    removeAt(nums, 5, 3);
    traverse(nums, 5);

    /* find */
    printf("Number 3 is at index: %d\n", find(nums, 5, 3));

    /* Extend */
    int *newNums = extend(nums, 5, 2);
    traverse(newNums, 7);
    return 0;
}