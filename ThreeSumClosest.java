import java.util.Arrays;

public class ThreeSumClosest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    threeSumClosest(new int[] {0, 2, 1, -3}, 0);
    threeSumClosest(new int[] {1, 1, 1, 0}, 100);
  }

  public static int threeSumClosest(int[] nums, int target) {
    // sort the array to make skipping duplicates easier
    Arrays.sort(nums);
    if (nums.length < 3) {
      return target;
    }

    int closest = nums[0] + nums[1] + nums[2];

    // for each element
    for (int i = 0; i < nums.length; i++) {
      // skip duplicates
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        int low = i + 1;
        int high = nums.length - 1;
        // search from both sides
        while (low < high) {
          int currSum = nums[high] + nums[low] + nums[i];
          int distance = (nums[high] + nums[low] + nums[i]) - target;
          if (Math.abs(distance) < Math.abs(closest - target)) {
            // if this is the closest set it as such
            closest = currSum;

            // skip duplicates
            while (low < high && nums[low] == nums[low + 1]) {
              low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
              high--;
            }
          }

          // increment runners
          if (distance < 0) {
            // increment low if the distance is negative
            low++;
          } else
            // decrement high if the distance is positive
            high--;
        }

      }
    }

    return closest;
  }
}
