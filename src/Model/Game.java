package Model;

import java.io.Serializable;
import java.util.Objects;

public class Game implements Serializable {

    private Player[] players;

    private Board board;

    private boolean turn;


    public Game(){
        this(new Player[2], new Board(), false);

    }


    public Game(Player[] players, Board board, boolean turn) {
        this.players = players;
        this.board = board;
        this.turn = turn;
    }



    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     * Esta función se encarga de establecer los jugadores.
     */
    public void addPlayers() {

        for (int i = 0; i < players.length; i++) {
                if(i==0) {
                    players[i] = new Player("", 'O', 0);
                }else{
                    players[i] = new Player("", 'X', 0);
                }
        }

    }

    /**
     * Esta función añade el nombre del jugador
     * @param name recibe el nombre del jugador que se va a añadir
     */
    public void addName(String name){
        boolean noAsigned =true;
        for (int i=0;i< players.length && noAsigned ;i++) {
            if (Objects.equals(players[i].getName(), "")){
                players[i].setName(name);
                noAsigned = false;
            }
        }
    }

    /**
     * Esta función comprueba los nombres de los jugadores y devuelve true si el nombre es válido porque no está asignado, o, por el contrario,
     * devuelve false porque el nombre ya está en uso
     * @param name el nombre de jugador que se va a comprobar
     * @return nameValid, que será true o false
     */
    public boolean validateName(String name){
        boolean nameValid = true;
        for (int i=0;i< players.length ;i++) {
            if (Objects.equals(players[i].getName(), name)){
                nameValid = false;
            }
        }
        return nameValid;
    }

    /**
     * Esta función se encarga de escoger al jugador que le toca, utilizando el atributo "turn"
     *
     * @return el jugador del que se trata.
     */
    public Player choosePlayer(){
        Player player = players[1];

        if (turn){
            player = players[0];
        }


        return player;
    }

    /**
     * Esta función se encarga de sumar una victoria a las victorias totales del jugador en cuestión. Para determinar el
     * jugador que ha ganado, usa el atributo turn
     */
    public void plusVictory() {
        if(turn){
            players[0].setWins(players[0].getWins()+1);
        }else{
            players[1].setWins(players[1].getWins()+1);
        }

    }


}
