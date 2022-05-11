import java.util.Stack;

public class _206 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
      /*//进堆栈往外倒
      Stack<ListNode> s = new Stack<ListNode>();
      if (head == null || head.next == null) return head;//空链或只有一个结点
      while (head != null){
        s.push(head);
        head = head.next;
      }
      ListNode ret = s.pop();
      ListNode p = ret;
      while (!s.empty()){
        p.next = s.pop();
        p = p.next;
      }
      p.next = null;//除去最后一个ListNode的next
      return ret;*/
      //遍历处理一遍
      if (head == null || head.next == null) return head;//空链或只有一个结点
      ListNode p = head, q = head.next;
      p.next = null;
      while (q != null){
        ListNode temp = q.next;
        q.next = p;
        p = q;
        q = temp;
      }
      return p;
    }
}
