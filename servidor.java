import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class servidor {

    public static void main(){

        try {
            //Variable para el manejo del menu
            int centinela = 0;
            int subOpcion = 0;	

            ServerSocket servidor;
            Socket sc;
            DataInputStream in;
            DataOutputStream out;
            final int PUERTO = 5000;


            //Llamada de funciones
            //Programa programa = new Programa();

            ejecucion ejecucion = new ejecucion();
            ejecucion.ejecutar(centinela, subOpcion);

            System.out.println("         |               .                     .                              .         .                                     .   |.");
            System.out.println("         |        .                 .                  .        ..                    .              .                            |.");
            System.out.println("         |    =============================================================================================================       |.");
            System.out.println("         |                 .         .               .       .                .                         .          .      .       |.");
            System.out.println("         |         .                         .           .             .                 .                                        |.");
            ejecucion.imprimir("         |                   Como director, tú serás quien elija la canción que todos los usuarios escucharán    .        .       |.");
            System.out.println("         |        .         .                                                                                    .                |.");
            System.out.println("         |                       .          .     .         .                     .              .                       .        |.");
            System.out.println("         |    =============================================================================================================       |.");
            System.out.println("         |       .          .            .             .                     .                 .         .           .            |.");
            ejecucion.imprimir("         |      .          .          .           .          Iniciando Servidor...      .        .              .          .      |.");

            //Iniciar Servidor
            servidor = new ServerSocket(PUERTO);

            //Obtener direccion IP
            tipoUsuario us = new tipoUsuario();
            us.direccionIP();

            System.out.println("         |               .              .       .             .             .    .         .              .                   .   |.");
            System.out.println("         |      .                    .            .               .                  .               .         .            .     |.");
            System.out.println("         |    =============================================================================================================       |.");
            System.out.println("         |      .      .         .          .      .            .      .      .             .       .     .             .         |.");
            ejecucion.imprimir("         |              .       .      .      .         .    Esperando Conexión...             .    .          .             .    |.");
            System.out.println("         |         .              .        .       .         .                 .       .           .                .             |.");
            System.out.println("         |    =============================================================================================================       |.");
            System.out.println("         |      .               .                      .                     .               .           ..                   .   |.");
            System.out.println("         |               .                     .                              .         .                                      .   |.");

            sc = servidor.accept();

            //Variables para la comunicacion del servidor con el cliente
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            System.out.println("         |               .          .  .         .               .               .         .                .         .       .   |.");
            ejecucion.imprimir("         |      .                          .           .   Conexión establecida!        .            .                .           |.");
            System.out.println("         |      .             .          .        .             .             .      .                                .    .      |.");
            System.out.println("         |    =============================================================================================================       |.");
            System.out.println("         |                                                                                                                        |.");


            do {

                menu menu = new menu();
                menu.imprimirmenu();

                //Solicitud del centinela
                centinela = ConsoleInput.getInt();


                if(centinela >= 1 && centinela <= 6){

                    if(centinela==4 || centinela == 6){
                        System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                        System.out.println("         |     . .   .      .     .      .       No hace falta ingresar una subopcion.         .         .   ..          .         .  |.");
                        System.out.println("         |               .                     .            .                  .         .                          .             .   |.");

                    }else{

                        System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                        System.out.println("         |     . .   .      .     .      .         .   ingresar una subopcion.         .         .   ..                  .         .  |.");
                        System.out.println("         |               .                     .            .                  .         .                          .             .   |.");
                        subOpcion = ConsoleInput.getInt();
                    }

                    /*switch(centinela){

                        case 1: System.out.println("Ingrese subopcion");
                                subOpcion = ConsoleInput.getInt();
                        break;
                        case 2: System.out.println("Ingrese subopcion");
                                subOpcion = ConsoleInput.getInt();
                        break;
                        case 3: System.out.println("Ingrese subopcion");
                                subOpcion = ConsoleInput.getInt();
                        break;
                        case 4: System.out.println("No hace falta ingresar una subopcion.");
                        break;
                        case 5: System.out.println("Ingrese subopcion");
                                subOpcion = ConsoleInput.getInt();
                        break;
                        case 6: System.out.println("No hace falta ingresar una subopcion.");
                        break;
                        
                    }*/

                    out.writeInt(centinela);
                    out.writeInt(subOpcion);

                    //ejecucion ejecucion = new ejecucion();
                    ejecucion.ejecutar(centinela, subOpcion);

                    if(centinela==6){
                        System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                        System.out.println("         |     . .       .         .           .        Cerrando Conexión...             .         .   .      .          .         .  |.");
                        System.out.println("         |               .                     .            .                  .         .                          .             .   |.");
                        sc.close();
                    }
                }else{
                    System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                    System.out.println("         |     . .   .      .     . .  .           .       Error, dato inválido         .         .   .       .          .         .  |.");
                    System.out.println("         |               .                     .            .                  .         .                          .             .   |.");

                    inicio inicio = new inicio();
                    inicio.despedida();
                }

            } while (centinela!=6);
        } catch (Exception e) {
            System.out.println(e);
        }

        


    }
}
