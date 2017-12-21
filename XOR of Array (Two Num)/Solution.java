import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int findMaxXOR(int[] ar){
        int max = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--){
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for (int num : ar){
                set.add(num & mask);
            }

            int candidate = max | (1 << i);
            for (int num : set){
                if (set.contains(num^candidate)){
                    max = candidate;
                    break;
                }

            }
        }
        return max;

    }

    public static void main(String[] args) {

        int[] ar = {10, 11, 12, 13, 14, 15};

        System.out.println(findMaxXOR(ar));

    }
}
