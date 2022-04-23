public class RemoveDuplicatesfromSortedListII82 {


//      Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        ListNode prev =null;

        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                while ((cur.next != null) && (cur.val == cur.next.val)){
                    cur = cur.next;
                }
                if(prev == null){
                    head = cur.next;
                }
                else{
                    prev.next = cur.next;
                }
                cur = cur.next;
            }
            else{
                if(prev == null){
                    prev = cur;
                }
                else{
                    prev = prev.next;
                }
                cur = cur.next;
            }
        }

//
//
//        if(head != null && head.next!=null){
//
//            while(cur.next != null){
//
////                ListNode next = cur.next;
////                System.out.println(prev.val+" "+cur.val+" "+cur.next.val);
//
//                if(cur.val == cur.next.val ){
//                    while (cur.val == cur.next.val){
//                        cur = cur.next;
//                    }
//                    prev.next = cur.next;
////                    prev= cur;
//                    cur = cur.next;
//                }
//                else{
////                    prev.next = cur.next;
//                    prev= cur;
//                    cur = cur.next;
//
//                }
//            }
//          }

        return head;
    }

    public static void main(String[] args) {
        int [] nums = { 1,2,3,3,4,4,5};
        ListNode head = new ListNode();
        ListNode cur = new ListNode(nums[nums.length-1]);
        for (int i = nums.length-2;i>=0;i--){
            ListNode newNode = new ListNode(nums[i]);
            newNode.next = cur;
            cur = newNode;
        }
        head = cur;



        printList(deleteDuplicates(head));

    }

    public static void printList(ListNode head){
          if(head!=null){
              ListNode cur = head;
              while (cur != null){
                  System.out.print(cur.val+" ");
                  cur = cur.next;
              }
          }



    }

}
