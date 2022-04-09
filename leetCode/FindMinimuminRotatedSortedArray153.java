/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 [4,5,6,7,0,1,2] if it was rotated 4 times.
 [0,1,2,4,5,6,7] if it was rotated 7 times.

 Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

 Given the sorted rotated array nums of unique elements, return the minimum element of this array
 *
 *
 */
public class FindMinimuminRotatedSortedArray153 {

    public static int findMin(int[] nums) {

        int f=0,l=nums.length-1;
        int n = nums.length;
        while (f<l){
            int m = (f+l)/2;

            if(nums[m]< nums[l]){
                l=m;
            }else{
                f=m+1;
            }

        }
        return nums[f];
    }


    public static void main(String[] args) {
        int [] nums = {11,13,15,17};
        System.out.println(findMin(nums));
    }
}
