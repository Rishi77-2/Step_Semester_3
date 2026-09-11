package arrays.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums = {2, 7, 11, 15};

        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}