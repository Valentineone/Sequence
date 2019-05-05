package LinkedList;

import java.util.Stack;

public class SolutionOne {
     public class ListNode {
         int val;
         ListNode next = null;
         ListNode(int x) { this.val = x; }
  }
    public ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (k-- > 1) {
            if (stack.size()== 0) {
                return null;
            }
            stack.pop();
        }
        return stack.pop();
    }
}
