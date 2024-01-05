package View;

import java.util.Scanner;

public class IO {

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

    public static String readName(String msg){
        String name;
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg+":");

        name = teclado.nextLine();

        return name;
    }


}
