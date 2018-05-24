public class Solution {
    public static int solution(int N){
        int maxGap = 0;
        int gap = 0;

        while (N > 0) {
            if ((N & 1) == 1) {
                N = N >> 1;
                while (N > 0 && (N & 1) == 0){
                    gap++;
                    N = N >> 1;
                }
                maxGap = Math.max(gap, maxGap);
                gap = 0;
            }else {
                N = N >> 1;
            }
        }
        return maxGap;

    }

    public static void main(String[] args) {
        int N = 0b10100;
        System.out.println(solution(N));

    }
}
