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

}
