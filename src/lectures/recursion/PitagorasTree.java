package lectures.recursion;

import java.util.Arrays;

public class PitagorasTree {
    public static void main(String[] args) {
        createTriangle(11);
        nastedTriangles(5, 11);
    }

    private static void nastedTriangles(int base, int triangleBase) {
        int repeat = 0;
        int triangleHigh = (triangleBase + 1) / 2;
        int[] row = new int[triangleHigh];
        for(int i = 0; i < row.length; i++){
            row[i]= i++;
        }
        int row_=0;
        int rows = base * triangleBase + 4;
        for (int i = 0; i <= rows; i = i + 2) {
            if (i % ((triangleBase + 1)) == 0) {
                repeat++;
                System.out.println(repeat);
                /* System.out.println(row);*/
            }
            row_++;
            //System.out.println("                              " + row);
            for (int j = 0; j < (base * triangleBase - i + 3) / 2; j++)
                System.out.print("  ");
            for(int k = 0; k < repeat; k++ ){

            }
            for (int j = 0; j < i + 1; j++) {
                if (row_ * 2 - 1 - j > 0) {
                    System.out.print(" *");
                }else{
                    if (j-row_ > triangleBase-row_ ){
                        System.out.print(" *");
                    }else{
                        System.out.print("  ");
                    }
                }
            }
            for (int j = 0; j < (base * triangleBase - i); j++)
                System.out.print("  ");
            if (row_ % triangleHigh == 0) {
                row_ = 0;
            }
            System.out.println();
        }
    }

    private static void createTriangle(int base) { //must be even nbr
        for (int i = 1; i <= base; i = i + 2) {
            for (int j = 1; j < (base - i) / 2 + 1; j++)
                System.out.print("  ");
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            for (int j = 1; j < (base - i); j++)
                System.out.print(" |");
            System.out.println();
        }
    }

}
