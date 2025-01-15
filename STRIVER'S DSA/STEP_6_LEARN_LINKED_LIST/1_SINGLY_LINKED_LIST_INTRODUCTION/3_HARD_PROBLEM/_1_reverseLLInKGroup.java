public class _1_reverseLLInKGroup {
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
    public ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }

    public ListNode findKthNode(ListNode node, int k) {
        ListNode temp = node;
        int count = 0;
        while (temp != null && k > 0) {
            count++;
            if (count == k) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode kNode = findKthNode(temp, k);
            if (kNode == null) {
                if (prevNode != null)
                    prevNode.next = temp;
                break;
            }
            nextNode = kNode.next;
            kNode.next = null;
            reverseLL(temp);
            if (temp == head) {
                head = kNode;
            } else {
                prevNode.next = kNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}