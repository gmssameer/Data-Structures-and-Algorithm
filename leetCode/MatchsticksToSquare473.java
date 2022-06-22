import java.util.Arrays;

public class MatchsticksToSquare473 {


    public static boolean dfs(int[] nums, int[] sums, int index, int target) {

//        System.out.println("\nmask:"+mask);

        if (index < 0) {

            return true;

        }

        for (int j = 0; j < 4; j++) {
            sums[j] += nums[index];
            if (sums[j] <= target) {
                if (dfs(nums, sums, index - 1, target)) {
                    return (true);
                }
            }

            sums[j] -= nums[index];
        }
        return false;

    }

    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) sum += i;

        if (sum % 4 != 0) return false;

        int n = matchsticks.length;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        return dfs(matchsticks, new int[4], matchsticks.length - 1, target);


    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        System.out.println(makesquare(nums));
    }

}
