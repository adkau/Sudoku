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
   }
   //pre: none
   //post: prints an error message if the board is already solved
   public static void solvedBoard(SudokuBoard board) {
      if (board.isSolved())
         System.err.println("the board is already solved"); 
   }

   public static void main(String[] args) throws FileNotFoundException {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      SudokuBoard invalid = new SudokuBoard("boards/empty.sdk");
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