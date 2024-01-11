package View;

import java.util.Objects;
import java.util.Scanner;

public class IO {
    /**
     * Función que permite introducir un número al usuario y validar que el mismo es un número
     * @param msg mensaje que se le muestra al usuario antes de que introduzca un número
     * @return el número introducido por el usuario
     */
    public static int readInt(String msg){
        int option = -1;

        Scanner teclado = new Scanner(System.in);
        System.out.println(msg);

            try{
                option = teclado.nextInt();

            }catch (Exception e){
                teclado.nextLine();
                System.out.println("No ha introducido una opción valida, pruebe de nuevo, por favor");

            }

        return option;
    }

    /**
     * Función que se encarga de permitir un nombre al usuario
     * @param msg un mensaje que se le muestra al usuario antes de introducir el nombre
     * @return el nombre introducido por el usuario
     */
    public static String readName(String msg){
        String name;
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg+":");

        name = teclado.nextLine();

        return name;
    }

    /**
     * Función que permite introducir un número al usuario, entre 2 números en concreto
     * @param msg mensaje que se muestra al usuario antes de introducir el número
     * @param n1 el primer número, el número introducido debe estar por encima de este
     * @param n2 el segundo número, el número introducido debe estar por debajo de este
     * @return el número introducido, siempre que se encuentre entre el n1 y el n2.
     */
    public static int readInt2(String msg, int n1, int n2){
        int option= -1;
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg);

        do{

            try{
                option = teclado.nextInt();

            }catch (Exception e){
                teclado.nextLine();
                System.out.println("No ha introducido una opción valida, pruebe de nuevo, por favor");

            }
            if (option<n1 || option>n2){
                System.out.println("La opción contemplada debe estar entre "+ n1 +" y "+ n2 +". Pruebe de nuevo, por favor");
            }

        }while (option<n1 || option>n2);


        return option;
    }

    /**
     * Función que se encarga de permitir introducir un caracter que sea 's' o 'n' y en función del
     * carácter introducido devuelve true o false
     * @param msg El mensaje que se muestra al usuario antes de introducir el carácter
     * @return true o false, en función de lo que introduzca
     */
    public static boolean readOption(String msg) {

        Scanner teclado = new Scanner(System.in);
        String option;

        boolean optionPositive=true;

        do {
            System.out.println(msg + ": ");
            option = teclado.nextLine();

            if (!Objects.equals(option, "s") && !Objects.equals(option, "n"))
                System.out.println("La opción introducida no se contempla, pruebe de nuevo.");
            if (Objects.equals(option,"n")){
                optionPositive = false;
            }




        }while(!Objects.equals(option, "s") && !Objects.equals(option, "n"));

        return optionPositive;

    }
}
