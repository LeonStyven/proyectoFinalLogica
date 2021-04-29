import java.util.Scanner;


public class opciones{
    
    public static void menu(String[] canciones){

        Scanner reply = new Scanner(System.in);
        int dato, salir;

        salir = 2; //Eleccion del valor necesario para cerrar el programa, tambien es el valor maximo de oopciones

        do{
            //Parte "Grafica" del menu
            System.out.println("\n" + "Ingrese una opcion");
            System.out.println("1. Mostrar listado de canciones");
            System.out.println("2. Salir");

            dato = reply.nextInt();
            if(dato!=salir && 1<=dato && dato<=salir){
                
                /*Se usa un switch segun la cantidad de opciones, cada caso llama a la funcion correspondiente*/

                switch(dato){
                    case 1: mostrarcanciones(canciones);
                    break;

                }
                



            }else if(dato==salir){
                System.out.println("Tenga buen dia <3");
                reply.close();
            }else{
                System.out.println("Ingrese un valor valido.");
            }
        }while(dato != salir);
            


    }

    public static void mostrarcanciones(String[] canciones){
        
        for(int i=0; i<(canciones.length); i++){
            if(i==0){
                System.out.println("Canciones disponibles: ");
            }
            System.out.println(i+1 + ". " + canciones[i]);
        }

    }
}