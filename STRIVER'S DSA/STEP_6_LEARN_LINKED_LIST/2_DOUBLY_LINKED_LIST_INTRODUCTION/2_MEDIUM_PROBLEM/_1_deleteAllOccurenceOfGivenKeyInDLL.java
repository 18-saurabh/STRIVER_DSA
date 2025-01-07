public class _1_deleteAllOccurenceOfGivenKeyInDLL {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    Node previous = temp.prev;
                    Node front = temp.next;
                    if (front != null)
                        front.prev = previous;
                    if (previous != null)
                        previous.next = front;
                }
            }
            temp = temp.next;
        }
        return head;

    }
}
