package leedcode.array.easy;

import code.challenge.AlgorithmUtils;

import java.util.Arrays;

public class DistributeCandies {

    public static void main(String[] args) {
        DistributeCandies solution = new DistributeCandies();
        AlgorithmUtils.printInvokeReturn(solution::distributeCandies, new int[]{1, 1, 1, 1});
        AlgorithmUtils.printInvokeReturn(solution::distributeCandies, new int[]{1,1,2,2,3,3});
        AlgorithmUtils.printInvokeReturn(solution::distributeCandies, new int[]{1,1,2,3});
    }

    public int distributeCandies(int[] candyType) {
        int maximumCandies = candyType.length / 2;
        Arrays.sort(candyType);
        int maxCandiType = 1;
        int prev = candyType[0];
        for (Integer num : candyType) {
            if (prev != num) {
                maxCandiType++;
            }
            prev = num;
        }
        return Math.min(maximumCandies, maxCandiType);

    }
}
