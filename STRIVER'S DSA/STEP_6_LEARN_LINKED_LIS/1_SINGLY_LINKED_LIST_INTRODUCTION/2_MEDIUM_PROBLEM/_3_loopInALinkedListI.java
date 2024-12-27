import java.util.HashMap;
import java.util.Map;

public class _3_loopInALinkedListI {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        Map<ListNode,Integer> ans = new HashMap<>();
        while (temp != null) {
           if(ans.containsKey(temp)){
            return true;
           }
           ans.put(temp, 1);
           temp=temp.next;
        }

        return false;
    }

    public boolean optimal_hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
