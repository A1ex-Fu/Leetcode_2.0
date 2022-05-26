/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * @author Alex
 *
 */
public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l1runner = new ListNode();
    l1runner.next = l1;
    ListNode l2runner = new ListNode();
    l2runner.next = l2;
    ListNode head = new ListNode(-1);
    ListNode tail = new ListNode();
    head.next = tail;
    int carryOver = 0;
    boolean ranOut = false;
    int b = 0;
    int[] sum = null;

    while (l1runner.next != null || l2runner.next != null) {
      l1runner = l1runner.next;
      // don't move runner once it reaches end
      if (!ranOut) {
        l2runner = l2runner.next;
      }

      // adding together(not at end)
      int a = l1runner.val;
      if (!ranOut) {
        b = l2runner.val;
      } else {
        b = 0;
      }

      // get the sum as [ones, carryover]
      sum = add(a, b, carryOver);
      ListNode newNode = new ListNode(sum[0]);
      // set carryover for next loop
      carryOver = sum[1];
      // set new node at the end
      if (head.val == -1) {
        head = newNode;
      }
      tail.next = newNode;
      tail = newNode;


      // when one runs out, the other sum is always zero
      if (l1runner.next == null && l2runner.next != null) {
        // swap so l1runner is always the longest one
        ListNode temp = l2runner;
        l2runner = l1runner;
        l1runner = temp;
        ranOut = true;
      } else if (l1runner.next != null && l2runner.next == null) {
        ranOut = true;
      }

    }

    // if the last addition resulted in carryover, create a new node and add it in
    if (sum[1] != 0) {
      ListNode newNode = new ListNode(sum[1]);
      // set new node at the end
      tail.next = newNode;
      tail = newNode;
    }

    return head;
  }



  public static void main(String[] args) {
    // // test the add method
    //
    // // TEST 1 - add together two single digits to equal something <10
    // int[] arrSum = add(3, 4, 2);
    // // 9,0 -> 9
    // printNum(arrSum);
    // // TEST 2 - add together two single digits to equal something =10
    // arrSum = add(8, 2, 0);
    // // 0,1 -> 10
    // printNum(arrSum);

    // test the list adder method
    ListNode c = new ListNode(3);
    ListNode b = new ListNode(4, c);
    ListNode a = new ListNode(2, b);

    ListNode f = new ListNode(4);
    ListNode e = new ListNode(6, f);
    ListNode d = new ListNode(5, e);

    // TEST 1 - same length no additional node from carryover
    ListNode sum = addTwoNumbers(a, d);
    printListNode(sum);


    // TEST 2 - different lengths and l1 is longer
    c = new ListNode(3);
    b = new ListNode(4, c);
    a = new ListNode(2, b);
    f = new ListNode(4, a);
    e = new ListNode(6, f);
    d = new ListNode(5, e);


    sum = addTwoNumbers(d, b);
    printListNode(sum);

    // TEST 3 - different lengths and carryover creates an additional node and l2 is longer
    c = new ListNode(9);
    b = new ListNode(9, c);
    a = new ListNode(9, b);
    f = new ListNode(9, a);
    e = new ListNode(9, f);
    d = new ListNode(9, e);
    ListNode g = new ListNode(9, d);

    sum = addTwoNumbers(a, g);
    printListNode(sum);
  }


  private static void printListNode(ListNode sum) {
    ListNode curr = new ListNode();
    curr.next = sum;
    while (curr.next != null) {
      curr = curr.next;
      System.out.print(curr.val + " -> ");
    }
    System.out.println("null");
  }


  /**
   * Definition for singly-linked list.
   */
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  private static void printNum(int[] pair) {
    System.out.println("Output: [" + pair[0] + ", " + pair[1] + "]");
  }

  /**
   * Adds together two numbers
   * 
   * @param a - first of the two numbers to be added together
   * @param b - second of the two numbers to be added together
   * @returns the sum in an array with the digits separated and in reverse order
   */
  public static int[] add(int a, int b, int c) {
    // a and b are both single digit numbers so the max. value of the sum is 18
    int[] arrSum = new int[2];
    int sum = a + b + c;

    // the ones digit of the sum is the modulus of a+b
    arrSum[0] = sum % 10;

    // there is only a tenth digit if a+b is greater than 9 as the max. value of the sum is 18 the
    // tenth digit is either one or zero
    if (sum >= 10) {
      // if there is a tenth digit it is a one
      arrSum[1] = 1;
    } else {
      // if there is not tenth digit it is zero
      arrSum[1] = 0;
    }

    // return the array in the form [OnesDigitValue, TenthsDigitValue]
    return arrSum;
  }


}
