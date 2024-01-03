package Model;

import java.util.Arrays;

public class Board {

    private char[][] board = new char[4][6];



    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }


    public void initializeBoard(){
        System.out.print("\u001B[34m");
        for (int i =0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++){
                board[i][j] = 'O';
            }

        }

    }

    public  void imprimeArrayEnteros(){

        for (int i=0;i< board.length;i++) {
            System.out.println();
            for (int j=0;j< board[i].length;j++){
                System.out.print(board[i][j]+" ");

            }

        }
    }

    @Override
    public String toString() {

        for (int i =0;i< this.board.length;i++) {
            for (int j=0;j<this.board[i].length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        return null;
    }
}
