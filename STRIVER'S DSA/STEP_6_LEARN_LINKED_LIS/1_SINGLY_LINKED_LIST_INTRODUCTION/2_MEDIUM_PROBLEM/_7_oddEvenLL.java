import java.util.ArrayList;

public class _7_oddEvenLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ans.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null)
            ans.add(temp.val);
        temp = head.next;
        while (temp != null && temp.next != null) {
            ans.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null)
            ans.add(temp.val);
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.val = ans.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

    public ListNode optimal_oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
