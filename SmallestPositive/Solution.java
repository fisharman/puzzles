import java.util.HashSet;

public class Solution {
    public static int solution(int[] A) {
        // write your code in Java SE 8

        /*
        given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
        Given A = [1, 2, 3], the function should return 4.
        Given A = [−1, −3], the function should return 1.
         */

        int smallest = 1;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int a: A){
            if (a > 0){
                set.add(a);
                if (set.contains(smallest))
                    smallest++;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,3,4};
        A = new int[]{1,2,3,4};
        System.out.println(solution(A));
    }
}
