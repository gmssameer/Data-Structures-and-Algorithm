import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public static int majorityElement(int[] nums) {

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int j = 0;j<nums.length;j++){
            if(mp.containsKey(nums[j])){
                int k = mp.get(nums[j]);
                mp.put(nums[j],++k);
            }else {
                mp.put(nums[j],1);
            }
        }
        int max=-1,k=-1;
        for(Map.Entry<Integer,Integer> v : mp.entrySet()){
            if(v.getValue()>max){
                max = v.getValue();
                k= v.getKey();
            }
        }
        return k;

    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
