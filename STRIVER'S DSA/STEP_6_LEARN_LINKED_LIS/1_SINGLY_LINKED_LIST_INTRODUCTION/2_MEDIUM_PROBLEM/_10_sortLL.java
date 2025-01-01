import java.util.ArrayList;
import java.util.Collections;

public class _10_sortLL {
      public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
     public ListNode brute_sortList(ListNode head) {
        if(head==null)return null;
        ArrayList<Integer>ans=new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            ans.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(ans);
        temp=head;
        int i=0;
        while(temp!=null){
            temp.val=ans.get(i);
            temp=temp.next;
            i++;
        }
        return head;
    }
      public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Split the list into two halves
        ListNode middle = slow.next;
        slow.next = null; // Disconnect the left half from the right half
        return middle;
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        // Attach the remaining nodes from either list
        if (list1 != null) {
            temp.next = list1;
        } else if (list2 != null) {
            temp.next = list2;
        }
        return dummyNode.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleNode = findMiddle(head);
        ListNode leftHead = sortList(head);        // Sort the left half
        ListNode rightHead = sortList(middleNode); // Sort the right half
        return mergeTwoList(leftHead, rightHead);  // Merge the sorted halves
    }


}
