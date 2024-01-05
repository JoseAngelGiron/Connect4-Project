package Model;

import java.util.Arrays;

public class Board {

    private char[][] board;


    public Board(){
        this(4,6);
    }
    public Board(int column, int row){
        this.board = new char[column][row];
    }


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }


    public void initializeBoard(){
        new Board();
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');

        }

    }



    @Override
    public String toString() {
        String board = "";
        for (int i =0;i< this.board.length;i++) {
            board += "|";
            for (int j=0;j<this.board[i].length;j++) {

                if(j!=this.board[i].length-1)
                    board += " "+this.board[i][j]+" |";
                else{
                    board += " "+this.board[i][j]+" ";
                }


            }
            board += "| \n";

        }

        return board;
    }
}
