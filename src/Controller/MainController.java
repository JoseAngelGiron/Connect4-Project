package Controller;

import Model.Game;
import Persistence.Serializator;
import View.Menu;

import java.util.Arrays;

public class MainController {
    public static Game game;

    /**
     * Esta función se encarga iniciar la aplicación. Llama a la vista para introducir una opción entre las disponibles y pasa el
     * control al controlador
     */
    public static void startApp(){
        int option = -1;
        do {
            option = Menu.mainMenu();

            mainController(option);

            if(option>4 || option<1)
                System.out.println("El número introducido no se corresponde con una opción valida, pruebe de nuevo");


        }while (option!=4);


    }

    /**
     * Esta función se encarga de recibir la opción de la función startApp y de pasar entre las distintas opciones, tales
     * como iniciar el juego, mostrar las reglas, cargar partida o mostrar una despedida.
     * @param option que será lo que se use para determinar que se ejecuta.
     */
    public static void mainController(int option){

            switch (option) {
                case 1:
                    boolean nextRound=false;
                        if (game == null) {
                            game = new Game();
                            inialitizeGame(game);
                        }else{
                            Menu.showStateOfPlay(game);
                            game.setTurn(!game.isTurn());
                        }

                    do {
                        if(nextRound){
                            game.getBoard().initializeBoard();

                        }

                        Menu.showBoard(game.getBoard().getBoard());


                        while (game.getBoard().determineWinner(game) || !game.getBoard().checkIfBoardNotComplete()) {
                            game.setTurn(!game.isTurn());
                            chooseWhatToDo(game);


                            Menu.showBoard(game.getBoard().getBoard());
                        }
                        game.plusVictory();
                        Menu.showWinner(!game.getBoard().checkIfBoardNotComplete(), game.isTurn(), game.getPlayers()[0].getName(), game.getPlayers()[1].getName());
                        nextRound = Menu.anotherRound();

                    }while(nextRound);

                    break;

                case 2:
                    Menu.rules();
                    break;

                case 3:
                    Game game1 = Serializator.desearize("gameConnect.bin");
                    if(game1!=null){

                        System.out.println("Ha cargado la partida correctamente");
                        System.out.println("Al iniciar partida, se mostraran los datos de la misma !!");
                        game = game1;

                    }else{
                        System.out.println("No se ha podido cargar");
                    }
                    break;

                case 4:
                    Menu.showGoodBye();
                    break;

            }

    }

    /**
     * Esta función se encarga de iniciar el juego, creando los jugadores.
     * Para ello hace uso de game y funciones de la clase Game y de la vista, así como de la clase Board
     * @param game que será el objeto que contiene todos los datos para iniciar el juego.
     */
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

    /**
     * Esta función se encarga de insertar una ficha en el tablero. Para ello, hace uso de las funciones de la vista,
     * así, como del tablero para comprobar si una columna está llena.
     * @param game que será el objeto que contiene todos los datos necesarios para llevar adelante el juego.
     */
    public static void insertToken(Game game){
        boolean columnHasSpace;

        do {

            int numberOfColumn =Menu.selectColumn();
            columnHasSpace =game.getBoard().checkIfColumnIsFull(numberOfColumn);

            if(columnHasSpace){
                game.getBoard().insertToken(numberOfColumn, game.choosePlayer());
            }else{
                System.out.println("La columna seleccionada no tiene espacio suficiente, pruebe de nuevo, por favor");
            }


        }while(!columnHasSpace);

    }

    /**
     * Esta función es la encargada de plantear al usuario las posibilidades que tiene haciendo uso de la función de la vista,
     * así como de hacer una acción
     * @param game que será el objeto que tiene los datos relativos a la partida en curso.
     */
    public static void chooseWhatToDo(Game game){
        boolean tokenNotInserted= true;

        do{
            Menu.showPlayerTurn(game.isTurn(), game.getPlayers()[0].getName(), game.getPlayers()[1].getName());
            int option = Menu.selectOption();
            switch (option){
                case 1:

                    insertToken(game);
                    tokenNotInserted=false;

                    break;
                case 2:
                    Serializator.serialize(game, "gameConnect.bin");
                    System.out.println("¡Ha guardado la partida correctamente!");
                    System.out.println("Puede cerrar después de leer este mensaje, y reanudar desde donde lo dejo en el menu principal.");
                    System.out.println("La partida una vez cargada, comenzara por el turno del jugador que guardo la partida ");
                    break;

            }

        }while(tokenNotInserted);

    }
}
