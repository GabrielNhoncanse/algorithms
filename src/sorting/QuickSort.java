package sorting;

/**
 * Implements the Quick Sort algorithm.
 */
public class QuickSort {

  /**
   * This method calls the recursive version of the Quick Sort algorithm.
   *
   * @param nums The array of integers to be sorted.
   */
  public static void sortArray(int[] nums) {
    sortArray(nums, 0, nums.length - 1);
  }

  /**
   * This method partitions the array around a pivot element and sorts the
   * sub-arrays in-place.
   *
   * @param nums  The array of integers to be sorted.
   * @param start The starting index of the portion to be sorted.
   * @param end   The ending index of the portion to be sorted.
   */
  private static void sortArray(int[] nums, int start, int end) {
    if (start >= end)
      return;

    int mid = (end + start) / 2;
    int pivot = nums[mid];
    int index = start;

    int last = nums[end];
    nums[mid] = last;

    for (int i = start; i < end; i++) {
      if (nums[i] < pivot) {
        int aux = nums[index];
        nums[index] = nums[i];
        nums[i] = aux;
        index++;
      }
    }

    nums[end] = nums[index];
    nums[index] = pivot;

    sortArray(nums, start, index - 1);
    sortArray(nums, index + 1, end);
  }
}
