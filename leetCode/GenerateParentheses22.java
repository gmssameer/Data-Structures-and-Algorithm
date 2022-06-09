import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {


    public static List<String> recursion(List<String> res, String str, int left,int right,int max ){
        if(str.length() == max*2){
            res.add(str);
            return res;
        }
        if(left<max){
            recursion(res,str+"(",left+1,right,max);
        }
        if(right < left){
            recursion(res,str+")",left,right+1,max);
        }
        return res;
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = recursion(new ArrayList<>(),"",0,0,n);
        return res;
    }

    public static void main(String[] args) {
        int num = 3;
        List<String> res = generateParenthesis(num);
        for(String s:res) {
            System.out.println(s);
        }
    }

}
