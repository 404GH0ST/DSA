import java.util.concurrent.ThreadLocalRandom;

public class array {
  static int randomAccess(int[] nums) {
    // Randomly select a number in the interval [0, nums.length)
    int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
    // Retrieve and return a random element
    int randomNum = nums[randomIndex];
    return randomNum;
  }

  /* Insert element num at `index` */
  static void insert(int[] nums, int num, int index) {
    // Move all elements after `index` one position backward
    for (int i = nums.length - 1; i > index; i--) {
      nums[i] = nums[i - 1];
    }
    // Assign num to the element at index
    nums[index] = num;
  }

  /* Remove the element at `index` */
  static void remove(int[] nums, int index) {
    // Move all elements after `index` one position forward
    for (int i = index; i < nums.length - 1; i++) {
      nums[i] = nums[i + 1];
    }
  }

  /* Traverse array */
  static void traverse(int[] nums) {
    int count = 0;
    // Traverse array by index
    for (int i = 0; i < nums.length; i++) {
      count += nums[i];
    }
    // Traverse array elements
    for (int num : nums) {
      count += num;
    }
  }

  /* Search for a specified element in the array */
  static int find(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) return i;
    }
    return -1;
  }

  /* Extend array length */
  static int[] extend(int[] nums, int enlarge) {
    // Initialize an extended length array
    int[] res = new int[nums.length + enlarge];
    // Copy all elements from the original array to the new array
    for (int i = 0; i < nums.length; i++) {
      res[i] = nums[i];
    }
    // Return the new array after expansion
    return res;
  }

  public static void main(String[] args) {
    int[] arr = new int[5]; // { 0, 0, 0, 0, 0 }
    int[] nums = {1, 3, 2, 5, 4};
  }
}
