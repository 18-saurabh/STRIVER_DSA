public class _5_deletionInLL {
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
    public Node DeleteHead(Node head){
        if(head==null)return null;
        head=head.next;
        return head;
    }
    public Node DeleteTail(Node head){
        if(head==null||head.next==null){
            return null;
        }
        Node temp=head;
        while (temp.next.next!=null) {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    public Node DeleteElementAtGivenPosition(Node head,int k){
        if(head==null)return null;
        if(k==1){
            head=head.next;
            return head;
        }
        Node previous=null;
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (k == cnt) {
                previous.next = previous.next.next;
                break;
            }
            previous=temp;
            temp=temp.next;
        }
        return head;
    }
    
    public Node DeleteElementofGivenVal(Node head, int val) {
        if (head == null)
            return null;
        if (val == head.data) {
            head=head.next;
            return head;
        }
        Node previous = null;
        Node temp = head;
        while (temp != null) {
            if (val == temp.data) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }
    
    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
