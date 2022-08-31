import java.util.*;

//https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=609&page=show_problem&problem=514
public class TheSnail573 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int h = in.nextInt();
            if (h == 0) break;
            float u = in.nextInt(), d = in.nextInt(), f = in.nextInt();
            boolean suc = true;

            int i = 0;
            float curh = 0;
            float ff = (f * u) / 100f;
            //System.out.println("ff::" + ff);
            float prevClimb = u;
            while (true) {
               // System.out.println("itr:" + i + "::" + curh);
                //edge case when the snail gets out in one day
                curh += u  ;
                if(u>0) u-=ff;
//                System.out.println("itr:" + i + "::" + curh);
                if (curh > h) break;
                curh -= d;
                if(curh<0){suc = false;break;}
                //System.out.println("itr:" + i + "::" + curh);
                i++;
            }
//            System.out.println("curhh::" + curh);
            if (curh > h) {
                System.out.println("success on day " + (i+1) );
            } else {
                System.out.println("failure on day " + (i+1) );
            }
        }
    }
}
