import java.util.HashMap;
import java.util.Map;

public class _5_lengthOfLoop {
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

    public int countNodesinLoop(Node head) {
        // Add your code here.
        Map<Node, Integer> mpp = new HashMap<>();
        Node temp = head;
        int timer = 1;
        while (temp != null) {
            if (mpp.containsKey(temp)) {
                int lengthOfLoop = timer - mpp.get(temp);
                return lengthOfLoop;
            }
            mpp.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }
    
    public int optimal_countNodesinLoop(Node head) {
        // Add your code here.
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int cnt = 1;
                fast = fast.next;
                while (slow != fast) {
                    cnt++;
                    fast = fast.next;
                }
                return cnt;
            }
        }
        return 0;
    }
}
