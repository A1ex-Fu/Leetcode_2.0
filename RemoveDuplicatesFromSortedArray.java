
public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = new int[] {1,1,2};
removeDuplicates(nums);
  }
  
  
  public static int removeDuplicates(int[] nums) {
    //go over every number
    int prev = 101;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      //check if it equals the previous numbers
        if(prev != nums[i]) {
          //add it to the new array
          nums[count] = nums[i];
          count++;
        }
        
        prev = nums[i];
    }
    return count;
  }

}
