import java.util.HashMap;
import java.util.Map;
public class _4_loopInALinkedListII {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode hasCycle(ListNode head) {
        ListNode temp = head;
        Map<ListNode, Integer> ans = new HashMap<>();
        while (temp != null) {
            if (ans.containsKey(temp)) {
                return temp;
            }
            ans.put(temp, 1);
            temp = temp.next;
        }

        return null;
    }

    public static ListNode firstNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
