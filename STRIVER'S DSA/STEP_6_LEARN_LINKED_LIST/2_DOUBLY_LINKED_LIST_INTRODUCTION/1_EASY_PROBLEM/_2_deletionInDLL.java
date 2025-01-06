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

public class _2_deletionInDLL {
    public Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;
        Node previous = head;
        head = head.next;
        head.prev = null;
        previous.next = null;
        return head;
    }

    public Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }

    public Node removeKthPosition(Node head, int x) {
        if (head == null)
            return null;
        Node kNode = head;
        Node previous = kNode.prev;
        Node front = kNode.next;
        int cnt = 0;
        while (kNode != null) {
            cnt++;
            if (cnt == x)
                break;
            kNode = kNode.next;
        }
        if (previous == null && front == null) {
            return null;
        } else if (previous == null) {
            return deleteHead(head);
        } else if (front == null) {
            return deleteTail(head);
        }
        previous.next = front;
        front.prev = previous;
        kNode.next = null;
        kNode.prev = null;
        return head;
    }

    void deleteNode(Node temp) {
        Node previous = temp.prev;
        Node front = temp.next;
        if (front == null) {
            previous.next = null;
            temp.prev = null;
            return;
        }
        previous.next = front;
        front.prev = previous;
        temp.next = temp.prev = null;
        return;
    }
}
