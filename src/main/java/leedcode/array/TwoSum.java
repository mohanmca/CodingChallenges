//package leedcode.array;
//
//import java.util.Arrays;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class TwoSum {
//    public static void main(String[] args) {
////        printNums(new int[]{1, 2, 3}, IntStream.range(0, 3).toArray());
////        printNums(new int[]{1, 2, 3, 4, 5}, new int[]{1, 3});
//        var nums = new int[]{1, 2, 3, 4, 5};
//        var indices = twoSum(nums, 6);
//        printNums(nums, indices);
//        nums = new int[]{1, 2, 3, 4, 5};
//        indices = twoSum(nums, 6);
//        printNums(nums, indices);
//        nums = new int[]{2, 3, 4, 5};
//        indices = twoSum(nums, 6);
//        printNums(nums, indices);
//    }
//
//    public static void printNums(int[] nums, int[] indices) {
//        Arrays.stream(indices).forEach(i -> System.out.print(nums[i] + ","));
//
//        System.out.println(Arrays.stream(indices).map(i -> nums[i]).sum());
//    }
//
//    public static int[] twoSum(int[] nums, int target) {
//        Arrays.sort();
//        for (int i = 0; i < nums.length - 1; i++) {
//            int j = Arrays.binarySearch(nums, target - nums[i], i + 1, nums.length);
//            if (j != -1) {
//                return new int[]{i, j};
//            }
//        }
//        return null;
//    }
//}
