public class _3_remvoeDuplicatedFromDLL {
    class Node {
        int data;
        Node next, prev;

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
     Node removeDuplicates(Node head){
        // Code Here.
        Node temp=head;
        while(temp!=null&&temp.next!=null){
            Node nextNode=temp.next;
            while(nextNode != null && nextNode.data==temp.data){
                nextNode=nextNode.next;
            }
            temp.next=nextNode;
            if(nextNode!=null) nextNode.prev=temp;
            temp=temp.next;
        }
        return head;
    }
}
