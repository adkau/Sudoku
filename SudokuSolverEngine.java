// Aaron Kaufman
// CS 143
//HW #3: Sudoku #3 (solve method)

// Main Class that tests the new solve method
import java.io.FileNotFoundException;

public class SudokuSolverEngine {

   //pre: none
   //post: prints an error message if the board is in an invalid state
   public static void invalidBoard(SudokuBoard board) {
      if (!board.isValid())
         System.err.println("the board is in an invalid state so it cannot be solved"); 
      else
         System.out.println("the board is in a valid state so it can be solved");
   }
   //pre: none
   //post: prints an error message if the board is already solved
   public static void solvedBoard(SudokuBoard board) {
      if (board.isSolved())
         System.err.println("the board is already solved"); 
      else
         System.out.println("the board is not solved yet");
   }

   public static void main(String[] args) throws FileNotFoundException {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      SudokuBoard invalid = new SudokuBoard("boards/col-violation.sdk");
      solvedBoard(invalid);
      invalidBoard(invalid);
      SudokuBoard complete = new SudokuBoard("boards/valid-complete.sdk");
      solvedBoard(complete);
      invalidBoard(complete);
      SudokuBoard board = new SudokuBoard("boards/very-fast-solve.sdk");
      solvedBoard(board);
      invalidBoard(board);
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println();
      System.out.print("Solving board...");
      long start = System.currentTimeMillis();
      board.solve();
      long stop = System.currentTimeMillis();
      System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
      System.out.println();
      System.out.println(board);
      SudokuBoard board1 = new SudokuBoard("boards/fast-solve.sdk");
      solvedBoard(board1);
      invalidBoard(board1);
      System.out.println("Initial board");
      System.out.println(board1);
      System.out.println();
      System.out.print("Solving board...");
      long start1 = System.currentTimeMillis();
      board1.solve();
      long stop1 = System.currentTimeMillis();
      System.out.printf("SOLVED in %.3f seconds.\n", ((stop1-start1)/1000.0));
      System.out.println();
      System.out.println(board1);
   }
}
/**
 * the board is not solved yet
the board is in an invalid state so it cannot be solved
the board is already solved
the board is in a valid state so it can be solved
the board is not solved yet
the board is in a valid state so it can be solved
Initial board
-------------------------------
|    3  4 | 6  7  8 | 9  1  2 |
|    7  2 | 1  9  5 | 3  4  8 |
| 1  9  8 | 3  4  2 | 5  6  7 |
-------------------------------
|       9 |    6  1 | 4  2  3 |
|    2  6 | 8  5  3 | 7  9  1 |
|    1  3 | 9  2  4 |    5  6 |
-------------------------------
|    6  1 | 5  3  7 | 2  8  4 |
|    8    | 4  1  9 | 6  3  5 |
| 3  4  5 |    8  6 | 1  7  9 |
-------------------------------

Solving board...SOLVED in 0.003 seconds.

-------------------------------
| 5  3  4 | 6  7  8 | 9  1  2 |
| 6  7  2 | 1  9  5 | 3  4  8 |
| 1  9  8 | 3  4  2 | 5  6  7 |
-------------------------------
| 8  5  9 | 7  6  1 | 4  2  3 |
| 4  2  6 | 8  5  3 | 7  9  1 |
| 7  1  3 | 9  2  4 | 8  5  6 |
-------------------------------
| 9  6  1 | 5  3  7 | 2  8  4 |
| 2  8  7 | 4  1  9 | 6  3  5 |
| 3  4  5 | 2  8  6 | 1  7  9 |
-------------------------------
the board is not solved yet
the board is in a valid state so it can be solved
Initial board
-------------------------------
| 8  2  7 | 1  5  4 | 3  9  6 |
| 9  6  5 |    2  7 | 1  4  8 |
| 3  4  1 | 6     9 | 7  5  2 |
-------------------------------
|         |         |         |
|         |         |         |
| 6  1  8 | 9  7    | 4  3  5 |
-------------------------------
| 7  8  6 | 2  3  5 |    1  4 |
| 1  5  4 | 7  9  6 | 8     3 |
| 2  3  9 | 8  4    |         |
-------------------------------

Solving board...SOLVED in 0.003 seconds.

-------------------------------
| 8  2  7 | 1  5  4 | 3  9  6 |
| 9  6  5 | 3  2  7 | 1  4  8 |
| 3  4  1 | 6  8  9 | 7  5  2 |
-------------------------------
| 4  7  2 | 5  1  3 | 6  8  9 |
| 5  9  3 | 4  6  8 | 2  7  1 |
| 6  1  8 | 9  7  2 | 4  3  5 |
-------------------------------
| 7  8  6 | 2  3  5 | 9  1  4 |
| 1  5  4 | 7  9  6 | 8  2  3 |
| 2  3  9 | 8  4  1 | 5  6  7 |
-------------------------------
 */