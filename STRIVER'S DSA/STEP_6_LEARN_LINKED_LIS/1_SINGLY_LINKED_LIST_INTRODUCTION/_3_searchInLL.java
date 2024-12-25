public class _3_searchInLL {
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

    public boolean searchLL(Node head,int target){
       Node temp=head;
       while(temp!=null){
        if(temp.data==target){
            return true;
        }
        temp=temp.next;
       }
       return false;
    }
}
