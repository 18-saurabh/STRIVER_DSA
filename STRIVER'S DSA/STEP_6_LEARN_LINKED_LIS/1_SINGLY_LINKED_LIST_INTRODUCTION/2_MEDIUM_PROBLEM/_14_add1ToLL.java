public class _14_add1ToLL {
    // Definition of a linked list node
    class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        // Constructor to initialize the node with a value
        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Method to reverse a linked list
    public Node reverse(Node head) {
        Node temp = head; // Pointer to traverse the list
        Node previous = null; // Pointer to keep track of the previous node
        while (temp != null) {
            Node frontNode = temp.next; // Temporarily store the next node
            temp.next = previous; // Reverse the link
            previous = temp; // Move 'previous' forward
            temp = frontNode; // Move 'temp' forward
        }
        return previous; // New head of the reversed list
    }

    // Brute-force approach to add 1 to the number represented by the linked list
    public Node brute_addOne(Node head) {
        head = reverse(head); // Reverse the list to start from the least significant digit
        Node temp = head; // Pointer to traverse the list
        int carry = 1; // Initialize carry as 1 for adding 1
        while (temp != null) {
            temp.data += carry; // Add the carry to the current node
            if (temp.data < 10) {
                carry = 0; // No further carry needed
                break;
            } else {
                temp.data = 0; // Reset current digit to 0
                carry = 1; // Carry forward the overflow
            }
            temp = temp.next; // Move to the next node
        }
        if (carry == 1) {
            // If there's still a carry, create a new node
            Node newNode = new Node(1);
            head = reverse(head); // Reverse the list back
            newNode.next = head; // Attach the new node at the start
            return newNode; // Return the new head
        }
        head = reverse(head); // Reverse the list back
        return head; // Return the updated head
    }

    // Helper method for the optimal approach to propagate carry recursively
    public int helper(Node temp) {
        if (temp == null) {
            return 1; // Base case: Return 1 to add to the last digit
        }
        int carry = helper(temp.next); // Recursively get the carry from the next node
        temp.data += carry; // Add carry to the current node
        if (temp.data < 10) {
            return 0; // No carry to propagate further
        }
        temp.data = 0; // Reset current digit to 0
        return 1; // Propagate carry to the previous digit
    }

    // Optimal approach to add 1 to the number represented by the linked list
    public Node optimal_addOne(Node head) {
        int carry = helper(head); // Use the helper function to add 1
        if (carry == 1) {
            // If there's still a carry, create a new node
            Node newNode = new Node(1);
            newNode.next = head; // Attach the new node at the start
            return newNode; // Return the new head
        }
        return head; // Return the updated head if no new node is needed
    }
}
