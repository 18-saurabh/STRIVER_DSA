import java.util.Stack;

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
public class _4_reverseDLL {
   public Node reverseDLL(Node head){
    Stack<Integer>st=new Stack<>();
    Node temp=head;
    while(temp!=null){
        st.push(temp.data);
        temp=temp.next;
    }
    temp=head;
    while(temp!=null){
        temp.data=st.peek();
        st.pop();
        temp=temp.next;
    }
    return head;
   } 
   
   public Node optimal_reverseDLL(Node head){
    Node last=null;
    Node current=head;
    while (current!=null) {
        last=current.prev;
        current.prev=current.next;
        current.next=last;
        current=current.prev;    
    }
    return last.prev;

}
   
}
