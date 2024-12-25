public class _1_arrToLL {
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

    public static Node constructLL(int arr[]){
        Node head=new Node(arr[0]);
        Node current=head;
        for(int i=1;i<arr.length;i++){
            current.next=new Node(arr[i]);
            current=current.next;
        }
        return head;
    }
}
