public class _8_removeNthNodeFromBackwardOfLL {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data,ListNode next){
            this.data=data;
            this.next=next;
        }
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static int lengthOfLL(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }
        int length = lengthOfLL(head);
        int result = length - n;
        ListNode temp = head;
        if (length == n)
            return head.next;
        while (temp != null) {
            result--;
            if (result == 0) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
