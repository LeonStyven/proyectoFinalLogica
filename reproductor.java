import java.util.Scanner;

public class reproductor {
    public static void main(String[] args){

        menu();

    }
    

public static void menu(){

    Scanner reply = new Scanner(System.in);
    int dato, salir;

    salir = 5; //Eleccion del valor necesario para cerrar el programa

    do{
        //Parte "Grafica" del menu
        System.out.println("Ingrese una opcion");

        dato = reply.nextInt();
        if(dato!=salir && 1<=dato && dato<=salir){
            
            /*Se usa un switch segun la cantidad de opciones, cada caso llama a la funcion correspondiente*/
            switch(dato){
                case 1: mostrarcanciones();
                break;
            }
            



        }else if(dato==salir){
            System.out.println("Tenga buen dia <3");
        }else{
            System.out.println("Ingrese un valor valido.");
        }
    }while(dato != salir);
        


}


    
}
