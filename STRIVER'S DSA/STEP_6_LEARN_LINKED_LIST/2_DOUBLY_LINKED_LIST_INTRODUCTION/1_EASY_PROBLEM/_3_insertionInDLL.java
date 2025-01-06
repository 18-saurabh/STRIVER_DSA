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
public class _3_insertionInDLL {
    public Node insertBeforeHead(Node head,int val){
        Node newHead=new Node(val,head,null);
        head.prev=newHead;
        return newHead;
    }
    
    public Node insertBeforeTail(Node head, int val) {
        if(head.next==null) return insertBeforeHead(head, val);
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        Node previous=tail.prev;
        Node newNode = new Node(val, tail, previous);
        previous.next=newNode;
        tail.prev=newNode;
        return head;
    }
    public Node insertBeforeKthElement(Node head,int val, int x){
        if(x==1)return insertBeforeHead(head, val);
        int cnt=0;
        Node temp=head;
        while(temp!=null){
        cnt++;
        if (cnt==x) {
            break;
        }
        temp=temp.next;
        }
        Node previous=temp.prev;
        Node newNode=new Node(val,temp,previous);
        previous.next=newNode;
        temp.prev=newNode;
        return head;
    }
}
