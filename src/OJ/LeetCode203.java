package OJ;

public class LeetCode203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = dummyHead;
            for (ListNode cur = head; cur != null; cur = cur.next) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }

            }
            return dummyHead.next;
        }
    }
}
