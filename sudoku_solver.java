/*class Solution{
    public boolean isSafe(char[][] board, int row, int col, int number){
        //row & col
        for (int i=0; i<board.length;i++){
            if(board[i][col] == (char) (number+'0')){
                return false;
            }
            if(board[row][i] == (char) (number+'0')){
                return false;
            }
        }

        //grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        for (int i = sr; i<sr+3; i++){
            for(int j = sc; j<= sc+3;j++){
                if(board[i][j] == (char) (number+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    private static void printSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean helper(char[][] board, int row, int col){
        if(row == board.length){
            return true;
        }

        int nrow =0;
        int ncol =0;
        if (col != board.length -1){
            nrow = row;
            ncol = col++;   // same line next cell
        }
        else{
            nrow = row++;
            ncol = 0;   //next line first cell
        }

        if(board[row][col]!= '.'){
            if(helper(board, nrow, ncol)){
                return true;
            }
        }
        else{
            for (int i = 1;i<=9; i++){
                if(isSafe(board, row, col, i)){
                    board[row][col] = (char) (i+'0');
                    if(helper(board, nrow, ncol)){
                        return true;
                    }
                    else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board){
        helper(board, 0,0);
    }
}

public class sudoku_solver {
    public static void main(String[] args) {
        char sudoku[][] = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution s = new Solution();
        s.solveSudoku(sudoku);
        System.out.println(sudoku[0][0]);
    }
}*/

import java.util.Scanner;

class Solution {
    public boolean isSafe(char[][] board, int row, int col, int number) {
        //column
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == (char)(number+'0')) {
                return false;
            }
        }

        //row
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == (char)(number+'0')) {
                return false;
            }
        }

        //grid
        int sr = 3 * (row/3);
        int sc = 3 * (col/3);

        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(board[i][j] == (char)(number+'0')) {
                    return false;
                }
            }
        }


        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        if(col == board.length-1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if(board[row][col] != '.') {
            return helper(board, nrow, ncol);
        } else {

            //fill the place
            for(int i=1; i<=9; i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i+'0');
                    if(helper(board, nrow, ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    public void printSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}

public class sudoku_solver {
    public static void main(String[] args){
        char sudoku[][] = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        Solution s = new Solution();

        s.solveSudoku(sudoku);
        System.out.println("Input Sudoku: ");
        System.out.println(sudoku);
        System.out.println("output sudoku: ");
        s.printSudoku(sudoku);
    }
}
