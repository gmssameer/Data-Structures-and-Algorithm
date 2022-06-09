import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/230/B
 */
public class Tprimes230B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


       boolean[] primes = new boolean[1000001];

        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i < 1000001; i++) {
            for (int j = 2 * i; j < 1000001; j += i) {
                primes[j] = true;
            }

        }

//        for(int i=0;i<primes.length;i++){
//            System.out.println(i+":"+primes[i]);
//        }

        for(int i = 0;i< n;i++){
            long l = in.nextLong();
            if( l%Math.sqrt(l) ==0 && !primes[(int) Math.sqrt(l)]) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
