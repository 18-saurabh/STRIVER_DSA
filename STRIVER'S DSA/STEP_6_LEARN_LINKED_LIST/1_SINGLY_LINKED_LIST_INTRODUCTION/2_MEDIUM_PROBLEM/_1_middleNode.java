public class _1_middleNode {
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

    public ListNode brute_middleNode(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        int middleNode = (cnt / 2) + 1;// middle node appearing check
        temp = head;
        while (temp != null) {
            middleNode--;
            if (middleNode == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
    
    public ListNode optimal_middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
