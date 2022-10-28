import java.util.HashSet;

class HappyNumber202 {

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(n!=1 && !set.contains(n)){
            set.add(n);
            int sum = 0;
            do {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            } while (n > 0);
            // System.out.println("sum = " + sum);

            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + isHappy(7));
    }

}