public class Solution {
    public static int solution(int[] A){
        if (A.length < 2)
            return 0;

        int smallest = A[0];
        int maxProfit = 0;
        int profit;

        for (int i = 1; i < A.length; i++){
            smallest = Math.min(smallest, A[i]);
            profit = A[i] - smallest;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 23171;
        A[1] = 21011;
        A[2] = 21123;
        A[3] = 21366;
        A[4] = 21013;
        A[5] = 21367;

        System.out.println(solution(A));


    }
}
