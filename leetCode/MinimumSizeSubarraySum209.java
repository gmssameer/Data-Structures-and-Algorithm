public class MinimumSizeSubarraySum209 {



    public static int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,n=nums.length,sum=0,len = Integer.MAX_VALUE;

        while (r<n){
            System.out.println("r:"+r+" sum:"+sum);
            sum+=nums[r++];
            while(sum>=target){
                System.out.println("l:"+l+" sum:"+sum);
                len = Math.min(len,r-l);
                sum-=nums[l++];
            }
        }
        return len == Integer.MAX_VALUE ? 0:len;
    }

    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }

}
