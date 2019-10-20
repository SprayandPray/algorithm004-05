package Question42TrappingRainWater;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trap1(height));
    }

    private static int trap(int[] height) {
        int result = 0;
        int size = height.length;

        for (int i = 0; i < size; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = max(max_right, height[j]);
            }
            result += min(max_left, max_right) - height[i];
        }
        return result;
    }

    private static int trap1(int[] height) {
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private static int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

}





















