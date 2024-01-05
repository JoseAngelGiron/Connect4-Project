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
                    //A partir de aquí se le muestra la matriz y tienen que ir introduciendo fichas en ella.
                    game.getBoard().initializeBoard();
                    Menu.showBoard(game.getBoard().getBoard());







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





    }
}
