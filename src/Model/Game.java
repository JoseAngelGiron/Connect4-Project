package Model;

import java.io.Serializable;
import java.util.Objects;

public class Game implements Serializable {

    private Player[] players;

    private Board board;


    public Game(){
        this(new Player[2], new Board());

    }

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;
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


    public Player choosePlayer(boolean playerTurn){
        Player player = players[1];

        if (playerTurn){
            player = players[0];
        }


        return player;
    }


}
