public class _2_rotateList {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }
    public ListNode findKthNode(ListNode node, int k) {
        ListNode temp = node;
        int count = 0;
        while (temp != null && k > 0) {
            count++;
            if (count == k) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0)return head;
        k=k%len;
        tail.next=head;
        ListNode newLastNode=findKthNode(head,len-k);
        head=newLastNode.next;
        newLastNode.next=null;
        return head;
    }
}
