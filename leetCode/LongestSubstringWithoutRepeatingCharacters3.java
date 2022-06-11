import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters3 {


    public static int lengthOfLongestSubstring(String s) {
        int j =0,max=0;


        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
//            System.out.println("i:"+i+" j:"+j);
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;

    }


    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
