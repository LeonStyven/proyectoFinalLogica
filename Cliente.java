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
                int centinela, subOpcion;

                System.out.println("Conexion con el servidor Exitosa!");


                do {
                    menu menu = new menu();
                    menu.imprimirmenu();

                    centinela = in.readInt();
                    System.out.println("El servidor escogio la opcion: " + centinela);
                    
                    subOpcion = in.readInt();
                    System.out.println("Subopcion: " + subOpcion);


                    ejecucion ejecucion = new ejecucion();
                    ejecucion.ejecutar(centinela, subOpcion);

                } while (centinela!=6);
    
                

                

        } catch (Exception e) {
            System.out.println(e);
        }

        
        

    }
}
