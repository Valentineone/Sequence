package OJ;

public class LeetCode206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

       /* public ListNode reverseListOne(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = cur.next;
            while (cur != null) {
                cur.next = pre;
                pre = cur;
                cur = next;
                if (cur.next == null) {
                    break;
                }
                next = cur.next;
            }
            return pre;
        }*/

        public ListNode reverseListOne(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = cur.next;
            while (cur != null) {
                cur.next = pre;
                pre = cur;
                cur = next;
                if (cur.next == null) {
                    break;
                }
                next = cur.next;
            }
            return pre;
        }

        public ListNode reverseListYiMing(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            if (head == null || head.next == null) {
                return head;
            } else {
                ListNode f = dummyHead.next;
                ListNode s = f.next;
                while (s != null) {
                    f.next = s.next;
                    s.next = dummyHead.next;
                    dummyHead.next = s;
                    s = f.next;
                }
            }
            return dummyHead;
        }
    }

}
