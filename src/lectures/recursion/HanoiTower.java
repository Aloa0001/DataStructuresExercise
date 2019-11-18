package lectures.recursion;

public class HanoiTower {
    public static class TowersOfHanoi {
        public static void showMoves(int n, char startPeg, char destPeg, char tempPeg) {
            if (n == 1) {
                System.out.println( "Move disk 1 from peg " + startPeg + " to peg " + destPeg );
            } else { // Recursive step
                showMoves(n - 1, startPeg, tempPeg, destPeg);
                System.out.println( "Move disk" + n + " from peg" +startPeg + "to peg" +destPeg );
                showMoves(n - 1, tempPeg, destPeg, startPeg);
            }
        }
        public static void main(String[] args) {
            int n = 3; char startPeg = 'L', destPeg = 'R', tempPeg = 'M';
            showMoves( n, startPeg, destPeg, tempPeg);
        }
    }

}
