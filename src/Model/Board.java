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
        for (int i =0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++){
                board[i][j] = ' ';
            }

        }

    }

    public void imprimeArrayEnteros(){

        for (int i=0;i< board.length;i++) {

            System.out.println();

            for (int j=0;j< board[i].length;j++){

                System.out.print("| "+board[i][j]+" |");

            }

        }
    }

    @Override
    public String toString() {
        String board1 = "";
        for (int i =0;i< this.board.length;i++) {
            board1 += "|";
            for (int j=0;j<this.board[i].length;j++) {
                if(j!=board[i].length-1)
                    board1 += " "+board[i][j]+" |";
                else{
                    board1 += " "+board[i][j]+" ";
                }
            }
            board1 += "| \n";
        }

        return board1;
    }
}
