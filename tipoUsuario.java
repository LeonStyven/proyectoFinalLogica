import java.util.Scanner;
import java.net.InetAddress;

public class tipoUsuario {
    public int introduccion(){


        //Declaracion de variables
        Scanner teclado = new Scanner(System.in);
        String tipoUsuario = "";
        int datoValido = 0; //Repite la ejecucion del programa si el usuario ingresa un dato invalido

        inicio inicio = new inicio();

        do {

            try {
                System.out.println("         |               .                     .           .                   .         .                                      .  |.");
                System.out.println("         |        .        .   .           .    .             .                   .                      .        .      .         |.");
                System.out.println("         |                                             .                                    .         .                    .       |.");
                System.out.println("         |      .     .    .         .   .    .          SELECCIONE UN TIPO DE USUARIO                     .         .             |.");
                System.out.println("         |             .           .                           .              .         .              .        .      .        .  |.");
                System.out.println("         |     .            .            .                       1. Director             .               .                   .   . |.");
                System.out.println("         |                                      .                2. Oyente        .              .        .      .         .       |.");
                System.out.println("         |         .       .    .       .                                   .                    .              .              ..  |.");
                System.out.print  ("                                                             Tipo de Usuario:  ");
                tipoUsuario = teclado.nextLine();


                //Posibles errores a la hora de leer un caracter
            } catch (java.util.InputMismatchException e) {
                System.out.println("         |               .                     .           .                   .         .                                      .   |.");
                System.out.println("         |            .          .  ..  .             .                .               .    .   .   .                   .   .       |.");
                System.out.println("         |      .               .               .      .     Respuesta inválida                 .      .          .                 |.");
                System.out.println("         |               .                     .           .                   .         .                                      .   |.");
                System.out.println("         |            .          .  ..  .             .                .               .    .   .   .                   .   .       |.");

                inicio.despedida();
            }

            //Comparacion de respuesta
            if(tipoUsuario.equals("1") || tipoUsuario.equals("2")){
                datoValido = 1;
            }else{
                System.out.println("         |               .                     .           .                   .         .                                      .   |.");
                System.out.println("         |            .          .  ..  .             .                .               .    .   .   .                   .   .       |.");
                System.out.println("         |      .               .               .      .     Respuesta inválida                 .      .          .                 |.");
                System.out.println("         |               .                     .           .                   .         .                                      .   |.");
                System.out.println("         |            .          .  ..  .             .                .               .    .   .   .                   .   .       |.");
                datoValido = 0;

            }

        } while (datoValido==0);
        
        //1.75 2.25 0.70
        
        return Integer.parseInt(tipoUsuario);

    } 

    public void direccionIP() throws Exception{

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("         |               .                     .           .                   .         .                                    .   |.");
        System.out.println("         |            .          .  ..  .             .                .               .    .   .   .                 .   .       |.");
        System.out.println("         |               .            .           .    .   IP Local : "+address.getHostAddress()+"      .     .  .       .   ..           .       |.");

    }

}
