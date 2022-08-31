import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Newspaper11340 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0){
            HashMap<Character,Integer> values = new HashMap<>();
            int d=0,ce = 0;
            float f = 0f;
            int k = in.nextInt();
            HashMap<Character,Integer> counts = new HashMap<>();
            for(int i=0;i<k;i++){
                String c = in.next();
                int cc = in.nextInt();
                values.put(c.charAt(0),cc);
            }
            int m = in.nextInt();
            for(int i=0;i<=m;i++){
                String str = in.nextLine();
                char []strarr = str.toCharArray();
                for(char s:strarr){
                    if(values.containsKey(s)) {
                        if (counts.containsKey(s)) {
                            counts.put(s, counts.get(s) + 1);
                        } else {
                            counts.put(s, 1);
                        }
                    }
                }
            }

            for(Map.Entry<Character,Integer> key : counts.entrySet()){
                Character c = key.getKey();
                if(values.containsKey(c)) {
                    int cents = values.get(c) * key.getValue();
//                    System.out.println("c = " + c+" count: "+key.getValue());
                    ce += cents;
                    if (ce >= 100) {
                        d += ce / 100;
                        ce = ce % 100;
                    }
                }

            }

            System.out.println(d+"."+String.format("%02d", ce)+"$");
        }
    }
}

