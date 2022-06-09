public class FindPeakElement162 {


    public static int findPeakElement(int[] nums) {
        int l= 0,r= nums.length-1;


        while(l<r){
            int m = (l+r)/2;
            System.out.println("l:"+l+" r:"+r+" m:"+m);
            if(nums[m]>nums[m+1]){
                r = m;
            }
            else l =m+1;
        }

        return l;

    }


    public static void main(String[] args) {
        int [] nums = {1,9,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
