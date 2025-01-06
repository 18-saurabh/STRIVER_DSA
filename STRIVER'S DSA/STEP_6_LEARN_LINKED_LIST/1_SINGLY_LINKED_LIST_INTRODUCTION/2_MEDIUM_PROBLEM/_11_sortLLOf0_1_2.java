public class _11_sortLLOf0_1_2 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    static Node segregate(Node head) {
        // add your code
        Node temp = head;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        while (temp != null) {
            if (temp.data == 0)
                cnt0++;
            else if (temp.data == 1)
                cnt1++;
            else
                cnt2++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (cnt0 > 0) {
                temp.data = 0;
                cnt0--;
            } else if (cnt1 > 0) {
                temp.data = 1;
                cnt1--;
            } else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }
        return head;
    }
    
    static Node optimal_segregate(Node head) {
        if (head == null || head.next == null)
            return head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        Node newHead = zeroHead.next;
        return newHead;
    }
}
