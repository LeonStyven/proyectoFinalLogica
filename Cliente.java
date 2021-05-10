import java.util.Scanner;
import java.net.Socket;
import java.io.*;

public class Cliente {

    public static void main(){

        try {

            System.out.println("Entraste como cliente");
                //Ingreso por teclado
                Scanner teclado = new Scanner(System.in);

                final String HOST = teclado.nextLine();//IP del servidor
                final int PUERTO = 5000;
                DataInputStream in;
                DataOutputStream out;
    
                //Conexion con el servidor
                Socket sc = new Socket(HOST,PUERTO);
    
                //Variables para la comunicacion con el servidor
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                int mensaje;

                System.out.println("Conexion con el servidor Exitosa!");

                menu menu = new menu();
                menu.imprimirmenu();

                do {
                    mensaje = in.readInt();
                    System.out.println("El servidor escogio la opcion: " + mensaje);


                    /*ejecucion ejecucion = new ejecucion();
                    ejecucion.ejecutar(mensaje);*/
                } while (mensaje!=6);
    
                

                

        } catch (Exception e) {
            System.out.println(e);
        }

        
        

    }
}
