import java.util.Scanner;

public class NewYearAndHurry750A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int total=0,i = 0;

        for( i=1;i<=n;i++){
            total+= 5*i;
            if(total +k > 240) break;
        }

        System.out.println(i-1);



    }

}
