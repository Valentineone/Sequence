package OJ;

public class LeetCode234 {
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        if (head == null) {
            return false;
        }
        ListNode low;
        ListNode fast;
        low = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
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

        return true;
    }
}
}
