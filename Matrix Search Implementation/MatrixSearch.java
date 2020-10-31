/**
 * We implement the search algorithm described in Problem 2.27 of
 * Weiss.
 */

public class MatrixSearch {
  
  /**
   * Returns true iff val is in the n x n array a. Assume that a is
   * arranged so that the elements in every row are in increasing
   * order from left to right, and the elements in every col are in
   * increasing order from top to bottom. The worst-case running time
   * of this method must be O(n).
   */  
  public static boolean contains(int val, int[][] a) {
      boolean ans = false;
    for (int i = 0; i < a[0].length; i++){
        for(int j = 0; j < a[0].length; j++){
            if (val == a[i][j]){
                ans = true;
                break;
            }
        }
    }
    return ans;
  }
  
  /**
   * Run some tests.
   */
  public static void main(String... args) {
    int[][] a;
    a = new int[][] {
        new int[] {  2, 14, 26, 37, 43, 51, },
        new int[] {  4, 16, 28, 38, 44, 54, },
        new int[] {  6, 18, 30, 39, 45, 57, },
        new int[] {  8, 20, 32, 40, 46, 60, },
        new int[] { 10, 22, 34, 41, 47, 63, },
        new int[] { 12, 24, 36, 42, 48, 66, },  
        };
    for (int[] row : a)
      for (int x : row)
        assert contains(x, a);
    for (int x = 15; x <= 35; x += 2)
      assert !contains(x, a);
    System.out.println(contains(0, a));
  }
}
