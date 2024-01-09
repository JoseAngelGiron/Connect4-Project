package Model;

import java.io.Serializable;
import java.util.Arrays;

public class Board implements Serializable {

    private char[][] board;


    public Board(){
        this(4,4);
    }
    public Board(int row, int column){
        this.board = new char[row][column];
    }


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    /**
     * Esta función se encarga de vaciar el tablero, es decir, de rellenarlo con espacios en blanco.
     */
    public void initializeBoard(){
        new Board();
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');

        }

    }

    /**
     * Esta función comprueba una columna y nos devuelve si esta rellena o en su caso, si todavía tiene espacios en blanco
     * @param numberColumn recibe un número, que será el de la columna a comprobar
     * @return fullColumn, que será si una columna está completa o, por el contrario, todavía se puede seguir introduciendo fichas en ella
     */
    public boolean checkIfColumnIsFull(int numberColumn){
        boolean fullColumn=true;

        for (int i=0;i<board.length && fullColumn;i++){
            if(board[i][numberColumn-1]==' '){
                fullColumn =false;
            }
        }

        return !fullColumn;
    }

    /**
     * Esta función inserta una ficha en una columna del tablero.
     * @param column El número de la columna donde va a insertar la ficha
     * @param player La ficha del jugador que se va insertar
     */
    public void insertToken(int column, Player player){
        boolean tokenNotInserted= true;

        for (int i = board.length-1;i>=0 && tokenNotInserted;i--){

            if(board[i][column-1]==' '){
                board[i][column-1] = player.getToken();
                tokenNotInserted = false;

            }
        }


    }

    /**
     * Esta función recorre el tablero y comprueba si hay espacios vacíos.
     * @return boardIsFull que será true en el caso de que este completo y false si encuentra algún espacio sin asignar
     */
    public boolean checkIfBoardNotComplete(){
        boolean boardNotComplete = false;
        for (int i =0;i< board.length && !boardNotComplete;i++) {

            for (int j=0;j<board[i].length && !boardNotComplete;j++) {
                if(board[i][j]==' '){
                    boardNotComplete= true;
                }

            }

        }

        return boardNotComplete;
    }

    public Player pickAPlayer(boolean playerTurn, Game game){
        Player player = game.getPlayers()[1];


        if(playerTurn){
            player = game.getPlayers()[0];
        }
        return player;
    }

    public boolean determineWinner(boolean playerTurn, Game game){
        return !( reverseDiagonal(pickAPlayer(playerTurn, game)) || diagonal(pickAPlayer(playerTurn, game)) || horizontal(pickAPlayer(playerTurn, game)) || vertical(pickAPlayer(playerTurn, game)));
    }

    public boolean vertical(Player player){

        int acu=0;
        boolean isWinner = true;
        for (int i= board[0].length-1; i>=0 && isWinner;i--){
            char token = board[0][i];
            for(int j=0; j<board.length && player.getToken() == token ;j++){
                if(token== board[j][i]){
                    acu++;
                }
                if (acu==4){
                    isWinner = false;
                }
            }
            acu =0;

        }

        return !isWinner;
    }

    public boolean horizontal(Player player) {
        boolean isWinner = true;
        int acu;
        char token;


        for (int i=0; i < board.length ; i++){
            token = board[i][0];
            acu=0;
            for(int j=0;j<board[i].length && player.getToken() == token;j++)
                if (token == board[i][j]) {
                    acu++;
                }
            if(acu==4){
                isWinner = false;
            }

        }



        return !isWinner;
    }
    public boolean diagonal(Player player){
        boolean isWinner=true;
        int acu =0;
        for (int i=0;i< board.length;i++) {
            for (int j=0;j< board[i].length;j++){
                if(board[i][j]== player.getToken() && i==j){
                    acu++;

                }
                if(acu==4){
                    isWinner = false;

                }
            }
        }
        return !isWinner;
    }

    public boolean reverseDiagonal(Player player){
        boolean isWinner=true;
        int acu =0;


            char token = board[0][board.length-1];
            for (int i=0 ,j=board.length-1; i< board.length && player.getToken() == token; i++,j--){

                    if(j == board.length-1-i){
                        acu++;

                    }
                    if(acu==4){
                        isWinner = false;
                    }

            }

        return !isWinner;

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
