public class _9_deleteMiddleNodeFromLL {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode brute_deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        temp = head;
        int iterator = cnt / 2;
        while (temp != null) {
            iterator--;
            if (iterator == 0) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (previous != null) {
            previous.next = slow.next;
        }
        return head;
    }
    
    public ListNode striver_deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
