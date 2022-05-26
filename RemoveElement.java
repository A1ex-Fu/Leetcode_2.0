
public class RemoveElement {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }


  public int removeElement(int[] nums, int val) {
    // go over every number
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      // check if it equals the previous numbers
      if (nums[i] != val) {
        // add it to the new array
        nums[count] = nums[i];
        count++;
      }
    }
    return count;
  }
  
  


}


