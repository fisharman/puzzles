public class Solution {

    public static int solution(int[] A) {
        if (A.length < 4)
            return 0;

        int[] leftSums = new int[A.length];
        int[] rightSums = new int[A.length];
        int maxSum = 0;
        int sum = 0;

        for (int i = 1; i < A.length - 2; i++) {
            sum += A[i];

            if (sum < 0)
                sum = 0;

            leftSums[i] = sum;


        }

        sum = 0;
        for (int i = A.length - 2 ; i > 0; i--) {
            sum += A[i];

            if (sum < 0)
                sum = 0;

            rightSums[i] = sum;


        }

        for (int i = 1; i < A.length - 1; i++)
            maxSum = Math.max(maxSum, leftSums[i-1] + rightSums[i+1]);

        return maxSum;
    }


    public static void main(String[] args) {
        int[] A1 = new int[]{3, 2, 6, -1, 4, 5, -1, 2};
        int[] A2 = new int[]{6, 1, 5, 6, 4, 2, 9, 4};
        int[] A3 = new int[]{0, 10, -5, -2, 0};

        System.out.println(solution(A1));
        System.out.println(solution(A2));
        System.out.println(solution(A3));

    }
}
