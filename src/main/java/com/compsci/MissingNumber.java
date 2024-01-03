package main.java.com.compsci;

import java.util.*;
import java.util.stream.Collectors;

public class MissingNumber {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] numbers, int maxNum){

        Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;

    }

    public static int missingNumberSorted(int[] numbers, int maxNum) {

        Arrays.sort(numbers);

        if (numbers.length == maxNum && numbers[maxNum - 1] == maxNum) {
            return 0;
        }
        else{
            for (int i = 1; i < maxNum; i += 1) {
                if (i != numbers[i - 1]) {
                    return i;
                }
            }
        }

        return maxNum;
    }

    public static int missingNumberSum(int[] nums, int maxNum) {

        int sumTotal = 0;

        for (int i = 1; i <= maxNum; i += 1) {
            sumTotal += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return sumTotal - actualSum;
    }
}
