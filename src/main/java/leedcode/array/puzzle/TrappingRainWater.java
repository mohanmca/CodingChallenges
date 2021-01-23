package leedcode.array.puzzle;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] rainWater = new int[]{0, 1, 2, 0, 2, 1, 0};
        System.out.println(trap(rainWater));
        rainWater = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(rainWater));
        rainWater = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(rainWater));
        rainWater = new int[]{0};
        System.out.println(trap(rainWater));
        rainWater = new int[]{2,0,2};
        System.out.println(trap(rainWater));
    }

    public static int trap(int[] height) {
        if (height.length < 3) return 0;
        int[] trapped = new int[height.length];
        int highestLevel = 0, left = 0, right = height.length - 1;
        while (left < height.length - 1 && height[left] < height[left + 1]) {
            trapped[left] = 0;
            left++;
        }

        while (right > 0 && height[right] < height[right - 1]) {
            trapped[right] = 0;
            right--;
        }
        highestLevel = height[left];
        for (int i = left; i < right; i++) {
            if (highestLevel < height[i]) {
                highestLevel = height[i];
                trapped[i] = 0;
            } else {
                trapped[i] = highestLevel - height[i];
            }
        }

        highestLevel = height[right];
        for (int i = right; i > left; i--) {
            if (highestLevel < height[i]) {
                highestLevel = height[i];
                trapped[i] = 0;
            } else {
                trapped[i] = Math.min(highestLevel - height[i], trapped[i]);
            }
        }
        return Arrays.stream(trapped).sum();
    }
}
