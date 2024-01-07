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

        return IO.readInt("Inserte el número de columna que desea");
    }

    public static void showPlayerTurn(boolean playerTurn){

        if(playerTurn){
            System.out.println("Es el turno del jugador 1");
        }else{
            System.out.println("Es el turno del jugador 2");
        }

    }
}


