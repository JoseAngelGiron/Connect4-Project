package Controller;

import Model.Game;
import View.Menu;

public class MainController {
    public static Game game = new Game();

    public static void startApp(){
        int option = -1;
        do {
            option = Menu.mainMenu();

            mainController(option);

            if(option>3 || option<1)
                System.out.println("El número introducido no se corresponde con una opción valida, pruebe de nuevo");


        }while (option!=3);


    }

    public static void mainController(int option){

            switch (option) {

                case 1:
                    inialitizeGame(game);
                    Menu.showBoard(game.getBoard().getBoard());
                    boolean playerTurn= false;

                    while( game.getBoard().determineWinner(playerTurn, game) ||  !game.getBoard().checkIfBoardNotComplete()){
                        playerTurn= !playerTurn;
                        chooseWhatToDo(game, playerTurn);

                        Menu.showBoard(game.getBoard().getBoard());
                    }
                    Menu.showWinner(!game.getBoard().checkIfBoardNotComplete(), playerTurn, game.getPlayers()[0].getName(), game.getPlayers()[1].getName());
                    break;
                case 2:
                    Menu.rules();
                    break;
                case 3:
                    Menu.showGoodBye();
                    break;

            }

    }

    public static void inialitizeGame(Game game){
        game.addPlayers();
        int count = 0;
        String name;

        do{
            name = Menu.selectName(count);
            boolean validatedName = game.validateName(name);
            if(validatedName){
                game.addName(name);
                count++;
            }
            else{
                System.out.println("El nombre introducido no puede estar vacío o ser el del otro jugador");
            }
        }while(count<2);

        game.getBoard().initializeBoard();





    }

    public static void insertToken(Game game, boolean playerTurn){
        boolean columnHasSpace;


        do {

            int numberOfColumn =Menu.selectColumn();
            columnHasSpace =game.getBoard().checkIfColumnIsFull(numberOfColumn);

            if(columnHasSpace){
                game.getBoard().insertToken(numberOfColumn, game.choosePlayer(playerTurn));
            }else{
                System.out.println("La columna seleccionada no tiene espacio suficiente, pruebe de nuevo, por favor");
            }


        }while(!columnHasSpace);

    }

    public static void chooseWhatToDo(Game game, boolean playerTurn){
        boolean tokenNotInserted= true;
        do{
            Menu.showPlayerTurn(playerTurn, game.getPlayers()[0].getName(), game.getPlayers()[1].getName());
            int option = Menu.selectOption();
            switch (option){
                case 1:

                    insertToken(game, playerTurn);
                    tokenNotInserted=false;

                    break;
                case 2:

                    break;

            }

        }while(tokenNotInserted);

    }
}
