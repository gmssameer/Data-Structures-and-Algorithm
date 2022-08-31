import java.util.Scanner;

public class coloringGameE22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1;i<=n;i++){
            int k = in.nextInt();
            int cells = (k/2)+(k%2);
            int ans =0;
            if(cells % 2 ==0 ){
                ans = cells /2;
            }else {
                ans = (cells/2)+1;
            }
            System.out.println("Case #"+i+": " + ans);
        }
    }
}
