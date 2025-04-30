import java.util.LinkedList;
import java.util.Queue;

public class _5_StackUsingQueue {
    Queue<Integer>q=new LinkedList<>();
    public void push(int x){
        int size=q.size();
        q.add(x);
        for(int i=1;i<=size;i++){
            q.add(q.peek());
        }
    }
    public int pop(){
        if (q.isEmpty()) {
            System.out.println("Stack is overflow");
            return -1;
        }
        return q.remove();
    }
    public int peek(){
        if (q.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return q.peek();
    }
    public boolean isEmpty(){
        return q.isEmpty();
    }
}
