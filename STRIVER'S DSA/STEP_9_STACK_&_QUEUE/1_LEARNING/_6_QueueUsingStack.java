import java.util.Stack;
public class _6_QueueUsingStack {
    Stack<Integer>s1=new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int x){
        while (s1.size()!=0) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (s2.size()!=0) {
            s1.push(s2.peek());
            s2.pop();
        }
    }
    public int pop(){
        return s1.pop();
    }
    public int peek(){
        return s1.peek();
    }
    public boolean isEmpty(){
        return s1.isEmpty();
    }
}
