import java.util.Stack;
public class _2_reverseOfLL {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public ListNode brute_reverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = s.pop();
            temp = temp.next;
        }
        return head;
    }

    public ListNode optimal_reverseList(ListNode head) {
        ListNode temp = head;
        ListNode previous = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = previous;
            previous = temp;
            temp = front;
        }
        return previous;
    }

    public ListNode recursive_reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = recursive_reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
