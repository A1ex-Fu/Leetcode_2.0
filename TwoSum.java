/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * 
 * You can return the answer in any order.
 * 
 * @author Alex
 *
 */
public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    // loops through each element of the array
    for (int i = 0; i < nums.length - 1; i++) {
      int currNum = nums[i];
      // tries to find another number that when added to the current number equals the target
      for (int j = 0; j < nums.length; j++) {
        // cannot add itself
        if (j != i) {
          int otherNum = nums[j];
          // if the two numbers are a pair return the indices pair
          if (target == currNum + otherNum) {
            return new int[] {i, j};
          }
        }
      }
    }
    // will never occur because the input will always have exactly one solution
    return null;
  }

  public static void main(String[] args) {
    // TEST 1 - base case
    int[] nums = new int[] {3, 7, 11, 2};
    int target = 9;

    int[] pair = twoSum(nums, target);

    printPair(pair);


    // TEST 2 - only two elements and if it adds itself it will equal the target
    nums = new int[] {3, 3};
    target = 6;

    pair = twoSum(nums, target);

    printPair(pair);
  }

  private static void printPair(int[] pair) {
    System.out.println("Output: [" + pair[0] + ", " + pair[1] + "]");
  }
}
