import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Armybuddies12356 {
    static class Soldier {
        int left, right;

        public Soldier(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        while (true) {
            String[] vals = in.readLine().split(" ");
            int s = Integer.parseInt(vals[0]), b = Integer.parseInt(vals[1]);;
            if (s == 0) break;

//            BitSet bits = new BitSet(s+1);
            Soldier[] sols = new Soldier[s + 2];
            sols[0] = new Soldier(0, 1);
            sols[s + 1] = new Soldier(s, s + 1);

            for (int i = 1; i <= s; i++) {
                sols[i] = new Soldier(i - 1, i + 1);
            }

            for (int i = 0; i < b; i++) {
                vals = in.readLine().split(" ");
                int l = Integer.parseInt(vals[0]), r = Integer.parseInt(vals[1]);
                String ll = "*";
                String rl = "*";
                if (sols[l].left > 0) {
                    sols[sols[l].left].right = sols[r].right;
                    ll = String.valueOf(sols[l].left);
                }
                if (sols[r].right <= s) {
                    sols[sols[r].right].left = sols[l].left;
                    rl = String.valueOf(sols[r].right);
                }
                System.out.println(ll+" "+rl);


            }


//            for (int i = 0; i < b; i++) {
//                int l = in.nextInt(), r = in.nextInt();
//                bits.set(l,r+1);
//                String ll = "*";
//                String rl = "*";
//                for(int k=l-1;k>0;k--){
//                    boolean j = bits.get(k);
//                    if(!j){
//                        ll = String.valueOf(k);
//                        break;
//                    }
//                }
//                for(int k=r+1;k<=s;k++){
//                    boolean j = bits.get(k);
//                    if(!j){
//                        rl = String.valueOf(k);
//                        break;
//                    }
//                }
//                System.out.println(ll+" "+rl);
//
//            }
            System.out.println("-");
        }
    }
}
