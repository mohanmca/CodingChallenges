package leedcode.array;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(maxJum(new int[]{}));
        System.out.println(maxJum(new int[]{0}));
        System.out.println(maxJum(new int[]{2, 3, 1, 1, 4}));
        System.out.println(maxJum(new int[]{2, 3, 1, 1,0,0,4}));
    }

    private static boolean maxJum(int[] nums) {
        int finalIndex = 0;
        for (int i = 0; i < nums.length && finalIndex >= i; i++) {
            finalIndex = Math.max(finalIndex, i + nums[i]);
        }
        return finalIndex >= nums.length-1;
    }
}
