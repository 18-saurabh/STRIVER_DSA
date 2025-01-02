public class _15_addTwoLL {
    // Definition of a linked list node
    class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        // Constructor to initialize the node with data and next pointer
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor to initialize the node with data only (next is null)
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add two numbers represented by linked lists
    public Node add2List(Node l1, Node l2) {
        int carry = 0; // Initialize carry to 0
        Node dummyNode = new Node(-1); // Dummy node to simplify result list construction
        Node current = dummyNode; // Pointer to build the result list
        Node t1 = l1; // Pointer to traverse the first list
        Node t2 = l2; // Pointer to traverse the second list

        // Traverse both lists until both are null
        while (t1 != null || t2 != null) {
            int sum = carry; // Start with the carry from the previous addition
            if (t1 != null)
                sum += t1.data; // Add value from the first list if not null
            if (t2 != null)
                sum += t2.data; // Add value from the second list if not null
            Node newNode = new Node(sum % 10); // Create a new node with the current digit
            carry = sum / 10; // Calculate the new carry
            current.next = newNode; // Attach the new node to the result list
            current = current.next; // Move the result list pointer forward

            // Move pointers of input lists forward if they are not null
            if (t1 != null)
                t1 = t1.next;
            if (t2 != null)
                t2 = t2.next;
        }

        // If there's a carry remaining after the final addition, create a new node
        if (carry == 1) {
            Node newNode = new Node(carry);
            current.next = newNode;
        }

        return dummyNode.next; // Return the result list, skipping the dummy node
    }
}
