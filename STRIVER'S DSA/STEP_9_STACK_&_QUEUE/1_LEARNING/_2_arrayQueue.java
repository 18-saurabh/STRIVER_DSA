public class _2_arrayQueue {
    private int cur_size;
    private int start;
    private int end;
    private int size;
    private int queue[];

    public _2_arrayQueue() {
        cur_size = 0;
        start = -1;
        end = -1;
        size = 10;
        queue = new int[size];
    }

    public void push(int x) {
        if (cur_size == size) {
            System.out.println("Queue Overflow");
            return;
        }
        if (cur_size == 0) {
            start = 0;
            end = 0;
            queue[end] = x;
        } else {
            end = (end + 1) % size;
            queue[end] = x;
        }
        cur_size++;
    }

    public int pop() {
        if (cur_size == 0) {
            System.out.println("Underflow");
            System.exit(1);
        }
        int poppedElement = queue[start];
        if (cur_size == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }
        cur_size--;
        return poppedElement;
    }

    public int peek() {
        if (cur_size == 0) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return queue[start];
    }

    public boolean isEmpty() {
        return cur_size == 0;
    }
}
