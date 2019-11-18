package lectures.recursion;

public class NestedTriangle {
    public static void main(String[] args) {
        nestedTriangle(3, 5);
    }

    private static void nestedTriangle(int pyramidBase, int triangleBase) {
        int repeat = 1;
        int triHigh = (triangleBase + 1) / 2;
        int pyrHigh = pyramidBase * (triangleBase + 1) / 2;
        int[] stars = new int[pyrHigh];
        stars[0] = 1;
        for (int i = 1; i < stars.length; i++) {
            stars[i] = stars[i - 1] + 2;
        }
        for (int i = 0; i < pyrHigh; i++) {
            for (int j = 0; j < pyrHigh - i; j++) {
                System.out.print("  ");
            }
            if (i < triHigh) {
                for (int j = 0; j < stars[i]; j++) {
                    System.out.print(" *");
                }
            } else {
                if (i % triHigh == 0) {
                    repeat++;
                }
                //System.out.print(repeat);
                for (int k = 0; k < repeat; k++) {
                    if (i < triHigh * 2) {
                        for (int m = 0; m < stars[i] - triangleBase - 1; m++) {
                            System.out.print(" *");
                        }
                        for (int m = 0; m < stars[i] - (stars[i] - triangleBase - 1) * 2; m++) {
                            System.out.print("  ");
                        }
                    }else{
                        int g = i%(triangleBase+1);
                        for (int m = 0; m < stars[g]; m++) {
                            System.out.print(" *");
                        }
                        g = (stars[i]+1)%repeat;
                        for (int m = 0; m < stars[g]; m++) {
                            System.out.print("  ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
