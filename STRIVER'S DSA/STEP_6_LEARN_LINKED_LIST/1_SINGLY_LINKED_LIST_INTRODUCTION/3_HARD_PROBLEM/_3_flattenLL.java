import java.util.ArrayList;
import java.util.Collections;
public class _3_flattenLL {
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            this.data = x;
            this.next = null;
            this.bottom = null;
        }
    }
    Node convert(ArrayList<Integer>ans){
        if(ans.size()==0)return null;
        int n=ans.size();
        Node head=new Node (ans.get(0));
        Node temp=head;
        for(int i=1;i<n-1;i++){
            Node newNode=new Node(ans.get(i));
            temp.bottom=newNode;
            temp=temp.bottom;
        }
        return head;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        Node temp=root;
        while(temp!=null){
            Node temp2=temp;
            while(temp2!=null){
                ans.add(temp2.data);
                temp2=temp2.bottom;
            }
            temp=temp.next;
        }
        Collections.sort(ans);
        root=convert(ans);
        return root;
    }
    
    Node mergeTwoLists(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }
        if (list1 != null)
            res.bottom = list1;
        else
            res.bottom = list2;
        return dummyNode.bottom;
    }

    Node optimal_flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node mergeHead = flatten(root.next);
        return mergeTwoLists(root, mergeHead);
    }
}
