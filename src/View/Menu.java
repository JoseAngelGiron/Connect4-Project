package View;

import Model.Game;

public class Menu {
    /**
     * Función que muestra el menu principal
     * @return devuelve la opción que se le introduce por teclado, como consecuencia de la llamada que hace a la función readInt
     */
    public static int mainMenu() {



        System.out.println();
        System.out.println();
        System.out.println("********** Menú **********");
        System.out.println("1. Iniciar Conecta 4");
        System.out.println("2. Ver las reglas");
        System.out.println("3. Cargar partida");
        System.out.println("4. Salir \n");


        return IO.readInt("Elija una opción");


    }

    /**
     * Función que muestra las reglas
     */
    public static void rules(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                    Reglas                                        |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| 1. El objetivo es conectar 4 fichas en horizontal, vertical o perpendicular      |");
        System.out.println("| 2. Se juega por turnos, de forma que en cada turno un jugador inserta una ficha  |");
        System.out.println("| 3. El jugador que conecte 4 fichas es el ganador!                                |");
        System.out.println("| 4. Si ninguno de ellos consigue conectar 4 fichas, se producirá un empate        |");
        System.out.println("|                                                                                  |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");

    }

    /**
     * Función que permite introducir el nombre del jugador
     * @param njugador que será el número del jugador del que vamos a introducir el nombre
     * @return el nombre del jugador
     */
    public static String selectName(int njugador){


        return IO.readName("Inserte el nombre del jugador "+(njugador+1));
    }

    /**
     * Función encargada de mostrar el tablero por la consola de java
     * @param matriz que será el tablero que mostrara por pantalla
     */
    public static void showBoard(char[][] matriz){

        System.out.println("Este es el estado del tablero: \n");

        for (int i =0;i< matriz.length;i++) {
            System.out.print("|");
            for (int j=0;j<matriz[i].length;j++) {

                if(j!=matriz[i].length-1)
                    System.out.print(" "+matriz[i][j]+" |");
                else{
                    System.out.print(" "+matriz[i][j]+" ");
                }


            }
            System.out.print("| \n");

        }

    }

    /**
     * Función que llama a la función del paquete IO para poder interactuar con el usuario e introducir el número de columna
     * @return el número de columna introducido por el usuario
     */
    public static int selectColumn(){

        return IO.readInt2("Inserte el número de columna que desea", 1, 4);
    }

    /**
     * Función encargada de mostrar el turno del jugador, usando para ello el turno en el que se encuentra
     * @param playerTurn El turno de la partida
     * @param name1 el nombre del jugador 1
     * @param name2 el nombre del jugador 2
     */
    public static void showPlayerTurn(boolean playerTurn, String name1, String name2){
        System.out.println();
        if(playerTurn){
            System.out.println("Es el turno del jugador 1: "+name1+"\n");
        }else{
            System.out.println("Es el turno del jugador 2: "+name2+"\n");
        }

    }

    /**
     * Función encarga de mostrar por pantalla el resultado de la partida, siendo quién ha ganado o si ha habido un empate
     * @param tie El dato con el que se determina si ha habido un empate
     * @param playerTurn el turno de la partida
     * @param player1 El nombre del jugador 1
     * @param player2 El nombre del jugador 2
     */
    public static void showWinner(boolean tie, boolean playerTurn, String player1, String player2){

        if(tie){
            System.out.println("Ha habido un empate");
        } else if (playerTurn) {
            System.out.println("El ganador es el jugador 1: "+player1);

        }else{
            System.out.println("El ganador es el jugador 2: "+player2);
        }

    }

    /**
     * Función que se encarga de mostrar un mensaje de salida
     */
    public static void showGoodBye(){

        System.out.println("¡Ha elegido salir del programa! ¡Que pases un buen día!");
    }

    /**
     * Función encargada de mostrar las posibles opciones al usuario e interactuar con el mismo haciendo uso de la
     * función readInt2 para introducir la opción deseada
     * @return un número que será la opción introducida por el usuario en la función readInt2
     */
    public static int selectOption(){
        try {
            Thread.sleep(1000);
            System.out.println("********** ¿Que desea hacer a continuación? ********** \n");
            Thread.sleep(1000);
            System.out.println("1. Insertar ficha");
            Thread.sleep(320);
            System.out.println("2. Guardar el estado de la partida \n");
            Thread.sleep(320);

        }catch (InterruptedException e) {

        }
        return IO.readInt2("Seleccione que quiere hacer a continuación: ", 1, 2);
    }

    /**
     * Función encargada de interactuar con el usuario para mostrarle un mensaje y preguntar si desea jugar
     * otra ronda, haciendo uso de la función readOption
     * @return true o false, en función de la opción introducida por el usuario
     */
    public static boolean anotherRound(){

        return IO.readOption("¿Desea jugar otra ronda? Seleccione 's' para si y 'n' para no");
    }

    /**
     * Función encarga de mostrar los datos de los una vez se carga la misma.
     * @param game que será la partida cargada, para mostrar los datos de los usuario
     */
    public static void showStateOfPlay(Game game) {
        try {

            Thread.sleep(320);
            System.out.println("El jugador número 1 es: " + game.getPlayers()[0].getName() + " Su cantidad de victorias son: " + game.getPlayers()[0].getWins());
            Thread.sleep(320);
            System.out.println("El jugador número 2 es: " + game.getPlayers()[1].getName() + " Su cantidad de victorias son: " + game.getPlayers()[1].getWins() + "\n");
            Thread.sleep(320);


        } catch (InterruptedException e) {

        }
    }
}


