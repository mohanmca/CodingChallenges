package educative;

public class AvgContiniguousSubArrayMovingWindow {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(movingAvgSum(nums, 3));
    }

    public static int movingAvgSum(int[] nums, int k) {
        int total = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i + 1 >= k) {
                total += sum;
                sum -= nums[i - (k - 1)];
            }
        }
        return total / (nums.length - (k - 1));
    }
}
