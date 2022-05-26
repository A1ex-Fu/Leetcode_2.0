import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayList<LinkedList<Integer>> values = getSortedArray(new int[] {1, 1, 1, 2, 2, 3});
    values = getSortedArray(new int[] {1, 8, 6, 2, 5, 4, 8, 25, 7});

    System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 25, 7}));
    System.out.println(maxArea(new int[] {1, 1, 1, 2, 2, 3}));
    System.out.println(maxArea(new int[] {1, 1, 1, 2, 2, 1}));
    System.out.println(maxArea(new int[] {3, 1, 1, 2, 2, 3}));
    System.out.println(maxArea(new int[] {3, 1, 1, 2, 2, 5}));
  }


  public static int maxArea(int[] height) {
    // start the left and right at the ends
    int l = 0;
    int r = height.length - 1;

    int largestArea = 0;

    // go through the array while the two are not equal
    while (l < r) {

      // calculate the area and update the largest area if necessary
      int currArea = Math.min(height[l], height[r]) * (r - l);
      largestArea = Math.max(currArea, largestArea);
      
      // move the one that is smaller(height)
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }

    return largestArea;
  }

  public static int maxAreaSlower(int[] height) {

    int largestArea = 0;
    ArrayList<LinkedList<Integer>> values = getSortedArray(height);


    // run through all combinations to find the max container size
    for (int i = 0; i < height.length; i++) {
      int h = height[i];
      LinkedList<Integer> indices = values.get(h);

      // if there is only one index a container cannot be created
      if (indices.size() <= 1) {
        continue;
      }

      // get the height and length
      int l = Math.abs((int) indices.get(0) - (int) indices.get(indices.size() - 1));
      // get the area
      int area = h * l;
      // if it was the largest area found so far, set it as the largestArea
      largestArea = Math.max(largestArea, area);
    }

    return largestArea;

  }


  /**
   * Returns a sorted arraylist of linkedlists. The arraylist's indices are representative of the
   * heights. The linked lists contain all the indices at which that height or any greater height
   * occur
   * 
   * @param height - int array containing the heights
   * @returns a sorted arraylist of linkedlists and returns null if no sorting was necessary
   */
  private static ArrayList<LinkedList<Integer>> getSortedArray(int[] height) {
    if (height.length <= 1) {
      return null;
    }

    // get the largest and smallest values
    int largestVal = height[0];
    for (int i = 0; i < height.length; i++) {
      largestVal = Math.max(largestVal, height[i]);
    }


    // index is the height value. The actual values at the index are the indices at which that value
    // appears
    ArrayList<LinkedList<Integer>> values = new ArrayList<LinkedList<Integer>>();

    for (int i = 0; i <= largestVal; i++) {
      values.add(new LinkedList<Integer>());
    }

    // fill the arraylist
    for (int i = 0; i < height.length; i++) {
      int heightVal = height[i];
      LinkedList<Integer> next = values.get(heightVal);
      next.add(i);
    }


    // update and sort the arraylist
    LinkedList<Integer> greaterOrEqual = new LinkedList<Integer>();
    for (int i = values.size() - 1; i >= 0; i--) {
      // if the index is empty remove it
      // don't remove the value to keep the proper count
      // if (values.get(i).size() == 0) {
      // values.remove(i);
      // } else {
      // if there is a value, copy it down and update so that each index has the values greater
      // than or equal to that value
      greaterOrEqual.addAll((LinkedList<Integer>) values.get(i));

      // sort the linkedlist
      greaterOrEqual.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o1 - o2;
        }
      });

      values.get(i).clear();
      values.get(i).addAll(greaterOrEqual);
    }


    return values;
  }



  public static int maxAreaHashtable(int[] height) {

    int largestArea = 0;
    // the key is value(height); the value is index
    Hashtable<Integer, LinkedList<Integer>> hash = new Hashtable<Integer, LinkedList<Integer>>();

    // fill the hashtable
    for (int index = 0; index < height.length; index++) {
      int value = height[index];
      // if the index already has a value, add the new one to the list
      // otherwise create a new list with the value
      if (hash.get(value) != null) {
        hash.get(value).add(index);
      } else {
        LinkedList<Integer> next = new LinkedList<Integer>();

        next.add(index);
        hash.put(value, next);
      }

    }

    // update the hashtable so that each index has the values greater than or equal to that value
    LinkedList<Integer> greaterOrEqual = new LinkedList<Integer>();
    Enumeration<Integer> keys = hash.keys();
    // run through all combinations to find the max container size
    while (keys.hasMoreElements()) {
      int i = keys.nextElement();
      try {
        greaterOrEqual.addAll(hash.get(i));
      } catch (Exception e) {
      }
      greaterOrEqual.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o1 - o2;
        }
      });

      hash.put(i, new LinkedList<Integer>((LinkedList<Integer>) greaterOrEqual));
    }


    keys = hash.keys();
    // run through all combinations to find the max container size
    while (keys.hasMoreElements()) {
      int i = keys.nextElement();

      // go through all indexes that share this value
      if (hash.get(i) == null || hash.get(i).size() <= 1) {
        continue;
      }

      // get the height and length
      LinkedList<Integer> currList = hash.get(i);
      int h = i;
      int l = (int) currList.get(currList.size() - 1) - (int) currList.get(0);
      // get the area
      int area = h * l;
      // if it was the largest area found so far, set it as the largestArea
      largestArea = Math.max(largestArea, area);

    }

    return largestArea;
  }


  public int maxAreaSlow(int[] height) {
    int largestArea = 0;
    // run through all combinations to find the max container size
    for (int i = 0; i < height.length; i++) {
      // only need to run the cases in front of the current 'wall'
      for (int j = i + 1; j < height.length; j++) {
        // get the height and length
        int h = Math.min(height[i], height[j]);
        int l = j - i;
        // get the area
        int area = h * l;
        // if it was the largest area found so far, set it as the largestArea
        largestArea = Math.max(largestArea, area);
      }
    }

    return largestArea;
  }



}
