import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hppppppf
 * @date 2022/5/4 10:24
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class _82 {
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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1,2,3,3,3,4,5));
        ListNode head = buildList(list);
        ListNode l = deleteDuplicates(head);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = null, q = head;
        if (head.val != head.next.val)  p = head;
        while (q != null) {
            if (p != null) q = q.next;
            while (q != null && q.next != null && q.next.val == q.val) {
                while (q.next != null && q.next.val == q.val)
                    q = q.next;
                q = q.next;
            }
            if (p == null) {
                p = q;
                head = p;
            } else p.next = q;
            p = q;
        }
        return head;
    }

    public static ListNode buildList(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        ListNode p = head;
        for (int i = 1; i < list.size(); i++) {
            p.next = new ListNode(list.get(i));
            p = p.next;
        }
        return head;
    }
}
