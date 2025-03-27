package sorting;

import java.util.Arrays;

/**
 * Implements the Merge Sort algorithm.
 */
public class MergeSort {

  /**
   * Sorts an array of integers using the Merge Sort algorithm.
   * This method recursively splits the array into two halves, sorts each half,
   * and then merges the sorted halves.
   *
   * @param nums The array of integers to be sorted.
   * @return The sorted array.
   */
  public static int[] sortArray(int[] nums) {
    if (nums.length == 1)
      return nums;

    int mid = nums.length / 2;

    int[] leftSide = Arrays.copyOfRange(nums, 0, mid);
    int[] rightSide = Arrays.copyOfRange(nums, mid, nums.length);

    int[] sortedLeft = sortArray(leftSide);
    int[] sortedRight = sortArray(rightSide);

    return mergeArrays(sortedLeft, sortedRight);
  }

  /**
   * Merges two sorted arrays into a single sorted array.
   *
   * @param array1 The first sorted array.
   * @param array2 The second sorted array.
   * @return A new array containing all elements from both arrays, sorted.
   */
  private static int[] mergeArrays(int[] array1, int[] array2) {
    int pointer1 = 0;
    int pointer2 = 0;
    int[] result = new int[array1.length + array2.length];

    while (pointer1 < array1.length && pointer2 < array2.length) {
      result[pointer1 + pointer2] = (array1[pointer1] < array2[pointer2]) ? array1[pointer1++] : array2[pointer2++];
    }

    while (pointer1 < array1.length) {
      result[pointer1 + pointer2] = array1[pointer1];
      pointer1++;
    }

    while (pointer2 < array2.length) {
      result[pointer1 + pointer2] = array2[pointer2];
      pointer2++;
    }

    return result;
  }
}
