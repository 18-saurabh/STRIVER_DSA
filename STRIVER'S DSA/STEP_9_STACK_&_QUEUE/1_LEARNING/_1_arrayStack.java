public class _1_arrayStack {
    private int top;
    private int[] st_arr;

    public _1_arrayStack() {
        top = -1;
        st_arr = new int[10];
    }

    public void push(int x) {
        if (top >= 9) {
            System.out.println("Stack is overflow");
        } else {
            top++;
            st_arr[top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Underflow");
            return -1;
        } else {
            int poppedElement = st_arr[top];
            top--;
            return poppedElement;
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return st_arr[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}