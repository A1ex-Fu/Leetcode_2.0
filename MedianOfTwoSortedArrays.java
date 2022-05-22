/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the
 * two sorted arrays.
 * 
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * 
 * @author Alex
 *
 */
public class MedianOfTwoSortedArrays {


  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int runner1 = 0;
    int runner2 = 0;

    double prev = 0;
    double median = 0;
    boolean ranOut = false;
    boolean stillLeft = true;
    
    //take care of empty arrays
    if(nums1.length == 0 && nums2.length != 0) {
      return findMedianSortedArrays(nums2, nums1);
    }else if(nums1.length != 0 && nums2.length == 0) {
      ranOut = true;
    }else if(nums1.length == 0 && nums2.length == 0) {
      return 0.0;
    }
    
    for (int i = 0; i < ((nums1.length + nums2.length) / 2) + 1; i++) {
      if (stillLeft && (ranOut || nums1[runner1] < nums2[runner2])) {
        if(runner1+1 == nums1.length) {
          stillLeft = false;
        }
        // if nums1 has the smaller value set prev to the previous median(so when it is of even
        // length they can be added together and /2 to find the true median)
        prev = median;
        // set it as the median
        median = nums1[runner1];
        // increment the runner1
        runner1++;
      } else {
        //this could also occur if the nums1 has all the largest elements
        if(runner2+1 == nums2.length) {
          ranOut = true;
        }
        // if nums2 has a smaller or equal value set prev to the previous median(so when it is of
        // even
        // length they can be added together and /2 to find the true median)
        prev = median;
        // set it as the median
        median = nums2[runner2];
        // increment the runner2
        runner2++;
      }
    }

    if (((nums1.length + nums2.length) % 2) == 0) {
      // if it was of even length the true median is the median + prev /2
      median = (median + prev) / 2;
    }
    return median;
  }



  public static void main(String[] args) {
    // TEST 1 - odd length
    // Expected: 2
    System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));

    // TEST 2 - even length
    // Expected: 2.5
    System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));

    // TEST 3 - first array has the larger half
    // Expected: 5.5
    System.out.println(findMedianSortedArrays(new int[] {5, 6, 7, 8}, new int[] {1, 2}));

    // TEST 4 - one array is empty
    // Expected: 2.5
    System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {}));

  }

}
