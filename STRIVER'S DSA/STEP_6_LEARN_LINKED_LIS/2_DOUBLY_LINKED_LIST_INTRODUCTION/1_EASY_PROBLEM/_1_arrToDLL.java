class Node{
    int data;
    Node next;
    Node prev;
    Node(int data,Node next,Node prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
    
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class _1_arrToDLL{
    Node constructDLL(int arr[]) {
        // Code here
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node previous = head;
        for (int i = 1; i < n; i++) {
            Node temp = new Node(arr[i]);
            temp.next = null;
            temp.prev = previous;
            previous.next = temp;
            previous = temp;
        }
        return head;
    }
}