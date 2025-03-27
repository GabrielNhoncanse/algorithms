package sorting;

/**
 * Implements the Insertion Sort algorithm.
 */
public class InsertionSort {

  /**
   * Sorts an array of integers using the Insertion Sort algorithm.
   * The algorithm works by moving larger elements to the right and inserting the
   * current element into its correct position.
   *
   * @param nums The array of integers to be sorted.
   */
  public static void sortArray(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int pointer = i;
      while (pointer > 0 && nums[pointer] < nums[pointer - 1]) {
        int aux = nums[pointer];
        nums[pointer] = nums[pointer - 1];
        nums[pointer - 1] = aux;

        pointer--;
      }
    }
  }
}
