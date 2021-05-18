import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

//Librerias del servidor
import java.net.*;
import java.io.*;

//Librerias del teclado
import java.util.Scanner;


public class Programa{

	public static void main(String[] args) {

		AnsiConsole.systemInstall();
		
		Audio audio = new Audio();
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		int tipoUsuario = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;


		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);

		try{
			//Consolas con vt100 http://braun-home.net/michael/info/misc/VT100_commands.htm
			//System.out.println("Hallo \033[32mgreen\033[0m-text.");
			//System.out.println(ansi().eraseScreen().render("@|red Hello|@ @|green World|@"));
			//System.out.println( ansi().fg(RED).a("Hello").newline().fg(GREEN).a(" World").reset() );
			//System.out.println("\007");
			
			/*imprimirDisplay(4,16);
			Thread.sleep(1000);
			borrarDisplay(4);
			imprimirDisplay(4,16);*/

			Ejecucion ejecucion = new Ejecucion();


			ejecucion.displayVacio(50, 50);


			inicio i = new inicio();
			i.saludo();

			tipoUsuario us = new tipoUsuario();
			tipoUsuario = us.introduccion();

			if(tipoUsuario==1){

				Servidor servidor = new Servidor();
				servidor.main();

			}else if(tipoUsuario==2){

				Cliente cliente = new Cliente();
				cliente.main();

			}else{
				System.out.println("Por favor ingrese \"1\" para Director y \"2\" para Cliente");
			}


		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		finally{
			audio.detener();
		}	
	}
}