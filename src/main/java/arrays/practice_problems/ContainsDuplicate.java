package arrays.practice_problems;

import java.util.Scanner;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums = {1, 2, 3, 1};

        System.out.println(containsDuplicate(nums));
    }
}