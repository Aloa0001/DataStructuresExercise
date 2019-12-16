package chapter2;

public class

MaximumSubseguenceSumProblem {

    public static void main(String[] args) {

        int [] array = { 0, 1, -2, 3, 4, -5, 6, 7, 8 , -9, -10};
        System.out.println( maxSubSum3(array));
        System.out.println(maxSubSumCubic(array));
        System.out.println(maxSubSumQuadratic(array));

    }

    /**
     * CUBIC maximum cont sub sum algorithm
     *
     * @param array input
     * @return the sum of the elements
     */
    private static int maxSubSumCubic(int[] array) {
        int maxSum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += array[k];
                    if (thisSum > maxSum) {
                        maxSum = thisSum;
                    }
                }
            }
        }
        return maxSum;
    }

    /**
     * QUADRATIC maximum cont sub sum algorithm
     *
     * @param array input
     * @return the sum of the elements
     */
    private static int maxSubSumQuadratic(int[] array) {

        int maxSum = 0;

        for (int i = 0; i < array.length; i++) {

            int thisSum = 0;

            for (int j = i; j < array.length; j++) {

                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }

            }
        }
        return maxSum;
    }

    /**
     * RECURSIVE maximum cont sub sum algorithm
     *
     * @param array input
     * @return the sum of the elements
     */
    private static int maxSubSumRecursion(int[] array, int left, int right) {

        if (left == right)//base case
        {
            return Math.max(array[left], 0);
        }
        int center = (left + right) / 2;

        int maxLeftSum = maxSubSumRecursion(array, left, center);
        int maxRightSum = maxSubSumRecursion(array, center + 1, right);

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;

        for (int i = center; i >= left; i--) {
            leftBorderSum += array[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;

        for (int i = center; i >= left; i--) {
            rightBorderSum += array[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return Math.max(maxLeftSum,Math.max(maxRightSum,maxLeftBorderSum+maxRightBorderSum));
    }

    /**
     * Driver for divide-and-conquer maximum contiguous
     * @param array of values
     * @return max
     */
    private static int maxSubSum3(int [] array){
        return maxSubSumRecursion(array, 0, array.length -1);
    }
}
