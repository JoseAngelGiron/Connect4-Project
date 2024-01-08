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

}
