
public class ReverseInteger {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(reverse(1534236469));
    System.out.println(reverse(-123));

  }


  public static int reverse(int x) {
    String str = x + "";

    StringBuilder input = new StringBuilder();
    // if it was negative, mark it and remove the negative sign
    char[] strArr = str.toCharArray();
    boolean neg = false;
    if (strArr[0] == '-') {
      str = str.substring(1, strArr.length);
      neg = true;
    }
    // append a string into StringBuilder input
    input.append(str);

    // reverse StringBuilder input
    input.reverse();

    // put the negative back into reversed String if necessary
    if (neg) {
      str = "-" + input.toString();
    } else {
      str = input.toString();
    }

    Integer num = 0;
    try {
      num = Integer.valueOf(str);
    } catch (Exception e) {
    }

    return num;

  }

}
