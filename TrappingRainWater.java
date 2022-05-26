import java.util.Arrays;

public class TrappingRainWater {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }


  public int trap(int[] height) {
    // find out what heights we need to search
    int[] heights = height.clone();
    Arrays.sort(heights);
    // remove duplicates from height
    // a duplicate will be denoted with a -1...Note to self: skip over heights less than curr(starts
    // at 0)
    int prev = -1;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] == prev) {
        heights[i] = -1;
      } else {
        prev = heights[i];
      }
    }

    int v = 0;
    int prevHeight = 0;
    // loop through each height starting at 0
    for (int i = 0; i < heights.length; i++) {
      int currHeight = heights[i];
      int currLvlTotal = 0;
      int currBucket = 0;
      int difference = currHeight - prevHeight;
      if (currHeight <= 0) {
        continue;
      } else {
        prevHeight = currHeight;
      }
      // count the volume of water gained at this height
      boolean canCollect = false;
      for (int j = 0; j < height.length; j++) {
        // if can collect water and is less than the current height, we can add one to the volume
        if (canCollect == true && height[j] < currHeight) {
          // handle the end case
          if (j == height.length - 1) {
            // if there is no end wall, empty the bucket
            currBucket = 0;
          } else {

            // starts on height something then needs to add the entire bottom
            currBucket += difference;
          }
        } else {
          // only occurs when there is some wall
          // handle the first wall case
          if (canCollect == false && height[j] >= currHeight) {
            canCollect = true;
          } else {
            // second wall was encountered
            // add the current bucket which just found an end wall to the level total and set its
            // counter to zero
            currLvlTotal += currBucket;
            currBucket = 0;
          }
        }
      }

      v += currLvlTotal;
    }
    return v;
  }

}
