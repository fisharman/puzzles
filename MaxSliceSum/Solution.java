public class Solution {
    public static int solution(int[] A){
        if (A.length == 1)
            return A[0];

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < A.length; i++){
            sum += A[i];

            if (sum > maxSum)
                maxSum = sum;

            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    public static int solution1(int[] A) {
        if (A.length == 1)
            return A[0];

        int maxSum = A[0];
        int sum;

        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i + 1; j < A.length; j++){
                sum += A[j];
                if (sum > maxSum)
                    maxSum = sum;
            }

        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] A = new int[]{3,2,-6,4,0};
        A = new int[]{-7, -5, 7};
        A = new int[]{-7, -5, -1};
        A = new int[]{-7, 5};
        System.out.println(solution(A));

    }
}
