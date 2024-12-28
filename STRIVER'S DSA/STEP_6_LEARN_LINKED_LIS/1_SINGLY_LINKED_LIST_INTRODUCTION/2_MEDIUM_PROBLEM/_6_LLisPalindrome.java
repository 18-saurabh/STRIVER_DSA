import java.util.Stack;

public class _6_LLisPalindrome {
    static class Node{
        int data;
        Node next;
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isPalindrome(Node head) {
        Stack<Integer>st=new Stack<>();
        Node temp=head;
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data==st.pop()){
                temp=temp.next;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public Node reverseLL(Node head){
        Node temp=head;
        Node previous=null;
        while(temp!=null){
            Node front=temp.next;
            temp.next=previous;
            previous=temp;
            temp=front;
        }
        return previous;
        
    }
    public boolean optimal_isPalindrome(Node head) {
       Node fast=head;
       Node slow=head;
       while(fast.next!=null&&fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }
       Node first=head;
       Node second=reverseLL(slow.next);
       if(first==second){
        first=first.next;
        second=second.next;
       }
       else{
        return false;
       }
       reverseLL(slow.next);
       return true;
      
    }
}
