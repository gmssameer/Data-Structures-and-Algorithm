/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity
 */
public class FirstandLastPositionElementSortedArray34 {

    public static int recSearch(int []nums,int f,int l,int t,boolean findStartIndex){
        int ans = -1;
        while(f<=l){
            int m = (f+l)/2;

            if(nums[m] > t){
                l=m-1;
            }
            else if(nums[m] < t){
                f=m+1;
            }
            else{
                ans = m;
                if(findStartIndex)
                    l = m - 1;
                else
                    f = m + 1;
            }
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
            int []solution = new int[]{-1,-1};
            int f=0,l=nums.length-1;
            int si = recSearch(nums,f,l,target,true);
            int sf = recSearch(nums,f,l,target,false);
            return new int[]{si,sf};
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target =8;
        int [] sol = searchRange(nums,target);
        System.out.println(sol[0]+" "+sol[1]);
    }
}
