

public class SearchInsertPosition {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(searchInsert(new int[] {1, 2, 3, 4, 5}, 3));
    System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
    System.out.println(searchInsert(new int[] {1, 3, 4, 5}, 6));
    System.out.println(searchInsert(new int[] {2}, 3));
    System.out.println(searchInsert(new int[] {2}, 1));
  }

  public static int searchInsert(int[] nums, int target) {
    // while the lower bound is less than the upper bound look for the target starting from the
    // middle
    int mid = (nums.length) / 2;
    while (mid > 0 && mid < nums.length) {
      if (nums[mid] >= target && nums[mid-1] < target) {
        return mid;
      } else if (nums[mid] > target) {
        mid -= 1;
      } else if(nums[mid] < target){
        mid += 1;
      }
    }
    
    if(nums.length==1) {
      if(nums[0]>=target) {
        return 0;
      }else {
        return 1;
      }
    }
    return mid;
  }
}
