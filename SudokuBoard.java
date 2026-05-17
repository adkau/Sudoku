// Aaron Kaufman
// CS 143
//HW #3: Sudoku #3 (creating the solve method using recursion)

// Creates a Sudoku Board as an object using a file as the contents of the board
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

    //this method was given in the homework
    //pre: the spot of the mini square actually exists
    //post: returns a 2d array containing only that mini square
    private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }

   //pre: none
   //post: returns valid if the board doesnt have any duplicate values in rows, collumn, or minisquares, as well as all values are an int
   //uses all 3 helper methods
    public boolean isValid() {
        //loops through each mini square
        for(int i = 1; i <= 9; i++) {
            if(isMiniValid(miniSquare(i)) == false) {
                return false;
            }
        }
        //checks for duplicates between each row and col
        if(isRowValid() == true && isColValid() == true) {
            return true;
        } else {
            return false;
        }
    }

    //helper method for isValid
    //pre: none
    //post: returns true if each row contains no duplicate values and all values are  1-9 (0s are a blank space)
    private boolean isRowValid() {
        for(int row = 0; row < board.length; row++) {
            //hashmap to count the amount of times each int occurs
            Map<Integer, Integer> counter = new HashMap<>();
            for(int col = 0; col < board[row].length; col++) {
                int value = board[row][col];
                //zero is my blank space so we want to ignore it
                if (value >= 10 || value < 0) {
                    return false;
                }
                if(value != 0) {
                counter.put(value, counter.getOrDefault(value, 0) + 1);
                }
            }
            //loops through map checking that the count of each number isnt 1 or else that means the number repeats
            for (int count : counter.values()) {
                if (count > 1) {
                    return false;
                }
            }
        }   
        return true; 
    }

    //helper method for isValid
    //pre: none
    //post: returns true if each column contains no duplicate values and all values are 1-9 (0s are a blank space)
    private boolean isColValid() {
        for(int col = 0; col < board[0].length; col++) {
            Map<Integer, Integer> counter = new HashMap<>();
            for(int row = 0; row < board.length; row++) {
                int value = board[row][col];
                //if the value isnt 1 - 9 or 0 which is my blank space
                if (value >= 10 || value < 0) {
                    return false;
                } //zero is my blank space so it can be duplicated
                if(value != 0) {
                counter.put(value, counter.getOrDefault(value, 0) + 1);
                }
            }
            //loops through map checking that the count of each number isnt 1 or else that means the number repeats
            for (int count : counter.values()) {
                if (count > 1) {
                    return false;
                }
            }
        } 
        return true; 
    }

    //helper method for isvalid
    //pre: valid miniSquare location is given (1-9)
    //post: returns true if the mini square doesnt contain any duplicate values and if all values are 1-9 (besides the blank space 0)
    private boolean isMiniValid(int[][] miniSquare) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int row = 0; row < miniSquare.length; row++) {
            for(int col = 0; col < miniSquare[row].length; col++) {
                int value = miniSquare[row][col];
                //if the value isnt 1 - 9 or 0 which is my blank space
                if (value >= 10 || value < 0) {
                    return false;
                }
                if(value != 0) { //ignore 0 because its our blank space
                counter.put(value, counter.getOrDefault(value, 0) + 1);
                }
            }
        }  
        //loops through map checking that the count of each number isnt 1 or else that means the number repeats
        for (int count : counter.values()) {
            if (count > 1) {
                    return false;
            }
        }
        return true;
    }

    //pre: the board is valid and can be solved, otherwise it will return false
    //post: solves the sudoku board using recursion and returns true
    public boolean solve() {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                //loop through to find a blank space

                if(board[row][col] == 0) { //0 is the placeholder for a blank space

                    for(int num = 1; num <= 9; num++) { //loop through each number 1 through 9
                        board[row][col] = num;

                        if(isValid()) { //if the number is a valid move, calls solve again to see if this is the right move to solve the board
                            if(solve() == true) {
                                return true; //if the board is solved, return true
                            }
                        } else {
                            board[row][col] = 0;
                        }
                    }
                    return false; //if no number works, return false
                }
            }
        }
        return true; //if there are no more blank space and the board is valid, return true
    }

    //pre: none
    //post: returns true if the board is solved, false if it is not
    public boolean isSolved() {
        //if there is nine of every single number and the board is valid, the board is solved
        if (isValid() == true && allNumbers() == true) {
            return true;
        } else {
            return false;
        }


    }
    
    //helper method for isSolved
    //pre: none
    //post: returns true if there is 9 of each number
    private boolean allNumbers() {
        Map<Integer, Integer> counter = new HashMap<>(); //map outside the loop because we want every single value on the board not just in each row/col
        for(int col = 0; col < board[0].length; col++) {
            for(int row = 0; row < board.length; row++) {
                int value = board[row][col];
                counter.put(value, counter.getOrDefault(value, 0) + 1);
            }
        }
        for (int count : counter.values()) {
                if (count != 9) { //there has to be a count of 9 for every single number 1-9
                    return false;
                }
            }
        return true; //returns true if all counts are 9
    }
}
