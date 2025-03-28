package search;

public class BinarySearch {

  public static int search(int[] nums, int val) {
    if (nums.length == 0) {
      return -1;
    }
    int mid = nums.length / 2;
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      if (nums[mid] == val) {
        return mid;
      } else if (nums[mid] > val) {
        end = mid - 1;
        mid = (end + start) / 2;
      } else {
        start = mid + 1;
        mid = (end + start) / 2;
      }
    }

    return -1;
  }
}
