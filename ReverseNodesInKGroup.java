public class ReverseNodesInKGroup {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    reverseKGroup(head, 2);
  }
  
  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode newHead = head;
    ListNode curr = null;
    
    
    //reverse the specified interval
    for (int i = 0; i < k; i++) {
      //if the list is shorter than the interval, do not reverse it
      if(newHead == null) {
        return head;
      }
      
      ListNode prevCurr = curr;
      curr = new ListNode(newHead.val);
      curr.next = prevCurr;
      
      //advance the runner
      newHead = newHead.next;
    }
    
    //save the rest of the list(excluding the reversed interval)
    ListNode remainder = newHead;
    
    //assign the head correctly
    newHead = curr;
    curr = newHead;
    
    //move the runner to the tail node
    while(curr.next != null) {
      curr = curr.next;
    }
    
    //recursively reverse the rest of the list and add them on
    curr.next = reverseKGroup(remainder, k);

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
