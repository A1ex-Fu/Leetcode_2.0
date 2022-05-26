import java.util.ArrayList;

public class RemoveNthNodeFromEndOfList {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    removeNthFromEnd(head, 2);
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {

    // go to the end
    ListNode curr = head;
    ArrayList<ListNode> list = new ArrayList<ListNode>();
    while (curr.next != null) {
      list.add(curr);
      curr = curr.next;
    }
    list.add(curr);

    // 'loop back' to the nth node from the end
    int index = list.size() - n;
    int prevIndex = index - 1;

    // possible that the node being removed is the head. In this case, set the next node as the head
    if (prevIndex == -1 && head.next != null) {
      // return head's next
      head = head.next;
    } else if (prevIndex == -1) {
      // removing the head but the head is the only node
      head = null;
    } else {
      // go back one more and set its next to the next's null
      list.get(prevIndex).next = list.get(index).next;
    }
    return head;
  }

}


class ListNode {
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
