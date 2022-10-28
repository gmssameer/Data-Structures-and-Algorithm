class ListNode {
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

public class RemoveNthNodeFromEndOfList19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = null;
        ListNode fast = head;
        int i = 1;
        while (fast.next != null) {
//            System.out.println("i = " + i+" slow:"+slow.val+" fast: "+fast.val);
            if (i >= n) {
                if (slow == null) {
                    slow = head;
                }else {
                    slow = slow.next;
                }
            }
            fast = fast.next;
            i++;
        }
        System.out.println("slow: " + slow + " fast: " + fast.val);
        if (slow == null) {
            head = head.next;
            return head;
        }
        if (slow == fast) {
            return null;
        }
        if (slow.next.next == null) {
            slow.next = null;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }

    public static ListNode insert(ListNode list,
                                  int data) {
        // Create a new node with given data
        ListNode new_node = new ListNode(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list == null) {
            list = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            ListNode last = list;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    public static void main(String[] args) {
        int[] vals = {1, 2,3,4,5};
        ListNode head = null;

        for (int i = 0; i < vals.length; i++) {
            head = insert(head, vals[i]);
        }
        ListNode print = head;
//        while (print !=null){
//            System.out.println(print.val);
//            print = print.next;
//        }

        print = removeNthFromEnd(head, 3);

        System.out.println("############");
        while (print != null) {
            System.out.println(print.val);
            print = print.next;
        }


    }

}
