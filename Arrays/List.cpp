#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
    /* Initialize list */
    // Note, in C++ the vector is the equivalent of nums described here
    // Without initial values
    vector<int> nums1;
    // With initial values
    vector<int> nums = {1, 3, 2, 5, 4};

    /* Access elements */
    int num = nums[1]; // Access the element at index 1

    /* Update elements */
    nums[1] = 0; // Update the element at index 1 to 0

    /* Clear list */
    nums.clear();

    /* Append elements at the end */
    nums.push_back(1);
    nums.push_back(3);
    nums.push_back(2);
    nums.push_back(5);
    nums.push_back(4);

    /* Insert element in the middle */
    nums.insert(nums.begin() + 3, 6); // Insert number 6 at index 3

    /* Remove elements */
    nums.erase(nums.begin() + 3); // Remove the element at index 3

    /* Iterate through the list by index */
    int count = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        count += nums[i];
    }

    /* Iterate directly through list elements */
    count = 0;
    for (int num : nums)
    {
        count += num;
    }

    /* Concatenate two lists */
    vector<int> nums2 = {6, 8, 7, 10, 9};
    // Concatenate nums1 to the end of nums
    nums.insert(nums.end(), nums2.begin(), nums2.end());

    /* Sort the list */
    sort(nums.begin(), nums.end()); // After sorting, the list elements are in ascending order

    for (int num : nums)
    {
        printf("%d ", num);
    }

    return 0;
}
