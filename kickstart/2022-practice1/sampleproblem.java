import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class sampleproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int caseId = 1; caseId <= testCases; caseId++){
            long total = 0;
            int n=sc.nextInt(),m=sc.nextInt();
            for (int k=0;k<n;k++){
                int c = sc.nextInt();
                total += c;
            }
                long d = total%m;
                System.out.println("Case #"+caseId+": "+d);

        }

    }
}
