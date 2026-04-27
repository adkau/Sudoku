// Aaron Kaufman
// CS 143
// Creating a Sudoku Board
package Sudoku;

import java.util.*;
import java.io.*;

public class SudokuBoard {
    //2d array as the sudoku board, 1-3 first collumn, 4-6 second collum, 7-9 third collumn for layout
    private int[][] board;
    
    //constructor
    //pre: a valid file name is submitted
    //post: initializes the board with the values from the file given
    public SudokuBoard(String file) throws FileNotFoundException{
        this.board = new int[9][9];
        Scanner input = new Scanner(new File(file));
        //we need this count variable to know which grid goes where on the 2d array
        int count = 0;
        while(input.hasNext()) { //while there are still rows to scan
            String s = input.nextLine();
            for (int i = 0; i < 9; i++) {
                //if it is a period
                if(s.charAt(i) == '.') {
                //add a zero so it stays as type int
                    board[count][i] = 0;
                } else {
                //add the number to the board but because its a character, we need to convert it to an int
                board[count][i] = Character.getNumericValue(s.charAt(i));
                }
                //increse
            }
            //increase the count so it moves to the next index of the 2d array
            count++;
        }
    }

    //to string method that formats the sudoku board visually so it looks good when it is printed
    //pre: none
    //post: returns the sudoku board as a string
    public String toString(){
        //creates the top line of the sudoku grid
        String sudoku = "-------------------------------";
        for (int i = 0; i < 9; i++) {
            //creates a new line and adds the line on the left side
            sudoku += "\n";
            sudoku += "|";
            for (int x = 0; x < 9; x++) {
                //if its 0, display a blank space because there is no known value, zero is a placeholder
                if(board[i][x] == 0) {
                    sudoku += "   ";
                } else {
                sudoku += " " + board[i][x] + " "; //add spaces so the board is more spread out
                }
                //adds a seperator between every third number to seperate each 3x3 grid
                if(x == 2 || x == 5) {
                    sudoku += "|";
                }
            }
            sudoku += "|"; //adds the line on the right side of the sudoku grid

            if(i == 2 || i == 5) { //adds a line to seperate every third row, fully making each grid be seperated as a 3x3 grid
                    sudoku += "\n";
                    sudoku += "-------------------------------";
            }
        }
        //adds the bottom line to the sudoku grid
        sudoku += "\n";
        sudoku += "-------------------------------";
        //returns the string
        return sudoku;
    }
}
