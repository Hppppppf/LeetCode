/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode q = head;
        for (int i = 1; i <= 7; i++) {
            ListNode p = new ListNode(i);
            q.next = p;
            q = q.next;
        }
        System.out.println(middleNode(head).val);
    }
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    private static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode ret = new ListNode(head.val,head.next);
        while (head != null){
            count++;
            head = head.next;
        }
        for (int i = 0; i < count / 2; i++){
            ret = ret.next;
        }
        return ret;
    }
}
