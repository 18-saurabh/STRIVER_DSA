import java.util.ArrayList;
public class _2_findPairsWithGivenInDLL {
    class Node{
        int data;
        Node next,prev;
        Node(int data,Node next,Node prev){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev=null;
        }
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node temp1=head;
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        while(temp1!=null){
            Node temp2=temp1.next;
            while(temp2!=null&&(temp1.data+temp2.data)<=target){
                if(temp1.data+temp2.data==target){
                    ArrayList<Integer>pair=new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);
                    ans.add(pair);
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return ans;
        
    }
}
