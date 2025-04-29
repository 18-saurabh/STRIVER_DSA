public class _3_LL_stack {
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
    private Node top;    
    private int size;
    public _3_LL_stack(){
        top=null;
        size=0;
    }
    public void push(int x){
        Node tempNode=new Node(x);
        tempNode.next=top;
        top=tempNode;
        size=size+1;
    }
    public int pop(){
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        size--;
        return popped;
    }
    
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}
