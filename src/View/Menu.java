package View;

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
        System.out.println("3. Salir \n");


        return IO.readInt("Elija una opción");


    }

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

    public static String selectName(int njugador){


        return IO.readName("Inserte el nombre del jugador "+(njugador+1));
    }

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

    public static int selectColumn(){

        return IO.readInt2("Inserte el número de columna que desea", 1, 4);
    }

    public static void showPlayerTurn(boolean playerTurn, String name1, String name2){

        if(playerTurn){
            System.out.println("Es el turno del jugador 1: "+name1+"\n");
        }else{
            System.out.println("Es el turno del jugador 2: "+name2+"\n");
        }

    }

    public static void showWinner(boolean tie, boolean playerTurn, String player1, String player2){

        if(tie){
            System.out.println("Ha habido un empate");
        } else if (playerTurn) {
            System.out.println("El ganador es el jugador 1: "+player1);

        }else{
            System.out.println("El ganador es el jugador 2: "+player2);
        }

    }
    public static void showGoodBye(){

        System.out.println("¡Ha elegido salir del programa! ¡Que pases un buen día!");
    }

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


}


