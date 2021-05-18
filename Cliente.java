import java.util.Scanner;
import java.net.Socket;
import java.io.*;

public class Cliente {

    public static void main(){

        ejecucion ejecucion = new ejecucion(); //Necesario para la impresion de caracteres especiales

        try {

            System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
            System.out.println("         |     . . .           .        .       .    .       Entraste como cliente       . .      .          ..           .        .  |.");
            System.out.println("         |               .                     .            .                  .         .                          .             .   |.");
            Audio audio = new Audio();
            //Ingreso por teclado
            Scanner teclado = new Scanner(System.in);

            System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
            ejecucion.imprimir("              . .   .       .    .        .     .    Ingrese la dirección IP del servidor: ");

                 

            //Ingreso de la IP del servidor
            final String HOST = teclado.nextLine();//IP del servidor

            System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");

            
            final int PUERTO = 5000;
            DataInputStream in;
            DataOutputStream out;
    
            //Conexion con el servidor
            Socket sc = new Socket(HOST,PUERTO);
    
            //Variables para la comunicacion con el servidor
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            int centinela, subOpcion;

            System.out.println("         |               .        .             .              .                .         .       .           .                   .   |.");
            System.out.println("         |      .           .             ..          .Conexion con el servidor Exitosa!  .        .         .         ..          .. |.");
            System.out.println("         |            .            .        .       .                   .             .       .           ..                      .   |.");


            do {
                menu menu = new menu();
                menu.imprimirmenu();

                centinela = in.readInt();

                System.out.println("         |               .        .             .              .                .         .       .           .                   .   |.");
                System.out.println("         |      .           .             ..          El sdfsdfsfdsf    .             .       .           ..                      .   |.");
                    
                subOpcion = in.readInt();

                System.out.println("         |               .        .             .              .                .         .       .           .                   .   |.");
                System.out.println("         |      .           .             ..          El servidor escogio la subOpcion: " + subOpcion + "  .        .         .         ..          .. |.");
                System.out.println("         |            .            .        .       .                   .             .       .           ..                      .   |.");
                

                ejecucion.ejecutar(centinela, subOpcion, audio);

            } while (centinela!=6);
    
                

                

        } catch (Exception e) {
            System.out.println(e);
        }

        
        

    }
}
