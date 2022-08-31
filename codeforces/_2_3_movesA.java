import java.util.Scanner;

public class _2_3_movesA {

    public static int solution(int n) {
        int q = n % 3;
        if (n == 1) return 2;
        if (q == 0) return n / 3;
        else return (n / 3) + 1;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solution(n));
        }
    }

}
