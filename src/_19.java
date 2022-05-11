public class _19 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode q = head;
        for (int i = 1; i <= 7; i++) {
            ListNode p = new ListNode(i);
            q.next = p;
            q = q.next;
        }
        ListNode r = removeNthFromEnd(head,4);
        for (int i = 0; i < 7; i++) {
            System.out.print(r.val + " ");
            r = r.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 1; i < n; i++)	q = q.next;
        if (q.next == null) return head.next;
        else q = q.next;
        while (q != null && q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;//TODO 释放该Node空间
        return head;
    }
}
