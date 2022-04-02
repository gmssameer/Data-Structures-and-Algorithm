import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CentauriPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = sc.nextInt();
        for (int i=1;i<=test_case;i++){
            String str = sc.next();
            char c =Character.toUpperCase(str.charAt(str.length()-1));
            if(c == 'Y'){
                System.out.println("Case #"+i+": "+str+" is ruled by nobody.");
            }
            else if( c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                System.out.println("Case #"+i+": "+str+" is ruled by Alice.");
            }
            else {
                System.out.println("Case #"+i+": "+str+" is ruled by Bob.");
            }
        }

    }
}
