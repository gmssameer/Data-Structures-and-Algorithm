import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/single-number/
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 *
 *
 *
 */
public class SingleNumber136 {
    /**
     * Hash Set or array method
     * Time : O(n)
     * space : O(n)
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int num = -1;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(temp.contains(nums[i])){
                temp.remove(Integer.valueOf(nums[i]));
            }
            else{
                temp.add(nums[i]);
            }
        }
        return temp.get(0);
    }

    /**
     * Xor method
     * (0^a = a )
     * (a^a = 0 )
     * a = 7
     * b = 5
     * 7    = 1 1 1 # In binary
     * 5    = 1 0 1 # In binary
     * a^a  = 0 0 0
     * 0^b  = 1 0 1 # b
     * return b
     *
     * @param nums
     * @return
     */
    public static int singeNumberXorMethod(int[] nums){
        int cn= 0;
        for(int i=0;i<nums.length;i++){
            cn ^= nums[i];
        }
        return cn;
    }

    public static void main(String[] args) {
        int [] nums = {2,2,1,3,3};
        System.out.println(singeNumberXorMethod(nums));
    }

}
