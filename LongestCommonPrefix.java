
public class LongestCommonPrefix {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] strs = new String[] {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));

    strs = new String[] {"f", "f"};
    System.out.println(longestCommonPrefix(strs));

    strs = new String[] {"", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));

    strs = new String[] {"reflower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));

    strs = new String[] {""};
    System.out.println(longestCommonPrefix(strs));

  }

  public static String longestCommonPrefix(String[] strs) {
    // return an empty string if the string array is empty
    if (strs.length == 0) {
      return "";
    }
    // return the string if there is only one string
    if (strs.length == 1) {
      return strs[0];
    }
    // for every letter
    int count = 0;
    boolean match = true;
    do {
      for (int j = 0; j < strs.length - 1; j++) {
        // compare this string's character to the next string's corresponding character
        char a;
        char b;
        // return an empty string if one of the strings is empty
        if (strs[j].length() == 0) {
          return "";
        }
        try {
          a = strs[j].charAt(count);
          b = strs[j + 1].charAt(count);
        } catch (Exception e) {
          // the last bound is not in the string. Return the matched prefix
          a = 'a';
          b = 'b';
        }
        // the previous value of match matters. cannot let the most recent value dictate its
        // equality
        match = (a == b) && match;
      }
      count++;
    } while (match);

    return strs[0].substring(0, count - 1);
  }

}
