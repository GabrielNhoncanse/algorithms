package search;

import java.util.ArrayList;
import java.util.List;

/*
 * Implements the Knuth-Morris-Pratt (KMP) algorithm for substring search.
 * This algorithm efficiently finds occurrences of a pattern within a text.
 */
public class KMP {
  /**
   * Computes the prefix table/failure function used in the KMP algorithm.
   * The table is used to avoid unnecessary comparisons.
   *
   * @param word The pattern to preprocess.
   * @return An array representing the longest prefix which is also a suffix at
   *         each substring word[0:i].
   */
  public static int[] getPrefixTable(String word) {
    int[] table = new int[word.length()];
    int pointer = 0;

    for (int i = 1; i < word.length(); i++) {
      while (pointer > 0 && word.charAt(i) != word.charAt(pointer)) {
        pointer = table[pointer - 1];
      }

      if (word.charAt(i) == word.charAt(pointer)) {
        pointer++;
        table[i] = pointer;
      }
    }

    return table;
  }

  /**
   * Finds the first occurrence of the given pattern in the text using the KMP
   * algorithm.
   *
   * @param text The text to search in.
   * @param word The pattern to find.
   * @return The starting index of the first occurrence of the pattern, or -1 if
   *         not found.
   */
  public static int firstOccurrence(String text, String word) {
    int[] prefixTable = getPrefixTable(word);

    int n = text.length();
    int pointer = 0;

    for (int i = 0; i < n; i++) {
      while (pointer > 0 && text.charAt(i) != word.charAt(pointer)) {
        pointer = prefixTable[pointer - 1];
      }

      if (text.charAt(i) == word.charAt(pointer)) {
        pointer++;
        if (pointer == word.length()) {
          return i - word.length() + 1;
        }
      }
    }

    return -1;
  }

  /**
   * Finds all occurrences of the given pattern in the text using the KMP
   * algorithm.
   *
   * @param text The text to search in.
   * @param word The pattern to find.
   * @return A list of starting indices where the pattern appears in the text.
   */
  public static List<Integer> allOccurrences(String text, String word) {
    int[] prefixTable = getPrefixTable(word);

    int n = text.length();
    int pointer = 0;
    List<Integer> indices = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      while (pointer > 0 && text.charAt(i) != word.charAt(pointer)) {
        pointer = prefixTable[pointer - 1];
      }

      if (text.charAt(i) == word.charAt(pointer)) {
        pointer++;
        if (pointer == word.length()) {
          indices.add(i - word.length() + 1);
          pointer = prefixTable[pointer - 1];
        }
      }
    }

    return indices;
  }
}
