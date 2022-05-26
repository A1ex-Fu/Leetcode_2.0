
public class SwapNodesInPairs {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode head = new ListNode(1, new ListNode(2, null));
    System.out.println(swapPairs(head));
  }


  public static ListNode swapPairs(ListNode head) {

    // if the length is less than 2, return the head
    if (head == null || head.next == null) {
      return head;
    }

    // recursively get the next pair
    ListNode newHead = head.next;
    head.next = swapPairs(newHead.next);
    newHead.next = head;

    return newHead;

  }


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

}
