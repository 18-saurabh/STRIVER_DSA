import java.util.Stack;
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class _8_minStack {
    private Stack<Pair>st;
    public  _8_minStack(){
        st=new Stack<>();  
    }
    public void push(int val){
        int min;
        if(st.isEmpty()) min=val;
        else min=Math.min(val,st.peek().y);
        st.push(new Pair(val,min));
    }
    public void pop(){
        st.pop();
    }
    public int peek(){
        return st.peek().x;
    }
    public int getMin(){
        return st.peek().y;
    }
}
