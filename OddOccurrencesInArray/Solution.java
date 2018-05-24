import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public static int solution(int[] A){
        HashSet<Integer> set = new HashSet<>();
        for (int a : A){
            if (!set.remove(a)){
                set.add(a);
            }
        }

        if (set.size() > 1)
            return -1;

        Iterator<Integer> itr = set.iterator();
        return itr.next();
    }

    public static int solution2(int[] A) {
        // write your code in Java SE 8
        int elem = 0;

        for (int i = 0; i < A.length; i++) {
            elem ^= A[i];
        }
        return elem;
    }

    public static void main(String[] args) {
        int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};
        int[] A1 = new int[]{7, 9, 3, 9, 3, 9, 9};
        System.out.println(solution(A));
        System.out.println(solution2(A1));
    }
}
