// Aaron Kaufman
// CS 143
// Main Class for the Sudoku Board project
package Sudoku;

import java.io.*;
import java.util.*;

public class PlaySudoku {
    //pre: nothing
    //post: main method that prints the sudoku board using the SudokuBoard class
    public static void main(String[] args) throws FileNotFoundException {
        SudokuBoard game = new SudokuBoard("Sudoku/data1.sdk");
        System.out.println(game);
    }
    
}
/* This is the output of the main method
-------------------------------
| 2       | 1     5 |       3 |
|    5  4 |         | 7  1    |
|    1    | 2     3 |    8    |
-------------------------------
| 6     2 | 8     7 | 3     4 |
|         |         |         |
| 1     5 | 3     9 | 8     6 |
-------------------------------
|    2    | 7     1 |    6    |
|    8  1 |         | 2  4    |
| 7       | 4     2 |       1 |
-------------------------------
*/