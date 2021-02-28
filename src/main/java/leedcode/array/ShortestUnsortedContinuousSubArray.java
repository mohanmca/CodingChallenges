package leedcode.array;


import code.challenge.AlgorithmUtils;

public class ShortestUnsortedContinuousSubArray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubArray solution = new ShortestUnsortedContinuousSubArray();
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 3, 2});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 3, 2, 2, 2});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{5, 4, 3, 2, 1});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 2, 3});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{2, 3, 3, 2, 4});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 2, 3, 3, 3});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{3, 2});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 3, 2, 4});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 3, 2, 4, 5});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 3, 2, 5, 4, 6, 7});
        AlgorithmUtils.printInvokeReturn(solution::findUnsortedSubarray, new int[]{1, 3, 2, 4, 5, 100, 6, 7, 8, 9, 10, 101, 120});
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        //Array of size 2 is special case
        if (nums.length == 2 && nums[0] > nums[1]) return nums.length;

        int l = 0, r = nums.length - 1, n = nums.length;

        while (l < n - 1 && nums[l] <= nums[l + 1])
            l++;

        if (l == r) return 0;

        while (r > 0 && nums[r] >= nums[r - 1])
            r--;

        if (r == nums.length - 1) return nums.length - l;

        // Element we found on left of the right, could be much - much bigger than bigger element to the right of the right
        // [1, 3, 2, 4, 5, 100, 6, 7, 8, 9, 10, 101, 120]
        // l = 1, right = 5 (+5)
        int pivot = nums[r - 1];
        while (r < nums.length - 1 && nums[r + 1] < pivot)
            r++;

        pivot = nums[l + 1];
        while (l > 0 && nums[l] > pivot)
            l--;

//        int length = (l == 0 && r == nums.length - 1) ? nums.length : r - l;
        return r - l;
    }
}
