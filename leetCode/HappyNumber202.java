class HappyNumber202 {

    public static boolean isHappy(int n) {

        int e = n / 10;
        int sum = 0;
        if (e == 0) {
            if (n == 1)
                return true;
            else
                return false;
        }
        do {
            sum += Math.pow(n % 10, 2);
            n /= 10;

        } while (n > 0);

        return isHappy(sum);

    }

    public static void main(String[] args) {
        System.out.println("Output: " + isHappy(2));
    }

}