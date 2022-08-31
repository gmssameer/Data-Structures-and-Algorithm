import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=609&page=show_problem&problem=1082
public class RequestforProposal10141 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String l = in.nextLine();
            String[] sp = l.split(" ");
            int n = Integer.parseInt(sp[0]), p = Integer.parseInt(sp[1]);
            if(n ==0 ){
                break;
            }
            String ans = null;
            int index = -1;
            float min_amt = Float.MAX_VALUE;
            float max_com = 0f;
            Set<String> cat = new HashSet<>();
//        System.out.println("n = " + n);
//        System.out.println("p = " + p);
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
//            System.out.println("s = " + s);
                cat.add(s);
            }

            for (int i = 0; i < p; i++) {
//                System.out.println("#####:: "+i);
                String name = in.nextLine();

                l = in.nextLine();
                sp = l.split(" ");
                float amt = Float.parseFloat(sp[0]);
                int d = Integer.parseInt(sp[1]);
                int dd =  0;
                for (int j = 0; j < d; j++) {
                    String r = in.nextLine();
                    if(cat.contains(r)) dd++;
                }
                float com = (float) dd / n;

//            System.out.println("Max com = " + max_com);
//            System.out.println("com = " + com);
//            System.out.println("Min amt = " + min_amt);
//            System.out.println("amt = " + amt);

                if (Float.compare(com, max_com) >0) {
//                    System.out.println("iin max com");
//                    System.out.println("index::"+i);
                    min_amt = amt;
                    max_com = com;
                    ans = name;
                    index = i + 1;
                }
                else if(Float.compare(com, max_com) == 0){
                    if (Float.compare(amt, min_amt) < 0) {
//                        System.out.println("index::"+i);
                        min_amt = amt;
                        max_com = com;
                        ans = name;
                        index = i + 1;
                    }
                }

            }
            System.out.println("");
            System.out.println("RFP #" + index);
            System.out.println(ans);

        }
    }
}
