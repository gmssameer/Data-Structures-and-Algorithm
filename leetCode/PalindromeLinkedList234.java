import org.w3c.dom.UserDataHandler;

public class PalindromeLinkedList234 {


    public static boolean isPalindrome(ListNode head) {

        ListNode fr = head;
        ListNode sd = head;

        while (sd != null) {
            System.out.println("fr: " + fr.val + " sd: " + sd.val);
            if (sd.next == null) {
                fr = fr.next;
                break;
            }
            fr = fr.next;
            sd = sd.next.next;

        }
//        System.out.println("fr = " + fr.val);

        ListNode cur = fr;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        boolean check = true;
        while (prev != null ) {
            System.out.println("pr: " + prev.val + " hd: " + head.val);
            if (prev.val != head.val) {
                check = false;
                break;
            }
            prev = prev.next;
            head = head.next;

        }

        return check;
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
        int[] vals = {1};
        ListNode head = null;

        for (int i = 0; i < vals.length; i++) {
            head = insert(head, vals[i]);
        }
        ListNode print = head;
//        while (print !=null){
//            System.out.println(print.val);
//            print = print.next;
//        }

        System.out.println(isPalindrome(head));

        System.out.println("############");
//        while (print != null) {
//            System.out.println(print.val);
//            print = print.next;
//        }


    }

}
