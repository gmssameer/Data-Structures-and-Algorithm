import java.util.Arrays;
import java.util.Scanner;

public class VanyaAndLanterns492B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),l = in.nextInt(), a[] = new int[n];

        for(int i=0;i<n;i++) a[i] = in.nextInt();

        Arrays.sort(a);

        double max = Math.max(a[0],l-a[n-1]);

        for(int i=0;i<n-1;i++){
            max = Math.max(max,(a[i+1]-a[i])/2.0);
        }


        System.out.println(max);

    }

}
