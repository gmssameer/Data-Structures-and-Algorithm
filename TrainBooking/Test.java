import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static String solve(String s, String ip){
        HashMap<Character,Integer> dict = new HashMap<>();

        String op ="";

        char[] chars = new char[10];

        for(int i =0;i<s.length();i++){
            Character c = s.charAt(i);
            dict.put(c,i);
        }

        HashMap<Character, List<Integer>> ipds = new HashMap<>();

        for(int j=0;j<ip.length();j++){
            Character c =ip.charAt(j);
            if(ipds.containsKey(c)){
                List lt = ipds.get(c);
                lt.add(j);
                ipds.put(c,lt);
            }
            else {
                List lt = new ArrayList();
                lt.add(j);
                ipds.put(c,lt);
            }
        }


        for(Character c : ipds.keySet()){
            List<Integer> lt = ipds.get(c);
            boolean m = false;
            Integer ii = dict.get(c);
            if(lt.contains(ii)){
                for(int k : lt){
                    if(ii == k) chars[k]= 'G';
                    else chars[k]='R';
                }
            }

        }

        for(int j=0;j<ip.length();j++){
            Character c = ip.charAt(j);

            if(dict.containsKey(c)){
                if(dict.get(c) == j){
                    op+='G';
                }
                else op +='Y';
            }
            else op+='R';
        }
        return op;
    }

    public static void main(String[] args) {
        System.out.println(solve("CHALK","HIAUP"));
    }
}
