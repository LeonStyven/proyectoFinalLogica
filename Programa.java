	import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

//Librerias del servidor
import java.net.*;
import java.io.*;

//Librerias del teclado
import java.util.Scanner;


public class Programa{

	public static void displayVacio(int n,int m){
		for (int i=0;i<n;i++) 
		{
			for (int j=0;j<m;j++)
			{
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void imprimirDisplay(int n,int m){
		String simbolo = Math.random()>5?"*":" ";
		for (int i=0;i<n;i++) 
		{
			if(i+1==n)
			{
				simbolo = "#";

			}
			for (int j=0;j<m;j++)
			{
				System.out.print(i+simbolo);
			}
			System.out.println();
		}
	}

	public static void borrarDisplay(int n){
		//Se le suma 1 si se ejecuta con el bat, ya que la ultima linea es el pause
		//for (int i=0;i<=n;i++){
			//System.out.println(ansi().cursorUpLine(i));
		//}
		System.out.println(ansi().cursor(2,1));
		displayVacio(5,6);
		System.out.println(ansi().cursor(1,1));
		System.out.println(ansi().reset());
	}

	public static void animar() throws InterruptedException{
		

		Thread.sleep(1000);
		
/*
		for(int i=0;i<10;i++){
			System.out.print("\r");
			//System.out.print("\r");
			texto = texto+nuevo.charAt(i);
			System.out.print(texto);
			Thread.sleep(1000);
		}*/
	}

	public static String convertirUnicode(String letra,String cadena){
		
		StringBuilder str = new StringBuilder(cadena);
		int indice = -1;
		char caracter = 0;
		indice = str.lastIndexOf(letra);
		
		if(indice>=0 )
		{
			switch(letra){
				case "á": caracter = '\u00E1';
					      break;
				case "é": caracter = '\u00E9';
					      break;
				case "í": caracter = '\u00ED';
					      break;
		        case "ó": caracter = '\u00F3';
					      break;
			    case "ú": caracter = '\u00FA';
					      break;
				case "ñ": caracter = '\u00F1';
					      break;
				case "Á": caracter = '\u00C1';
						  break;
				case "É": caracter = '\u00C9';
						  break;
				case "Í": caracter = '\u00CD';
						  break;
				case "Ó": caracter = '\u00D3';
						  break;
				case "Ú": caracter = '\u00DA';
						  break;
				case "Ñ": caracter = '\u00D1';
						  break;
			}
			// System.out.println("\\u" + Integer.toHexString('÷' | 0x10000).substring(1));
			str.replace(indice,indice+1,""+caracter);
		}

		return str.toString();
	}

	public static void imprimir(String cadena)
	{
		String str; 
		str = convertirUnicode("á",cadena);
		str = convertirUnicode("Á",cadena);
		str = convertirUnicode("á",str);
		str = convertirUnicode("é",str);
		str = convertirUnicode("í",str);
		str = convertirUnicode("ó",str);
		str = convertirUnicode("ú",str);
		str = convertirUnicode("ñ",str);
		str = convertirUnicode("É",str);
		str = convertirUnicode("Í",str);
		str = convertirUnicode("Ó",str);
		str = convertirUnicode("Ú",str);
		str = convertirUnicode("Ñ",str);

		System.out.println(str);
	}

	public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
	{
		StringBuilder str = new StringBuilder();

		for(int i = inicio; i<=fin; i++)
		{
			str.append(data[i]+"\n");		
		}
		/*for (int j = 0; j <= str.length()-1; j ++){
			if(str(j).equals("\u003B")){
				str.replace("\u003B", "\u0020");
			}			
		}*/
		return str;

	}

	public static void main(String[] args) {

		AnsiConsole.systemInstall();
		
		Audio audio = new Audio();
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		int seleccion = 0;
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

			displayVacio(50, 50);


			inicio i = new inicio();
			i.saludo();

			tipoUsuario us = new tipoUsuario();
			seleccion = us.introduccion();

			if(seleccion==1){

				servidor servidor = new servidor();
				servidor.main();

			}else if(seleccion==2){

				Cliente Cliente = new Cliente();
				Cliente.main();

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