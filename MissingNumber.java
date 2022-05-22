public class MissingNumber {
    public int missingNumber(int[] nums) {
		int runningSum = nums.length;
		for (int i = 0; i < nums.length; i++) {
			runningSum = runningSum+i-nums[i];
		}
		 
		return runningSum;
    } 
} 