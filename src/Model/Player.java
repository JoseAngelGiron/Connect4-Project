package Model;

public class Player {

    private String name;

    private char token;

    private int wins;

    public Player(){
        this("",' ', 0);

    }

    public Player(String name, char token, int wins){
        this.name = name;
        this.token = token;
        this.wins = wins;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getToken() {
        return token;
    }

    public void setToken(char token) {
        this.token = token;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }





    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", token=" + token +
                ", wins=" + wins +
                '}';
    }
}
