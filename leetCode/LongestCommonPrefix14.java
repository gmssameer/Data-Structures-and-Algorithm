import java.nio.charset.Charset;

public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {

        int l = strs[0].length();
        StringBuilder ans = new StringBuilder("");
        for(int i=0;i<l;i++){
            char c= strs[0].charAt(i);
            int k=0;
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length()) continue;
                System.out.println("k = " + k+" c0= "+c +" ck = "+strs[j].charAt(i));
                if(c == strs[j].charAt(i)) {
//                     ans.append(c);
                    k++;
                }else  if(c != strs[j].charAt(i))  {k=-1; break;}
            }
            System.out.println("k = " + k+" c= "+c);
            if(k==-1) break;
            if(k == strs.length -1){
                ans.append(c);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
//        String [] strs = {"flower","flawer","flvwer","flower"};
        String [] strs = {"cir","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
