import java.util.*;

/**
 * https://codeforces.com/problemset/problem/520/B
 */
public class TwoButtons520B {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int depth = 0;

        while(n<m){
            if(m%2 == 1) m++;
            else m/=2;
            depth++;
//            System.out.println(depth +" "+m);
        }

        System.out.println(depth+n-m);


    }

}
