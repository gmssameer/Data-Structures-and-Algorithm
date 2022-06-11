import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorder(List<Integer> vals, TreeNode root) {
        if (root == null) {
            return vals;
        }
        inorder(vals, root.left);
        vals.add(root.val);
        inorder(vals, root.right);

        return vals;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        return inorder(new ArrayList<>(), root);
    }

    public static TreeNode insertLevelOrder(ArrayList<Integer> arr, int i) {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.size()) {

            if (arr.get(i) != null) {
                root = new TreeNode(arr.get(i));
                // insert left child
                root.left = insertLevelOrder(arr, 2 * i + 1);

                // insert right child
                root.right = insertLevelOrder(arr, 2 * i + 2);
            }

        }
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList();
        nums.add(1);
        nums.add(null);
        nums.add(2);
        nums.add(null);
        nums.add(null);
        nums.add(3);
        System.out.println(inorderTraversal(insertLevelOrder(nums, 0)).toString());
    }
}
