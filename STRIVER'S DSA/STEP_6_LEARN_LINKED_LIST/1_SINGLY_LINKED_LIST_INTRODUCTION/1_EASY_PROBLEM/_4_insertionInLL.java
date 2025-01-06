public class _4_insertionInLL {
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
    public static Node insertHead(Node head,int val){
        Node temp=new Node(val);
        temp.next=head;
        return temp;
    }
    
    public static Node insertTail(Node head, int val) {
        Node newNode=new Node(val);
        if (head==null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    
    public static Node insertElementAtGivenPosition(Node head, int n, int pos, int val) {
        // Write your code here.
        Node newNode = new Node(val);
        if (head == null) {
            if (pos == 0) {
                return new Node(val);
            }
        }
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            if (cnt == pos - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
            cnt++;
        }
        return head;
    }
    
    public static Node insertElementBeforeGivenValue(Node head, int n, int x, int val) {
        // Write your code here.
        Node newNode = new Node(val);
        if (head == null) {
            return null;
        }
        if (head.data== x) {
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        while (temp.next!= null) {
            if (temp.next.data ==val ) {
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
