package leedcode.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topFrequentElements(new int[]{1, 1, 1, 2, 3, 2}, 2)));
        System.out.println(Arrays.toString(topFrequentElements(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topFrequentElements(new int[]{1,2,2,3,3,3,4,4,4,4}, 2)));
    }

    public static int[] topFrequentElements(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> frequency = new HashMap<>(nums.length);
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((p, q) -> q.getValue() - p.getValue());
        pq.addAll(frequency.entrySet());
        int[] result = new int[k];

        while (k-- > 0) {
            result[k] = pq.remove().getKey();
        }
        return result;

    }

}
