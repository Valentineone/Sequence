package LinkedList;
//LeetCode 203
//2 3 4 8
public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = head;
        ListNode deNode;
        for (ListNode cur = head; cur != null;) {
            if (cur.val == val && cur == head) {
                head = head.next;
                if (head == null) {
                    deNode = cur;
                    cur = head;
                    deNode = null;

                } else {
                    deNode = cur;
                    cur = head;
                    deNode = null;
                    pre = head;
                }
            } else if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = pre.next;
            }

        }
        return head;
    }
}