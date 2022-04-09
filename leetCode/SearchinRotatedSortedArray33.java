import java.util.Arrays;

public class SearchinRotatedSortedArray33 {
    public static int search(int[] nums, int target) {
        int k=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                k=i+1;
                break;
            }
        }
        return bserch(nums,0,nums.length,k,target);

    }

    public static int bserch(int []arr, int s,int e,int k,int t){
        if(s<=e){
            int m = (s+e)/2;
            int i = (m + k)%arr.length;
//            System.out.println(s+" ,"+e+" ,"+m+" ,"+i);
            if(arr[i]==t){
                return i;
            }
            else if(arr[i]< t){
                return bserch(arr,m+1,e,k,t);
            }
            else{
                return bserch(arr,s,m-1,k,t);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target =6;
        System.out.println(search(nums,target));


    }
}
