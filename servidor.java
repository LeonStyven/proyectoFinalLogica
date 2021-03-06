import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class servidor {

    public static void main(){

        try {
            //Variable para el manejo del menu
            int centinela = 0;
            int subOpcion = 0;	
            Audio audio = new Audio();
            
            ServerSocket servidor;
            Socket sc;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO = 5000;


            //Llamada de funciones
            //Programa programa = new Programa();

            ejecucion ejecucion = new ejecucion();
            ejecucion.ejecutar(centinela, subOpcion, audio);

            System.out.println("         |               .                     .                               .         .                                     .   |.");
            System.out.println("         |        .                 .                  .        . .                    .              .                            |.");
            System.out.println("         |    ==============================================================================================================       |.");
            System.out.println("         |                 .         .                .       .                .                         .          .      .       |.");
            System.out.println("         |         .                          .           .             .                 .                                        |.");
            ejecucion.imprimir("         |                    Como director, tú serás quien elija la canción que todos los usuarios escucharán    .        .       |.");
            System.out.println("         |        .         .                                                                                     .                |.");
            System.out.println("         |                       .           .     .         .                     .              .                       .        |.");
            System.out.println("         |    ==============================================================================================================       |.");
            System.out.println("         |       .          .             .             .                     .                 .         .           .            |.");
            ejecucion.imprimir("         |      .          .           .           .          Iniciando Servidor...      .        .              .          .      |.");
            System.out.println("         |               .              .        .             .             .    .         .              .                   .   |.");


            //Iniciar Servidor
            servidor = new ServerSocket(PUERTO);

            //Obtener direccion IP
            tipoUsuario us = new tipoUsuario();
            us.direccionIP();

            System.out.println("         |      .                    .             .               .                  .               .         .            .     |.");
            System.out.println("         |    ==============================================================================================================       |.");
            System.out.println("         |      .      .         .          .       .            .      .      .             .       .     .             .         |.");
            ejecucion.imprimir("         |              .       .      .      .          .    Esperando Conexión...             .    .          .             .    |.");
            System.out.println("         |         .              .        .       .          .                 .       .           .                .             |.");
            System.out.println("         |    ==============================================================================================================       |.");
            sc = servidor.accept();

            //Variables para la comunicacion del servidor con el cliente
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            System.out.println("         |               .          .   .         .               .               .         .                .         .       .   |.");
            ejecucion.imprimir("         |      .                          .            .   Conexión establecida!        .            .                .           |.");
            System.out.println("         |      .             .          .         .             .             .      .                                .    .      |.");
            System.out.println("         |    ==============================================================================================================       |.");
            System.out.println("         |      .     .           .    .            .          .           .         .     .                 .           .     .    |.");


            do {

                inicio inicio = new inicio();


                menu menu = new menu();
                menu.imprimirmenu();

                System.out.print("         |    .      .  .        .          .             . .     > ");
                //Solicitud del centinela
                centinela = ConsoleInput.getInt();


                if(centinela >= 1 && centinela <= 6){

                    if(centinela==4 || centinela == 6){
                        System.out.println("         |               .        .             .              .                .         .                .                   .   |.");
                        System.out.println("         |     . .   .      .     .      .       No hace falta ingresar una subopcion.         .      .   ..          .         .  |.");
                        System.out.println("         |               .                     .            .                  .         .                       .             .   |.");

                    }else{  

                        System.out.println("         |    ==============================================================================================================       |.");
                        System.out.println("         |               .        .             .              .                .         .                .                   .   |.");
                        System.out.println("         |     . .   .      .     .      .         .   ingrese una Subopcion           .          ..                  .         .  |.");
                        System.out.println("         |     . .   .      .     .      .      La sub-opcion es el indice de la cancion           .     .            .         .  |.");
                        System.out.println("         |     . .   .      .     .      .           Debe ser un número entero           .     .            .      .            .  |.");
                        System.out.println("         |               .                     .            .                  .         .                       .             .   |.");
                        System.out.print("         |    .      .  .        .          .             . .    > ");
                        subOpcion = ConsoleInput.getInt();
                        System.out.println("         |               .        .             .              .                .         .                .                   .   |.");
                        System.out.println("         |    ==============================================================================================================       |.");

                    }


                    out.writeInt(centinela);//Envio del centinela
                    out.writeInt(subOpcion);//envio de la subopcion

                    //ejecucion ejecucion = new ejecucion();
                    ejecucion.ejecutar(centinela, subOpcion, audio);

                    if(centinela==6){
                        System.out.println("         |               .        .             .              .                .      .                   .                   .   |.");
                        System.out.println("         |     . .       .         .           .        Cerrando Conexión...             .      .   .      .          .         .  |.");
                        System.out.println("         |               .                     .            .                  .         .                       .             .   |.");
                        sc.close();
                        inicio.despedida();

                    }
                }else{
                    System.out.println("         |               .        .             .              .                .         .                .                   .   |.");
                    System.out.println("         |     . .   .      .     . .  .           .       Error, dato inválido         .      .   .       .          .         .  |.");
                    System.out.println("         |               .                     .            .                  .         .                       .             .   |.");
                }

            } while (centinela!=6);
        } catch (Exception e) {
            System.out.println(e);
        }

        


    }
}
