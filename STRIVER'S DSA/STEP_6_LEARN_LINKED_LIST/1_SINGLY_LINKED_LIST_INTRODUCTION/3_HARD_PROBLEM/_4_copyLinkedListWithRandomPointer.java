import java.util.HashMap;
import java.util.Map;

public class _4_copyLinkedListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
     public Node copyRandomList(Node head) {
        Map<Node,Node>mpp=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            Node newNode=new Node(temp.val);
            mpp.put(temp, newNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node copyNode=mpp.get(temp);
            copyNode.next=mpp.get(temp.next);
            copyNode.random=mpp.get(temp.random);
            temp=temp.next;
        }
        return mpp.get(head);
    }
    public Node optimal_copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            Node frontNode=temp.next;
            temp.next=copyNode;
            copyNode.next=frontNode;
            temp=temp.next.next;
        }
        temp=head;
        while (temp!=null) {
            Node copyNode=temp.next;
            if(temp.random!=null){
                copyNode.random=temp.random.next;
            }
            else{
                copyNode.random = null;
            }
            temp=temp.next.next;
        }
        temp=head;
        Node dummyNode=new Node(-1);
        Node res=dummyNode;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }
}
