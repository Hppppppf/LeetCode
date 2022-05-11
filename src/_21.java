public class _21 {
    public static void main(String[] args) {

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode ret = new ListNode();
        ListNode t = ret;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                t.next = l1;
                l1 = l1.next;
                t = t.next;
            }else {
                t.next = l2;
                l2 = l2.next;
                t = t.next;
            }
        }
        if (l1 == null) t.next = l2;
        else t.next = l1;
        return ret.next;
    }
}
