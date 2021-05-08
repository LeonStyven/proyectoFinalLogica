import java.util.Scanner;
import java.net.InetAddress;

public class tipoUsuario {
    public int introduccion(){

        Scanner teclado = new Scanner(System.in);
        int dato = 0;


        System.out.println("         |                                                                                                                        |.");
        System.out.println("         |                                                                                                                        |.");
        System.out.println("         |                                    SELECCIONE UN TIPO DE USUARIO                                                       |.");
        System.out.println("         |                                                                                                                        |.");
        System.out.println("         |                                            1. Director                                                                 |.");
        System.out.println("         |                                            2. Oyente                                                                   |.");
        System.out.println("         |                                                                                                                        |.");
        System.out.print("         |                                       Tipo de Usuario:  ");


        dato = teclado.nextInt();

        return dato;

    } 

    public void direccionIP() throws Exception{

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("         |                                           IP Local : "+address.getHostAddress()+"                                                      |.");

    }
}
