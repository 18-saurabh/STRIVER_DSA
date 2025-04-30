public class _4_LL_queue {
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node start;
    private Node end;

    public _4_LL_queue() {
        size = 0;
        start = null;
        end = null;
    }

    public void push(int x) {
        Node tempNode = new Node(x);
        if (start == null) {
            start = tempNode;
            end = tempNode;
        } else {
            end.next = tempNode;
        }
        size = size + 1;
    }

    public int pop() {
        if (start == null) {
            System.out.println("Queue is underflow");
            return -1;
        }
        int popped = start.data;
        start = start.next;
        size--;
        return popped;
    }

    public int peek() {
        if (start == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return start.data;
    }

    public boolean isEmpty() {
        return start == null;
    }
}
