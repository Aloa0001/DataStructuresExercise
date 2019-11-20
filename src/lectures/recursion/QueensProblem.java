package lectures.recursion;

import outsideTheBookInfo.hashes.Hash;

import java.util.Arrays;

public class QueensProblem {
    public static void main(String[] args) {
        printMapOne(queensProblem(0,0, new boolean[64]));
        //System.out.println(countQueens(queensProblem(0, new boolean[64])));
    }

    private static boolean[] queensProblem(int iteration, int indexToStart, boolean[] queens) {
       if (iteration > 0){
           for(int i = 0; i < iteration; i++){
               queens[i] = true;
           }
       }
        queens[indexToStart] = true;
        int row = indexToStart / 8;
        int column = indexToStart % 8;
        for (int i = indexToStart; i < queens.length; i++) {
            int newColumn = i % 8;
            int newRow = i / 8;
            if (newRow == row || newColumn == column || Math.abs(newRow - row) == Math.abs(newColumn - column) || newColumn == 0) {
                queens[newRow * 8 + newColumn] = true;
            }
        }
        queens[indexToStart] = false;
        if (countAvailableQueens(indexToStart + 1, queens) > 0 && indexToStart < queens.length - 1) {
            do {
                indexToStart++;
            } while (queens[indexToStart]);
            queensProblem(iteration, indexToStart, queens);
        } else {
            return queens;
        }
        return queens;
        /*if (countQueens(queens) > 7) {
            return queens;
        } else {
            boolean[] q = new boolean[queens.length];
            int newStart = iteration +1;
            for(int i = 0; i < iteration-1; i++){
                q[i] = true;
            }
            *//*printMapOne(queens);
            System.out.println();*//*
            return queensProblem(newStart, q);
        }*/
    }


    private static int countAvailableQueens(int index, boolean[] queens) {
        int available = 0;
        for (int i = index; i < queens.length; i++) {
            if (!queens[i]) {
                available++;
            }
        }
        return available;
    }

    private static int countQueens(boolean[] queens) {
        int count = 0;
        for (boolean x : queens) {
            if (!x) {
                count++;
            }
        }
        return count;
    }

    private static void printMapOne(boolean[] rows) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!rows[i * 8 + j]) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
    }

    /*private static boolean[][] queensProblem() {
        boolean[][] rows = new boolean[8][8];
        boolean[] queens = new boolean[64];
        int row = 0;
        int column = 0;
        while (countQueens(rows) < 8) {
            for (int startRow = row; startRow < 8; startRow++) {
                for (int startColumn = column; startColumn < 8; startColumn++) {

                    for (int setRow = 0; setRow < 8; setRow++) {
                        for (int setColumn = 0; setColumn < 8; setColumn++) {
                            if (setRow == startRow || startColumn == setColumn ||
                                    Math.abs(setRow - startRow) == Math.abs(setColumn - startColumn) ||
                                    row != setRow && column != setColumn) {
                                rows[setRow][setColumn] = true;
                            }
                        }
                    }
                }
            }
            printMap(rows);


        }
        return rows;
    }*/

    /*private static int countQueens(boolean[][] rows) {
        int queens = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (! rows[i][j]) {
                    queens++;
                }
            }
        }
        return queens;
    }*/

    /*private static void printMap(boolean[][] rows) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!rows[i][j]) {
                    System.out.print("false");
                } else {
                    System.out.print("true ");
                }
            }
            System.out.println();
        }
    }*/
}