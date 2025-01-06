import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _12_intersectionPointOfTwoLL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode brute1_getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> st = new HashSet<>();
        while (headA != null) {
            st.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (st.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode brute2_getIntersectionNode(ListNode headA, ListNode headB) {
        while (headB != null) {
            ListNode temp = headA;
            while (temp != null) {
                if (temp == headB)
                    return headB;
                temp = temp.next;
            }
            headB = headB.next;
        }
        return null;
    }
    
    public ListNode brute3_getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> st = new HashMap<>();
        while (headA != null) {
            st.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (st.containsKey(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2)
                return temp1;
            if (temp1 == null)
                temp1 = headB;
            if (temp2 == null)
                temp2 = headA;
        }
        return temp1;
    }
}
