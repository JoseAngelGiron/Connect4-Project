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
                        insertToken(game, playerTurn);
                        Menu.showBoard(game.getBoard().getBoard());

                    }

                    if(!game.getBoard().checkIfBoardNotComplete()){
                        System.out.println("Ha habido un empate");
                    } else if (playerTurn) {
                        System.out.println("El ganador es el jugador 1: "+game.getPlayers()[0].getName());

                    }else{
                        System.out.println("El ganador es el jugador 2: "+game.getPlayers()[0].getName());
                    }


                    break;
                case 2:
                    Menu.rules();
                    break;
                case 3:
                    System.out.println("Ha elegido salir del programa. (Poner un mensaje mas elegante y en la vista)");
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
        Menu.showPlayerTurn(playerTurn);

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
}
