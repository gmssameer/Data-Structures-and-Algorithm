public class JumpGameII45 {


    public static int jump(int[] nums) {
        int i=0,lastJumpedPos=0,max=0,depth=0,n= nums.length;
        while(lastJumpedPos <n-1){
            max = Math.max(max,i+nums[i]);
            if(i == lastJumpedPos){
                lastJumpedPos = max;
                depth++;
            }
            i++;
        }
        return depth;
    }

    public static void main(String[] args) {
        int [] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }

}
