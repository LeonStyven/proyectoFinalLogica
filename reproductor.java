//Importacion de librerias
import java.util.Scanner;

public class reproductor{
    public static void main(String[] args){

        int opcion = 0;

        Scanner entrada = new Scanner(System.in);

        do{
            System.out.println("Desea ingresar como?...");
            System.out.println("1. Director");
            System.out.println("2. Oyente");

            opcion = (int)entrada.nextInt();

            if(!(opcion == 1 || opcion == 2)){
                System.out.println("Usted ingreso un valor invalido...");
                opcion = 0;
            }

        }while(opcion == 0);

        if(opcion==1){
            System.out.println("Usted ingreso como director");
        }else{
            System.out.println("Usted ingreso como Oyente");
        }
        
        

    }
}
