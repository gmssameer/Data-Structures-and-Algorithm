import java.util.ArrayList;
import java.util.List;

public class Triangle120  {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int []min = new int[n+1];
        for(int layer = n-1;layer>=0;layer--){
            for(int i=0;i<triangle.get(layer).size();i++){
//                System.out.println("layer:"+layer+" i:"+i+" val:"+triangle.get(layer).get(i));
                min[i]= Math.min(min[i],min[i+1]) + triangle.get(layer).get(i);
//                System.out.println(" min:"+min[i]);
            }
        }
        return min[0];
    }

    public static void main(String[] args) {

        int [][]nums = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> tri = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j:nums[i]){
                temp.add(j);
            }
            tri.add(temp);
        }

        for(int i=0;i<tri.size();i++){
            for(int j:tri.get(i))
                System.out.print(j+" ");
            System.out.print("\n");
        }

        System.out.println(minimumTotal(tri));
    }
}
